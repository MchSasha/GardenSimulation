import java.io.Serializable;
import java.util.ArrayList;

public class Rain implements Serializable {
    private static final long serialVersionUID = 1L;

    public void pourGarden(Garden garden) {
        if(garden == null) return;
        pourBed(garden.getBed());
        pourTrees(garden.getTrees());
    }

    public void pourBed(Bed bed) {
        if(bed ==null) return;
        for(Plant temp : bed.getSpace()) {
            if(temp == null) continue;
            pourPlant(temp);
        }
    }

    public void pourTrees(ArrayList<Tree> trees) {
        for(Plant temp : trees)
            pourPlant(temp);
    }

    public void pourPlant(Plant plant) {
        plant.getWater(this);
    }


}

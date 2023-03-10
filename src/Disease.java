import java.io.Serializable;
import java.util.ArrayList;

public class Disease implements Serializable {
    private static final long serialVersionUID = 1L;

    public void infectGarden(Garden garden) {
        if(garden == null) return;
        infectBed(garden.getBed());
        infectTrees(garden.getTrees());
    }

    public void infectBed(Bed bed) {
        if (bed == null) return;
        for(Plant temp : bed.getSpace()){
            if(temp == null) continue;

            infectPlant(temp);
        }
    }

    public void infectTrees(ArrayList<Tree> trees) {
        for(Plant temp : trees) {
            infectPlant(temp);
        }
    }

    public void infectPlant(Plant plant) {
        plant.useImmunity(this);
    }
}

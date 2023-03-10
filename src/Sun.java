import java.io.Serializable;
import java.util.ArrayList;

public class Sun implements Serializable {
    private static final long serialVersionUID = 1L;

    public void shineInGarden(Garden garden) {
        if(garden == null) return;

        shineBed(garden.getBed());
        shineTrees(garden.getTrees());
    }

    public void shineBed(Bed bed) {
        if(bed == null) return;

        for(Plant temp : bed.getSpace()) {
            if(temp == null) continue;
            shinePlant(temp);
        }
    }

    public void shineTrees(ArrayList<Tree> trees) {
        for(Plant temp : trees)
            shinePlant(temp);
    }

    public void shinePlant(Plant plant) {
        plant.getSun(this);
    }
}

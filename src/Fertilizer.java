import java.io.Serializable;
import java.util.ArrayList;

public class Fertilizer implements Serializable {
    private static final long serialVersionUID = 1L;

    public void fertileGarden(Garden garden) {
        if(garden == null) return;
        System.out.println("--- Сад удобрен");
        fertileBed(garden.getBed());
        fertileTrees(garden.getTrees());
    }

    public void fertileBed(Bed bed) {
        if(bed == null) return;
        for(Plant temp : bed.getSpace()) {
            if(temp == null) continue;

            fertilePlant(temp);
        }
    }

    public void fertileTrees(ArrayList<Tree> trees) {
        for(Plant temp : trees)
            fertilePlant(temp);
    }

    public void fertilePlant(Plant plant) {
        if(plant.getImmunityInfo() > Constants.IMMUNITY_MINIMUM) plant.cureDesease();
        plant.getImmunity();
    }

}

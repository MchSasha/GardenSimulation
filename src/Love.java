import java.io.Serializable;
import java.util.ArrayList;

public class Love implements Serializable {
    private static final long serialVersionUID = 1L;

    public void cureGarden(Garden garden) {
        if(garden == null) return;
        cureBed(garden.getBed());
        cureTrees(garden.getTrees());
    }

    public void cureBed(Bed bed) {
        if(bed == null) return;
        for(Plant temp : bed.getSpace()) {
            if(temp == null) continue;
            curePlant(temp);
        }
    }

    public void cureTrees(ArrayList<Tree> trees) {
        for(Tree temp : trees) {
            curePlant(temp);
        }
    }

    public void curePlant(Plant plant) {
        if(plant.getDamageInfo() > Constants.DAMAGE_MINIMUM) {
            plant.cureDamage();
            System.out.println(" ---Вредители убраны!");
        }
        plant.reduceDamage(this);
    }
}

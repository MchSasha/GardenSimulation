import java.io.Serializable;
import java.util.ArrayList;

public class Wrecker implements Serializable {
    private static final long serialVersionUID = 1L;

    private int beforeMultiplying = Constants.WRECkER_MULTIPLYING_DELAY;
    private int numberOfWreckers = 1;

    public void captureGarden(Garden garden) {
        if(garden == null) return;

        captureBed(garden.getBed());
        captureTrees(garden.getTrees());
    }

    public void captureBed(Bed bed) {
        if(bed == null) return;

        for(Plant temp : bed.getSpace()) {
            if(temp == null) continue;

            capturePlant(temp);
        }
    }

    public void captureTrees(ArrayList<Tree> trees) {
        for(Plant temp : trees) {
            capturePlant(temp);
        }
    }

    public void capturePlant(Plant plant) {
        if (state()) {
            numberOfWreckers++;
            beforeMultiplying = Constants.WRECkER_MULTIPLYING_DELAY;
        }
        for (int degreeOfDanage = 0; degreeOfDanage < numberOfWreckers; degreeOfDanage++) {
            plant.getDamage(this);
        }
        beforeMultiplying--;
    }

    public boolean state() {
        return beforeMultiplying == 0;
    }

    @Override
    public String toString() {
        return " Вредители ";
    }
}

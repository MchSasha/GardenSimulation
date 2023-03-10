import java.io.Serializable;
import java.util.Random;

public class Misery implements Serializable {
    private static final long serialVersionUID = 1L;

    Wrecker wrecker;
    Disease disease;
    Weed weed;

    public void is(Garden myGarden) {
        if(myGarden == null) return;

        Random random = new Random();
        int chance = random.nextInt(365);

        if (chance % 50 == 0) {
            wrecker = new Wrecker();
            wrecker.captureGarden(myGarden);
        }
        if (chance % 100 == 0) {
            disease = new Disease();
            disease.infectGarden(myGarden);
        }
        if (chance % 15 == 0) {
            weed = new Weed();
            weed.captureBed(myGarden.getBed());
        }
    }
}

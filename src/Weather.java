import java.io.Serializable;
import java.util.Random;

public class Weather implements Serializable {
    private static final long serialVersionUID = 1L;

    private Sun sun;
    private Rain rain;

    public void is(Garden myGarden) {
        if(myGarden == null) return;
        Random random = new Random();
        int chance = random.nextInt(365);

        if (chance % 2 == 0) {
            sun = new Sun();
            if (myGarden != null)
                sun.shineInGarden(myGarden);
            System.out.println("Светит солнце!");
        }
        if (chance % 5 == 0) {
            rain = new Rain();
            if (myGarden != null)
                rain.pourGarden(myGarden);
            System.out.println("Идет дождь!");
        }
        if (chance % 3 == 0 && !(chance % 2 == 0) && !(chance % 5 == 0)){
            sun = null;
            rain = null;
            System.out.println("Нет солнца и дождя!");
        }
    }

}

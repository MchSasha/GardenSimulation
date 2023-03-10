import java.io.Serializable;

public class Watering implements Serializable {
    private static final long serialVersionUID = 1L;

    public void pourBed(Bed bed) {
        if (bed == null) return;
        System.out.println("---Полив!");
        for(Plant temp : bed.getSpace()) {
            if (temp == null) continue;

            pourPlant(temp);
        }
    }
    public void pourPlant(Plant plant) {
        plant.getWater(this);
    }
}

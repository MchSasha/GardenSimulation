import java.io.Serializable;

public class Weed extends Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    public void live() {
        super.live();
    }
    public void captureBed(Bed bed) {
        if(bed == null) return;

        for (int i = 0; i < bed.getSpace().length; i++) {
            if(bed.getSpace()[i] == null) {
                bed.getSpace()[i] = this;
                break;
            }
            if(bed.getSpace()[i] instanceof Weed) continue;
            capturePlant(bed.getSpace()[i]);
        }
    }

    public void capturePlant(Plant plant) {
        plant.live();
        this.getSun(plant);
        this.getWater(plant);
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Сорняк ***вода-%d солнце-%d иммунитет-%d повреждения-%d ***"
                    .formatted(getWaterInfo(), getSunInfo(), getImmunityInfo(), getDamageInfo()));

        if(this.isIll())
            res.append(" Заражено болезнью!");
        if(this.isWrecked())
            res.append(" Заражено вредителями!");

        return res.toString();
    }
}

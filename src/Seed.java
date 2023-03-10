import java.io.Serializable;

public class Seed extends Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Bed myBed;
    private int timeBeforeBlossom = Constants.SEED_BLOSSOM_DELAY;

    public Seed(Bed myBed) {
        Seed.myBed = myBed;
    }

    @Override
    public void live() {
        super.live();
        ripen();
    }

    public void sprout() {
        if(!stateForFertility()) return;

        Plant newVegetable = new Plant();

        for (int i = 0; i < myBed.getSpace().length; i++) {
            if(myBed.getSpace()[i] == null) continue;

            if (myBed.getSpace()[i] == this) {
                System.out.println(this + "--- Проросло в овощ!");
                myBed.getSpace()[i] = newVegetable;
            }
        }
    }
    public void ripen() {
        if (timeBeforeBlossom == 0)
        {
            sprout();
            return;
        }
        this.timeBeforeBlossom--;
    }

    @Override
    public boolean stateForFertility() {
        if(super.stateForFertility()) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Семя ***вода-%d солнце-%d иммунитет-%d повреждения-%d время до прорастания-%d***"
                .formatted(getWaterInfo(), getSunInfo(), getImmunityInfo(), getDamageInfo(), timeBeforeBlossom));

        if(this.isIll())
            res.append(" Заражено болезнью!");
        if(this.isWrecked())
            res.append(" Заражено вредителями!");

        return res.toString();
    }
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FruitTree extends Tree implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private int timeBeforeBlossom = Constants.TREE_BLOSSOM_DELAY;
    private int fertility = Constants.FRUIT_TREE_FERTILITY;
    private int fruitTreeCounter = 0;

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
    public int getFertility() {
        return fertility;
    }
    public void setFertility(int fertility) {
        this.fertility = fertility;
    }

    public FruitTree() {
        fruitTreeCounter++;
    }
    public void ripen() {
        if (timeBeforeBlossom == 0)
        {
            newFruit();
            return;
        }
        this.timeBeforeBlossom--;
    }

    public void newFruit() {
        if (!stateForFertility()) return;
        this.fertility--;

        Fruit newFruit = new Fruit(this);
        fruits.add(newFruit);
        timeBeforeBlossom = Constants.TREE_BLOSSOM_DELAY;

        System.out.println(this + "--- Вырос новый фрукт!");
    }

    @Override
    public boolean stateForLive() {
        if (!super.stateForLive())
        {
            System.out.println(this + "погибло от внешних факторов :(");
            return false;
        }
        return true;
    }

    public boolean stateForFertility() {
        if(!stateForLive())
            return false;

        return fertility > 0;
    }

    public void getFertilizer() {
        getImmunity();

        System.out.println(this + "--- Получило удобрение!");
    }

    public int getActualNumberOfFruits() {
        int count = 0;
        for (Fruit fruit : fruits) {
            if (fruit != null) {
                count++;
            }
        }
        return count;
    }
    @Override
    public void live() {
        super.live();
        ripen();

        for (Fruit temp : fruits) {
            temp.live();
        }

        Iterator<Fruit> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            Fruit temp = iterator.next();
            if (temp.getLengthOfLife() < 0) {
                iterator.remove();

                this.fertility++;
                System.out.println(this +" --- Фрукт упал!");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Дерево ***вода-%d солнце-%d иммунитет-%d повреждения-%d кол-во фруктов-%d время до созревания нового фрукта-%d***"
                .formatted(getWaterInfo(), getSunInfo(), getImmunityInfo(), getDamageInfo(), getActualNumberOfFruits(), timeBeforeBlossom));

        if(this.isIll())
            res.append(" Заражено болезнью!");
        if(this.isWrecked())
            res.append(" Заражено вредителями!");

        if (this.getWaterInfo() <  Constants.WATER_MINIMUM) {
            res.append(" Необходим полив!");
        }
        if (this.getSunInfo() < Constants.SOLAR_ENERGY_MINIMUM) {
            res.append(" Необходимо солнце!");
        }
        if (this.getImmunityInfo() < Constants.IMMUNITY_MINIMUM) {
            res.append(" Необходимо удобрение!");
        }
        if (this.getDamageInfo() < Constants.DAMAGE_MINIMUM) {
            res.append(" Необходима забота!");
        }

        return res.toString();
    }
}
//фрукты и деревья
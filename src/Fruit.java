import java.io.Serializable;
import java.util.Iterator;

public class Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    FruitTree myTree = new FruitTree();
    private int lengthOfLife = Constants.FRUIT_LIFE;

    public int getLengthOfLife() {
        return lengthOfLife;
    }

    public Fruit(FruitTree myTree) {
        this.myTree = myTree;
    }
    public void live() {
        lengthOfLife--;
    }

    @Override
    public String toString() {
        return "Фрукт ";
    }
}

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Garden implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Weather weather;
    private Bed bed;
    private ArrayList<Tree> trees = new ArrayList<>();
    private Misery misery = new Misery();
    private Fertilizer fertilizer;
    private Love care;

    public Garden() {
        weather = new Weather();
        weather.is(this);
    }
    public Bed getBed() {
        return bed;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public Fertilizer getFertilizer() {
        return fertilizer;
    }

    public void fertileGarden() {
        fertilizer = new Fertilizer();
        fertilizer.fertileGarden(this);
    }
    public void weedingGarden() {
        for (Plant plant : bed.getSpace()) {
            if (plant == null) continue;

            if(plant instanceof Weed)
                bed.removeFromBed(plant);
        }
    }

    public void loveGadren() {
        care = new Love();
        care.cureGarden(this);
    }

    public void newBed() {
        if(bed == null)
            bed = new Bed();
        System.out.println(bed + " ---Создана грядка!");
    }

    public void newSeed() {
        if (bed != null) {
            Seed newSeed = new Seed(bed);
            bed.allocsateSpace(newSeed);
            System.out.println(newSeed + " ---Посажено новое семя на грядку!");
        }
    }

    public void newFruitTree() {
        Tree newTree = new FruitTree();
        trees.add(newTree);
        System.out.println(newTree + " ---Посажено новое фруктовое дерево в саду!");
    }

    public boolean state() {
        for (Tree tree : trees) {
            if(tree == null) continue;

            if (!tree.stateForLive()) {
                System.out.println(tree + " ---Убрано с сада!");
                trees.remove(tree);
                return false;
            }
        }
        for (Plant plant : bed.getSpace()) {
            if(plant == null) continue;

            if (!plant.stateForLive()) {

                if(plant instanceof Weed) System.out.println(plant + " ---Погиб!");
                else System.out.println(plant + " ---Убрано с грядки!");

                bed.removeFromBed(plant);
                return false;
            }
        }
        return true;
    }
    public void exist() {
        while (true) {
            misery.is(this);
            weather.is(this);

            state();
            for (Tree tree : trees) {
                tree.live();
            }
            for (Plant plant : bed.getSpace()) {
                if(plant == null) continue;
                plant.live();
            }

            for (Tree tree : trees) {
                System.out.println(tree);
            }
            for (Plant plant : bed.getSpace()) {
                if(plant == null) continue;
                System.out.println(plant);
            }
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;
            while (duration < 7) {
                endTime = System.currentTimeMillis();
                duration = (endTime - startTime) / 1000;
            }
            System.out.println();
        }
    }
}

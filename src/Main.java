import java.io.*;
import java.util.Scanner;

public class Main {
    static Garden g = new Garden();

    static class Reader implements Runnable {
        @Override
        public void run() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("store.ser"))) {
                g = (Garden) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                g.newBed();
            }
            g.exist();
        }
    }

    static class Writer implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                switch (scanner.nextLine()) {
                    case "sd" -> g.newSeed();   //new seed
                    case "tr" -> g.newFruitTree();    //new tree
                    case "fl" -> g.fertileGarden();    //fertile the garden
                    case "cr" -> g.loveGadren();  //care
                    case "wt" -> {
                        Watering watering = new Watering();
                        watering.pourBed(g.getBed());
                    }   //water
                    case "wd" ->{
                        g.weedingGarden();
                    }   //weeding
                    case "rt" ->{
                        for (Tree tree : g.getTrees()) {
                            if(tree == null) continue;

                            g.getTrees().remove(tree);
                            break;
                        }
                    }   //remove tree
                    case "rs" -> {
                        for (Plant plant : g.getBed().getSpace()) {
                            if(plant == null) continue;

                            if(plant instanceof Seed)
                            {
                                g.getBed().removeFromBed(plant);
                                break;
                            }
                        }
                    }   //remove seed
                    case "rv" -> {
                        for (Plant plant : g.getBed().getSpace()) {
                            if(plant == null) continue;

                            if(!(plant instanceof Seed) && !(plant instanceof Weed))
                            {
                                g.getBed().removeFromBed(plant);
                                break;
                            }
                        }
                    }   //remove vegetable
                    case "rw" ->{
                        for (Plant plant : g.getBed().getSpace()) {
                            if(plant == null) continue;

                            if(plant instanceof Weed)
                            {
                                g.getBed().removeFromBed(plant);
                                break;
                            }
                        }
                    }   //remove weed
                    case "ex" ->{
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store.ser"))) {
                            oos.writeObject(g);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                    }   //exit
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread readerThread = new Thread(new Reader());
        Thread writerThread = new Thread(new Writer());

        readerThread.start();
        writerThread.start();

    }
}
import java.io.Serializable;

public class Tree extends Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    public Tree(){setTreeWater();}
    @Override
    public void live() {
        super.live();
    }

}

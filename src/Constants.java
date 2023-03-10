import java.io.Serializable;

public class Constants implements Serializable {
    private static final long serialVersionUID = 1L;

    //initial data
    public static int MAX_SPACE = 40;
    public static int WATER_SUPPLY = 50;
    public static int SOLAR_ENERGY_SUPPLY = 50;
    public static int IMMUNITY_SUPPLY = 50;
    public static int DAMAGE_SUPPLY = 50;
    public static int FRUIT_TREE_FERTILITY = 100;

    //benefits
    public static int RAIN_BENEFIT = 25;
    public static int WATERING_BENEFIT = 25;
    public static int SOLAR_ENERGY_BENEFIT = 20;
    public static int FERTILIZER_BENEFIT = 50;
    public static int CARE_BENEFIT = 25;

    //waste
    public static int WATER_USAGE = 5;
    public static int SOLAR_ENERGY_USAGE = 5;
    public static int IMMUNITY_USAGE = 5;
    public static int DAMAGE = 5;

    //time
    public static int TREE_BLOSSOM_DELAY = 5;
    public static int SEED_BLOSSOM_DELAY = 5;
    public static int FRUIT_LIFE = 15;

    //blossom minimum
    public static int WATER_MINIMUM = 20;
    public static int SOLAR_ENERGY_MINIMUM = 20;
    public static int IMMUNITY_MINIMUM = 20;
    public static int DAMAGE_MINIMUM = 20;

    //misery conditions
    public static int WRECkER_MULTIPLYING_DELAY = 10;

}

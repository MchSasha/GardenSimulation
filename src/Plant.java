import java.io.Serializable;

public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;

    private int water = Constants.WATER_SUPPLY;
    private int sun = Constants.SOLAR_ENERGY_SUPPLY;
    private int immunity = Constants.IMMUNITY_SUPPLY;
    private int damage = Constants.DAMAGE_SUPPLY;

    private boolean isIll = false;
    private boolean isWrecked = false;

    public void live(){
        useWater();
        useSun();
    };

    protected void setTreeWater() {
        water = 5 * Constants.WATER_SUPPLY;
    }
    public int getWaterInfo() {
        return water;
    }
    public int getSunInfo() {
        return sun;
    }
    public int getImmunityInfo() {
        return immunity;
    }
    public int getDamageInfo() {
        return damage;
    }

    public boolean isWrecked() {
        return isWrecked;
    }

    public boolean isIll() {
        return isIll;
    }

    public void cureDamage() {
        isWrecked = false;
    }
    public void cureDesease() {
        isIll = false;
    }

    //water issues
    public void getWater(Rain rain) {
        this.water += Constants.RAIN_BENEFIT;
    }
    public void getWater(Watering watering) {
        this.water += Constants.WATERING_BENEFIT;
    }
    public void getWater(Plant plant) {
        this.water += Constants.WATERING_BENEFIT;
    }

    public void useWater() {
        this.water -= Constants.WATER_USAGE;            //
    }

    //sun issues
    public void getSun(Sun sun) {
        this.sun += Constants.SOLAR_ENERGY_BENEFIT;
        this.water -= Constants.WATER_USAGE;
    }
    public void getSun(Plant plant) {
        this.sun += Constants.SOLAR_ENERGY_BENEFIT;
        this.water -= Constants.WATER_USAGE;
    }

    public void useSun() {
        this.sun -= Constants.SOLAR_ENERGY_USAGE;           //
    }

    //immunity issues
    public void getImmunity() {
        if(immunity > Constants.IMMUNITY_MINIMUM) this.isIll = false;
        this.immunity += Constants.FERTILIZER_BENEFIT;
    }

    public void useImmunity(Disease disease) {
        this.isIll = true;
        this.immunity -= Constants.IMMUNITY_USAGE;          //
    }

    //damage issues
    public void getDamage(Wrecker wrecker) {
        this.isWrecked = true;
        this.damage -= Constants.DAMAGE; //
    }

    public void reduceDamage(Love love) {
        if(damage > Constants.DAMAGE_MINIMUM) this.isWrecked = false;
        this.damage += Constants.CARE_BENEFIT;
    }

    public boolean stateForFertility() {
        if (water <  Constants.WATER_MINIMUM) {
            //System.out.println(this + " Необходим полив!");
            return false;
        }
        if (sun < Constants.SOLAR_ENERGY_MINIMUM) {
//            System.out.println(this + " Необходимо солнце!");
            return false;
        }
        if (immunity < Constants.IMMUNITY_MINIMUM) {
//            System.out.println(this + " Необходимо удобрение!");
            return false;
        }
        if (damage < Constants.DAMAGE_MINIMUM) {
//            System.out.println(this + " Необходима забота!");
            return false;
        } else {
            return true;
        }
    }

    public boolean stateForLive() {
        if (water <  0) {
            return false;
        }
        if (sun < 0) {
            return false;
        }
        if (immunity < 0) {
            return false;
        }
        if (damage < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder res  = new StringBuilder("Овощ ***вода-%d солнце-%d иммунитет-%d повреждения-%d ***"
                    .formatted(getWaterInfo(), getSunInfo(), getImmunityInfo(), getDamageInfo()));

        if(this.isIll())
            res.append(" Заражено болезнью!");
        if(this.isWrecked())
            res.append(" Заражено вредителями!");

        if (water <  Constants.WATER_MINIMUM) {
            res.append(" Необходим полив!");
        }
        if (sun < Constants.SOLAR_ENERGY_MINIMUM) {
            res.append(" Необходимо солнце!");
        }
        if (immunity < Constants.IMMUNITY_MINIMUM) {
            res.append(" Необходимо удобрение!");
        }
        if (damage < Constants.DAMAGE_MINIMUM) {
            res.append(" Необходима забота!");
        }

        return res.toString();
    }
}

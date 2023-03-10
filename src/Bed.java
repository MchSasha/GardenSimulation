import java.io.Serializable;

public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;

    private Plant place[] = new Plant[Constants.MAX_SPACE];
    private static int spaceTrecker = Constants.MAX_SPACE;

    public Plant[] getSpace() {

        return place;
    }

    public void allocsateSpace(Plant plant) {
        if (spaceTrecker == -1) return;

        for (int i = 0; i < place.length; i++) {
            if (place[i] == null) {
                place[i] = plant;
                spaceTrecker--;
                break;
            }
        }
    }

    public void freeSpace(Plant plant) {
        for (Plant temp : place) {
            if(temp == null) continue;

            if (temp == plant) {
                removeFromBed(temp);
                spaceTrecker++;
            }
        }
    }
    public void removeFromBed(Plant toRemove) {
        for (int i = 0; i < place.length; i++) {
            if (place[i] == toRemove) {
                place[i] = null;
            }
        }
    }

    @Override
    public String toString() {
        return "Грядка ";
    }

    //

    //
}

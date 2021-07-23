package webshop;

public class Product {
    private final int ID;
    private final String TITLE;
    private final float COST;

    public Product(int ID, String TITLE, float COST) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.COST = COST;
    }

    public int getID() {
        return ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public float getCOST() {
        return COST;
    }
}

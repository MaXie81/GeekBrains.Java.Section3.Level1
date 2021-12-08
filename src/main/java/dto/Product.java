package dto;

public class Product {
    private final long id;
    private final String title;
    private final int price;

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() { return price; }
}

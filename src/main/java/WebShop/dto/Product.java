package webshop.dto;

public class Product {
    private final Integer id;
    private final String title;
    private final float cost;

    public Product(int id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() { return cost; }

    @Override
    public String toString() {
        return "[\"" + title + "\" : " + cost + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getTitle().equals(product.getTitle());
    }
}


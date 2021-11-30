package webshop.dto;

public class Product {
    private final Integer id;
    private final String name;
    private final float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() { return price; }

    @Override
    public String toString() {
        return "[\"" + name + "\" : " + price + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getName().equals(product.getName());
    }
}


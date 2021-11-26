package spring.classes;

import java.util.Objects;

public class Product {
    private final long id;
    private final String name;
    private final float price;

    public Product(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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

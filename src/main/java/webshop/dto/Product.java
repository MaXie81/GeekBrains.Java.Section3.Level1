package webshop.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "COST")
    private float cost;

    @Override
    public String toString() {
        return "[\"" + title + "\" : " + cost + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof webshop.dto.Product)) return false;
        webshop.dto.Product product = (webshop.dto.Product) o;
        return getTitle().equals(product.getTitle());
    }
}


package geekbrains.java.section3.level1.webshop.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private long id;
    private String title;
    private float cost;
}

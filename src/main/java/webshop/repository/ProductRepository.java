package webshop.repository;

import org.springframework.stereotype.Component;
import webshop.dto.Product;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final String FILE_NAME = "products.data";
    private final String FILE_TEXT_SEPARATOR = "/";
    private List<Product> listOfAvailableProducts = new ArrayList<>();;

    @PostConstruct
    private void init() {
        ClassLoader loader = this.getClass().getClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(loader.getResourceAsStream(FILE_NAME)))) {
            while (br.ready()) {
                String[] arrWord = br.readLine().split(FILE_TEXT_SEPARATOR);
                listOfAvailableProducts.add(new Product(Integer.valueOf(arrWord[0]), arrWord[1], Float.valueOf(arrWord[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getListOfAvailableProducts() {
        return listOfAvailableProducts;
    }
    public void addProduct(Product product) {listOfAvailableProducts.add(product);}
}
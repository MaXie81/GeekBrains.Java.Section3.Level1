package webshop.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webshop.model.Product;
import webshop.dto.ProductDto;
import webshop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

//    private ProductDto getProductDto(Product product) {
//        return product == null ? new ProductDto() : new ProductDto(product.getId(), product.getTitle(), product.getCost());
//    }
//    private Product getProduct(ProductDto productDto) {
//        return productDto == null ? new Product() : new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
//    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getAllProductsPage(Pageable pageable) {
        return productRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);}
    public Long getProductLastId() {
        return productRepository.getLastId();
    }
}

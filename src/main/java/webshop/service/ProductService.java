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

    private ProductDto getProductDto(Product product) {
        return product == null ? new ProductDto() : new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
    private Product getProduct(ProductDto productDto) {
        return productDto == null ? new Product() : new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = productRepository.findAll()
                .stream()
                .map(product -> getProductDto(product))
                .collect(Collectors.toList());

        return productDtoList;
    }
    public List<ProductDto> getAllProductsPage(Pageable pageable) {
        List<ProductDto> productDtoList = productRepository.findAll(pageable)
                .stream()
                .map(product -> getProductDto(product))
                .collect(Collectors.toList());

        return productDtoList;
    }
    public ProductDto getProductById(Long id) {
        return getProductDto(productRepository.findById(id).orElse(null));
    }
    public void addProduct(ProductDto productDto) {
        productRepository.save(getProduct(productDto));
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);}
    public Long getProductLastId() {
        return productRepository.getLastId();
    }
}

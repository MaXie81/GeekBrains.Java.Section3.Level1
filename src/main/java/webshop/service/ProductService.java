package webshop.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webshop.dto.Product;
import webshop.dto.ProductDto;
import webshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository assortment;

    private ProductDto getProductDto(Product product) {
        return product == null ? new ProductDto() : new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
    private Product getProduct(ProductDto productDto) {
        return productDto == null ? new Product() : new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = assortment.findAll()
                .stream()
                .map(product -> getProductDto(product))
                .collect(Collectors.toList());

        return productDtoList;
    }
    public List<ProductDto> getAllProductsPage(Pageable pageable) {
        List<ProductDto> productDtoList = assortment.findAll(pageable)
                .stream()
                .map(product -> getProductDto(product))
                .collect(Collectors.toList());

        return productDtoList;
    }
    public ProductDto getProductById(Long id) {
        Optional<Product> optionalProduct = assortment.findById(id);
        return optionalProduct.isPresent() ? getProductDto(optionalProduct.get()) : getProductDto(null) ;
    }
    public void addProduct(ProductDto productDto) {
        assortment.save(getProduct(productDto));
    }
    public void deleteProduct(Long id) {assortment.deleteById(id);}
    public Long getProductLastId() {
        return assortment.getLastId();
    }
}

package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import webshop.dto.ProductDto;
import webshop.service.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/products")
public class RestProductController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        return productService.getAllProductsPage(pageable);
    }
    @GetMapping("/{id}")
    public ProductDto getProductInfo(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PostMapping
//    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {
        productDto.setId(productService.getProductLastId() + 1);
        productService.addProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public Boolean putProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return Boolean.valueOf(false);
        productService.addProduct(productDto);
        return Boolean.valueOf(true);
    }
    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return true;
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException exception) {
        Map<String, String> mapErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach(objectError -> {
                    String nameFieldError = ((FieldError) objectError).getField();
                    String messageError = objectError.getDefaultMessage();
                    mapErrors.put(nameFieldError, messageError);
                });
        return new ResponseEntity<>(mapErrors, HttpStatus.BAD_REQUEST);
    }
}


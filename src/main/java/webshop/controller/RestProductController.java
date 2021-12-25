package webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import webshop.dto.ProductDto;
import webshop.model.Product;
import webshop.service.CartService;
import webshop.service.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/products")
@AllArgsConstructor
public class RestProductController {
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        return productService.getAllProductsPage(pageable);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {
        productDto.setId(null);
        productService.addProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ProductDto> putProduct(@Valid @RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
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

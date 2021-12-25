package webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.dto.ProductDto;
import webshop.model.Product;
import webshop.service.CartService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/cart")
@AllArgsConstructor
public class RestCartController {
    CartService cartService;

    @GetMapping
    public List<Product> getAllProducts() {
        return cartService.getProductList();
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        cartService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        cartService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

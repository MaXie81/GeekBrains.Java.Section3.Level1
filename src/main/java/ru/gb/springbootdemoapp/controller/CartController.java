package ru.gb.springbootdemoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbootdemoapp.model.Product;
import ru.gb.springbootdemoapp.service.CartService;
import ru.gb.springbootdemoapp.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/add/{id}")
    public String getStudentInfo(@PathVariable Long id) {
        Product product = productService.findById(id);
        cartService.addProduct(product);
        return "redirect:/";
    }
}

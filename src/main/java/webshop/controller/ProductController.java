package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webshop.service.ProductService;

@Controller
public class ProductController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    @GetMapping("/product/all")
    public String getAllProducts(Model model) {
        model.addAttribute("listOfProducts", productService.getAllProducts());
        return "all_products";
    }
}

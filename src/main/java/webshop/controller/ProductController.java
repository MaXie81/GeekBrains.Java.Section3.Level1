package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webshop.dto.Product;
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
        model.addAttribute("var", "test1");
        return "all_products";
    }
    @GetMapping("/product/info/{id}")
    public String getProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }
    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("nextId", productService.getProductLastId() + 1);
        return "add_product";
    }
    @PostMapping("/product/add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Float cost) {
        productService.addProduct(new Product(id, title, cost));
        return "redirect:/product/all";
    }
}

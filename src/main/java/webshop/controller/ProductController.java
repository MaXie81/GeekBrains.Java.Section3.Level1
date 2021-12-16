package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webshop.dto.Product;
import webshop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAllProducts(Model model) {
        model.addAttribute("listOfProducts", productService.getAllProducts());
        return "all_products";
    }
    @GetMapping("/{id}")
    public String getProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products/";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("nextId", productService.getProductLastId() + 1);
        return "add_product";
    }
    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/products/";
    }
}

package geekbrains.java.section3.level1.webshop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import geekbrains.java.section3.level1.webshop.main.Product;
import geekbrains.java.section3.level1.webshop.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ShopController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/test")
    public String doTest() {
        return "test";
    }

    @GetMapping
    public String getStartPage() {
        return "index";
    }
    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("listOfProducts", productService.getAllProducts());
        return "all_products";
    }
    @GetMapping("/info/{id}")
    public String getProductInfo(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }
    @GetMapping("/add")
    public String getPageAddProduct(Model model) {
        model.addAttribute("id", productService.getId());
        return "add_product";
    }
    @PostMapping("/add")
    public String addProduct(@RequestParam long id, @RequestParam String title, @RequestParam float cost) {
        productService.addProduct(id, title, cost);
        return "redirect:/product/all";
    }
}

package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webshop.dto.ProductDto;
import webshop.service.ProductService;

import javax.validation.Valid;


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
    @GetMapping("/info/{id}")
    public String getProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products/";
    }
    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("productDto", new ProductDto(productService.getProductLastId() + 1));
        return "add_product";
    }
    @PostMapping("/add")
    public String addProduct(@Valid ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "add_product";
        System.out.println(productDto);
        productService.addProduct(productDto);
        return "redirect:/products/";
    }
}

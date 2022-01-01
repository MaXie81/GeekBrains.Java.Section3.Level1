package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webshop.converter.ProductMapper;
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
    public String getAllProducts(Model model, @PageableDefault(size = 5, page = 0) Pageable pageable) {
        model.addAttribute("listOfProducts", productService.getAllProductsPage(pageable));
        return "all_products";
    }
    @GetMapping("/info/{id}")
    public String getProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }
    @GetMapping("/edit/{id}")
    public String editProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("productDto", ProductMapper.MAPPER.fromProduct(productService.getProductById(id)));
        return "edit_product";
    }
    @PostMapping("/edit")
    public String editProductInfo(@Valid ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "edit_product";
        productService.editProduct(ProductMapper.MAPPER.toProduct(productDto));
        return "redirect:/products/";
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
        productService.addProduct(ProductMapper.MAPPER.toProduct(productDto));
        return "redirect:/products/";
    }
}

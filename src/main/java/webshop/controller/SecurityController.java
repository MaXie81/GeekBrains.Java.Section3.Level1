package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webshop.service.UserService;

@Controller
public class SecurityController {
    UserService userService;

    @Autowired
    public void setProductService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllProducts(Model model) {
        model.addAttribute("listOfUsers", userService.getAllUsers());
        return "user_list";
    }
}

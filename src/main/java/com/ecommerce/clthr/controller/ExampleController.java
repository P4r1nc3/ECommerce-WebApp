package com.ecommerce.clthr.controller;

import com.ecommerce.clthr.dto.ProductRepository;
import com.ecommerce.clthr.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/example")
    public String exampleView(Model model) {
        Product p = new Product();
        Long id = (long) 1;
        p = productRepository.findById(id).get();
        model.addAttribute("product", p);
        return "example";
    }
}

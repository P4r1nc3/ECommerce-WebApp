package com.ecommerce.clthr.controller;

import com.ecommerce.clthr.dto.ProductRepository;
import com.ecommerce.clthr.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/listProducts")
    public String showExampleView(Model model) {
        Product p = new Product();
        Long id = (long) 1;
        p = productRepository.findById(id).get();
        model.addAttribute("product", p);
        return "listProducts";
    }

    @GetMapping("/")
    public String showAddProduct() {
        return "addProduct";
    }

    @PostMapping ("/addP")
    public String saveProduct(@RequestParam("pname") String name,
                              @RequestParam("price") int price,
                              @RequestParam("desc") String description) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);

        productRepository.save(p);

        return "redirect:/listProducts";
    }
}

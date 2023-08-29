package com.ecommerce.clthr.controller;

import com.ecommerce.clthr.dto.ProductRepository;
import com.ecommerce.clthr.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/listProducts")
    public String showExampleView(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        System.out.println(products);
        return "listProducts";
    }

    @GetMapping("/addProduct")
    public String showAddProduct() {
        return "addProduct";
    }

    @PostMapping ("/add")
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

    @RequestMapping("/deleteProduct/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        productRepository.deleteById(id);
        return "redirect:/listProducts";
    }

    @PostMapping("/editProduct")
    public String editProduct(@RequestParam("id") long id,
                              @RequestParam("newName") String name,
                              @RequestParam("newPrice") int price,
                              @RequestParam("newDesc") String description) {

        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);
        productRepository.save(p);

        System.out.print("hello");
        return "redirect:/listProducts";
    }
}

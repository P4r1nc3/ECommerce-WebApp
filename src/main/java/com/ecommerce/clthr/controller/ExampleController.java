package com.ecommerce.clthr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/")
    public String exampleView(Model model) {
        String name = "Konrad";
        model.addAttribute("name", name);
        System.out.println("from the showExampleView() ");
        return "example";
    }
}

package com.ecommerce.clthr.controller;

import com.ecommerce.clthr.dto.ProductRepository;
import com.ecommerce.clthr.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetViewController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnAddProduct() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addProduct");
        return mv;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnListProducts() {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productRepository.findAll();
        mv.setViewName("listProducts");
        mv.addObject("products", products);
        return mv;
    }
}

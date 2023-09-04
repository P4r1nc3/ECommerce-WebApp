package com.ecommerce.clthr.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowExample {

    @RequestMapping(value = "/fetchExample", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnExampleView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("example");
        mv.addObject("var", "Konrad");
        return mv;
    }
}

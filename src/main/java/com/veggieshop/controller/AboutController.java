package com.veggieshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("shopName", "LVO Veggie Shop");
        model.addAttribute("description", "LVO Veggie Shop is dedicated to bringing you the freshest farm produce directly to your table. Our commitment to quality ensures that you receive the best vegetables and ready-made meals, sourced responsibly and sustainably.");
        return "about";
    }
}
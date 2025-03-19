package com.veggieshop.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String handleError() {
        return "error/general-error";
    }

    @GetMapping("/404")
    public String handleNotFound() {
        return "error/404";
    }
}
package com.iekh0813.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String helloWorld() {
        return "Hello world from Spring MVC!";
    }


}
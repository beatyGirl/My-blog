package com.tian.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public String index(HttpServletResponse response, HttpServletRequest request){
        request.setAttribute("msg", "Hello Spring Boot World");
        return "index";
    }
}

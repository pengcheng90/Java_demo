package com.demo.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User:
 * Date: 2018/3/21
 * Time: 16:08
 * Description:
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
//        if (request.getAttribute("user") == null) {
//            return "login";
//        }
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index1(Model model) {
//        if (!model.containsAttribute("user")) {
//            return "login";
//        }
        return "index";
    }
}
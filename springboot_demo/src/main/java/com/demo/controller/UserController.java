package com.demo.controller;

import com.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.demo.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String find(Model model, @PathVariable("id") Long id) {
        User user = userService.findById((long) 1);
        model.addAttribute("user", user);
        return "forward:/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Model model) {
        User user = userService.findByUserNameAndPasss(username, password);
        System.out.println(user+" is login");
        if (user != null)
            model.addAttribute("user", user);
        return "redirect:/index";
    }
}

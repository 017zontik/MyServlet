package com.tms.controller;

import com.tms.model.User;
import com.tms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello there! Do you want to add new user?");
        return "index";
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public String getUserPage(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("user", user);
        return "userList";
    }

        @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userOb", new User());
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("userOb") User user, ModelMap model) {
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("username", user.getUsername());
        userService.createUser(user);
        return "result";
    }


}

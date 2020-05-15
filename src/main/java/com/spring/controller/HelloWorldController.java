package com.spring.controller;

import com.spring.constant.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    @RequestMapping("/home")
    public ModelAndView showIndex(ModelAndView view) {
        ModelAndView modelAndView = new ModelAndView(Pages.home);
        return modelAndView;
    }

    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView view) {
        ModelAndView modelAndView = new ModelAndView(Pages.hello);
        return modelAndView;
    }

    @RequestMapping("/hii")
    public ModelAndView hii(ModelAndView view) {
        ModelAndView modelAndView = new ModelAndView(Pages.hii);
        return modelAndView;
    }

    @RequestMapping("/boot")
    public ModelAndView boot(ModelAndView view) {
        ModelAndView modelAndView = new ModelAndView(Pages.boot);
        return modelAndView;
    }

    @RequestMapping("/mvc")
    public ModelAndView mvc(ModelAndView view) {
        ModelAndView modelAndView = new ModelAndView(Pages.mvc);
        return modelAndView;
    }

    @RequestMapping("/form")
    public ModelAndView form(ModelAndView view) {
        ModelAndView modelAndView = new ModelAndView("pages/login");
        return modelAndView;
    }


    @RequestMapping("/login1")
    public ModelAndView login1(HttpServletRequest servletRequest, ModelAndView view) {
        String name = servletRequest.getParameter("name");
        String password = servletRequest.getParameter("password");
        // ModelAndView  modelAndView = new ModelAndView();
        if (password.equals("ram")) {
            view = new ModelAndView("pages/success");
            String data = "your name is: " + name + " password is: " + password;
            view.addObject("msz", data);
            return view;
            //return new ModelAndView("pages/success");
        } else {
            view = new ModelAndView("pages/failure");
            String data = "invalid name or pasword";
            view.addObject("msz", data);
            return view;
        }
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("name") String name, @RequestParam("password") String password, ModelAndView view) {
        // ModelAndView  modelAndView = new ModelAndView();
        if (password.equals("ram")) {
            view = new ModelAndView("pages/success");
            String data = "your name is: " + name + " password is: " + password;
            view.addObject("msz", data);
            return view;
            //return new ModelAndView("pages/success");
        } else {
             view = new ModelAndView("pages/failure");
            String data = "invalid name or pasword";
            view.addObject("msz", data);
            return view;
        }

    }
}
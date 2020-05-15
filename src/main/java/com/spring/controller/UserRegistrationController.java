package com.spring.controller;

import com.spring.constant.Pages;
import com.spring.dao.IUserDao;
import com.spring.dao.impl.UserDaoImpl;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistrationController {
    @Autowired
    UserDaoImpl dao;
    @RequestMapping("/register")
    public ModelAndView registerData(ModelAndView view){
        view=new ModelAndView(Pages.regiser);
        return view;
    }
    @RequestMapping(value = "/details",method = RequestMethod.POST)
    public ModelAndView showDetails(@ModelAttribute("user")User user,ModelAndView view){
        dao.create(user);
        view=new ModelAndView(Pages.details);
       return view.addObject("details",user);
    }
//    @RequestMapping("/email")
//    public ModelAndView email(ModelAndView view){
//        view=new ModelAndView(Pages.email);
//        return view;
//    }
    @RequestMapping(path = "/update")
    public ModelAndView update( @ModelAttribute("user")User user, ModelAndView view){

        view=new ModelAndView(Pages.update);
         //dao.update(user,email);
         //view.addObject("email",email);
         view.addObject("user",user);
         //view.addObject("password",password);
         return view;
    }
//    @RequestMapping(path = "/updatedetails")
//    public ModelAndView update(ModelAndView view){
//
//        view=new ModelAndView(Pages.update);
//        dao.update(user,email);
//        view.addObject("email",email);
//        view.addObject("user",user);
//        //view.addObject("password",password);
//        return view;
//    }
    @RequestMapping(value = "/updatedetails",method = RequestMethod.POST)
    public ModelAndView showupdateDetails(@RequestParam("email") String email ,@RequestParam("name") String name,@RequestParam("password") String password,@ModelAttribute("user")User user, ModelAndView view){
        view=new ModelAndView(Pages.updatedetails);
        dao.update(user,email);
         view.addObject("email",email);
         view.addObject("name",name);
         view.addObject("password",password);
        view.addObject("user",user);
        return view;
    }
}

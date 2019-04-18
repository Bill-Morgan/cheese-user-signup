package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Cheese Users");
        model.addAttribute("userArray", UserData.getUserArray());
        return ("user/index");
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        return ("user/add");
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User user,
                      Errors errors,
                      String verify,
                      Model model){

        if (errors.hasErrors()) {
            model.addAttribute("user",user);
            return ("user/add");
        }
        if (!user.getPassword().equals(verify)){
            model.addAttribute("user",user);
            model.addAttribute("verify", "");
            return ("user/add");
        }
        UserData.addUser(user);
        return ("redirect:");
    }
}

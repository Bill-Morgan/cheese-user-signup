package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheesController {

    //private static HashMap<String, String> cheesesHashMap = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public  String index(Model model){

        model.addAttribute("cheesesArray", CheeseData.getCheesesArray());
        model.addAttribute("title", "My Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("button", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheese", newCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("button", "Add Cheese");
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        //Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese cheese = CheeseData.getById(cheeseId);
        String title = "Edit cheese " + cheese.getName() + "(id=" + cheese.getCheeseId() + ")";
        model.addAttribute("title", title);
        model.addAttribute("cheese", cheese);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("button", "Edit Cheese");
        return "/cheese/add";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese,
                                  Errors errors,
                                  @PathVariable int cheeseId,
                                  Model model){
        if (errors.hasErrors()) {
            String title = "Edit cheese " + cheese.getName() + "(id=" + cheeseId + ")";
            model.addAttribute("title", title);
            model.addAttribute("cheese", cheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("button", "Edit Cheese");
            return "/cheese/add";
        }
        CheeseData.edit(cheeseId, cheese);
        return "redirect:/cheese";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("cheesesArray", CheeseData.getCheesesArray());
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<Integer> cheeseIDs) {

        for (Integer eachCheeseId : cheeseIDs  ) {
            CheeseData.remove(eachCheeseId);
        }

        //Redirect to /cheese
        return "redirect:";
    }

}

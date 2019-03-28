package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {
        CheeseData.add(newCheese);
        //Redirect to /cheese
        return "redirect:";
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

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese editCheese = CheeseData.getById(cheeseId);
        String title = "Edit cheese " + editCheese.getName() + "(id=" + editCheese.getId() + ")";
        model.addAttribute("title", title);
        model.addAttribute("editCheese", editCheese);
        return "/cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, String name, String description){
        CheeseData.update(cheeseId, name, description);
        return "redirect:";
    }

}

package org.launchcode.controllers;

import org.launchcode.models.Menu;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by mettenichols on 4/11/17.
 */

@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @Autowired
    CheeseDao cheeseDao;

    @RequestMapping(value ="")
    public String index(Model model) {

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "menus");

        return "menu/index";

    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute( new Menu());
        model.addAttribute("title", "Add Menu");

        return "menu/add";
    }

    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Menu menu, Errors errors, Model model) {

        if(errors.hasErrors()) {

            return "menu/add";

        }

        menuDao.save(menu);

        return "redirect:view/" + menu.getId();
    }


}

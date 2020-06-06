package com.masthacode.controller;

import com.masthacode.model.Complain;
import com.masthacode.services.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComplainController {

    private ComplainService complainService;

    @Autowired
    public void setComplainService (ComplainService complainService){
        this.complainService = complainService;
    }

    @RequestMapping("/complain")
    public String ComplainList(Model model){
        model.addAttribute("complain", complainService.listComplain());
        return "complain";
    }

    @RequestMapping(value = "/complain/create",  method = RequestMethod.GET)
    public String tampilkanForm(Model model){
        model.addAttribute("complain", new Complain());
        return "formComplain";
    }

    @RequestMapping(value = "/complain/create", method = RequestMethod.POST)
    public String simpanDataComplain(Model model,Complain complain){
        model.addAttribute("complain", complainService.saveOrUpdate(complain));
        return "redirect:/complain";
    }

    @RequestMapping(value = "/complain/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("complain", complainService.getIdComplain(id));
        return "formComplain";
    }
}


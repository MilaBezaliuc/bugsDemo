package com.endava.internship.controllers;

import com.endava.internship.storages.DBStorage;
import com.endava.internship.entity.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.endava.internship.storages.Storage.*;

@Controller
public class WelcomeController {

    private String main = "main";
    private String info = "info";
    private HelloMessage helloMessage;
    private DBStorage dbStorage = new DBStorage();

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("hello", main);
        return "index";
    }

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("set", getStorage());
        return main;
    }

    @RequestMapping(value = "/main2", method = RequestMethod.GET)
    public String main2(@PathVariable String main){
        return main;
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main3(@RequestParam String message){
        helloMessage = new HelloMessage(message + " Your name was saved to local storage. ");
        try {
            addToStorage(message);
        }catch (Exception e){
        }
        return "redirect:/show";
    }

    @RequestMapping(value = "/show")
    public String show(Model model){
        model.addAttribute("msg", helloMessage.getMessage());
        System.out.println(helloMessage.getMessage());
        return info;
    }

    @RequestMapping(value = "/dbsave")
    public String saveToDB(Model model){
        model.addAttribute("msg", "Successfully saved to DB");
        dbStorage.save();
        return info;
    }

    @RequestMapping(value = "/delete")
    public String deleteFromDB(@RequestParam String message, Model model){
        dbStorage.delete(message);
        deleteFromStorage(message);
        model.addAttribute("msg", "Successfully deleted from database and local storage");
        return info;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login2(){
        return "login";
    }

    @RequestMapping(value = "/login/{password}", method = RequestMethod.GET)
    public String login(@PathVariable("password") String password){
        if("endava".equals(password))
        {
            return main;
        }
        return "error";
    }

}
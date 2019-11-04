package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
 
    @Autowired
    private UserService service;
    
    @RequestMapping("/")
    public String viewHomePage(Model model) {             
    	List<user> ListUser =service.listAll();
    	model.addAttribute("ListUser",ListUser);
    	
    	return "index";
    }
    
    @RequestMapping("/new")
    public String showNewUserPage(Model model) {  
        user user = new user();
        model.addAttribute("user", user);
         
        return "new_user";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") user user) {             
        service.save(user);
         
        return "redirect:/";
    }
    @RequestMapping("/edit/{iduser}")
    public ModelAndView showEditUserPage(@PathVariable(name="iduser") int iduser) {        
        ModelAndView mav = new ModelAndView("edit_user");
        user user = service.get(iduser);
        mav.addObject("user", user);
         
        return mav;
    }
    
    @RequestMapping("/delete/{iduser}")
    public String deleteUser(@PathVariable(name="iduser") int iduser) {         
        service.delete(iduser);
        return "redirect:/";       
    }
    
    
    // handler methods...
}


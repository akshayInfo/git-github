package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.app.model.User;
import com.app.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	 @RequestMapping(value="/",method = RequestMethod.GET)
		public String list(Model model) {
			model.addAttribute("user", new User());
			model.addAttribute("listUsers", this.userService.list());
			return "user";
		}
	        
	
	@RequestMapping(value="/add-user", method= RequestMethod.POST)
	public String add(@ModelAttribute("user") User b , Model model){
		
		if(b.getId()==0){
			this.userService.add(b);
			}
		else{			
			this.userService.update(b);				
		}
		
		return "redirect:/";		
		
	}
	
	        
	    @RequestMapping("/edit/{id}")
		public String edit(@PathVariable("id") int id, Model model) {
	      	model.addAttribute("user", userService.getById(id));
			model.addAttribute("listUsers", this.userService.list());
			return "user";
		}
	       
	    @RequestMapping("/remove/{id}")
		public String removeBank(@PathVariable("id") int id) {
			userService.remove(id);
			return "redirect:/";
		}
	
}

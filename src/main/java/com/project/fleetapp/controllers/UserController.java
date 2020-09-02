package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project.fleetapp.models.User;
import com.project.fleetapp.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView redirectView = new RedirectView("/login", true);
		
		redir.addFlashAttribute("message", "You successfully registered! you can now login");
		
		return redirectView;
	}
	
}

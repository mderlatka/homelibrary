package com.homelibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homelibrary.domain.User;
import com.homelibrary.service.UserRoleService;
import com.homelibrary.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired 
	UserRoleService userRoleService;

	@RequestMapping
	public String getAllUsers(Model model) {
		List<User> users= userService.findAll();
		for(User user : users){
			Integer userId = user.getUserId();
			user.setUserRoles(userService.findUserRoles(userId));
		}
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping("/user")
	public String getUserById(@RequestParam("id") Integer id, Model model) {
		User user = new User();
		user.setUserRoles(userService.findUserRoles(id));
		model.addAttribute("userRoles", user.getUserRoles());
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("userBooks", userService.getFavoriteUserBooks(id));
		return "userDetails";
	}

	@RequestMapping(value = "/delete/user", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		userService.removeUser(userService.getUserById(id));
		redirectAttributes.addFlashAttribute("deleteUsrSuccess", true);
		return "redirect:/users";
	}
}

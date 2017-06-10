package com.homelibrary.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homelibrary.domain.Book;
import com.homelibrary.domain.User;
import com.homelibrary.dto.UserDTO;
import com.homelibrary.service.BookService;
import com.homelibrary.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getAddNewUserForm(Model model) {
		UserDTO userDto = new UserDTO();
		model.addAttribute("userDto", userDto);
		return "registerForm";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String processAddNewUserForm(@ModelAttribute("userDto") @Valid UserDTO userDto, BindingResult result,
			RedirectAttributes redirectAttributes) {

		User user = new User();
		if (result.hasErrors()) {
			return "registerForm";
		}

		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		userService.insertUser(user);
		redirectAttributes.addFlashAttribute("addUserSuccess", true);
		return "redirect:/";
	}

	@RequestMapping("/account")
	public String getAccount(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userService.findUserByName(userName);
		Integer id = user.getUserId();
		user.setUserRoles(userService.findUserRoles(id));
		model.addAttribute("userRoles", user.getUserRoles());
		model.addAttribute("user", userService.findUserByName(userName));
		model.addAttribute("userBooks", userService.getFavoriteUserBooks(id));
		return "userAccount";
	}

	@RequestMapping(value = "/favorite/book", method = RequestMethod.POST)
	public String doAddFavoriteUserBook(@RequestParam("id") Integer id, Principal principal,
			RedirectAttributes redirectAttributes) {

		String userName = principal.getName();
		User user = userService.findUserByName(userName);
		Book book = bookService.getBookById(id);
		if (userService.getFavoriteUserBooks(user.getUserId()).contains(book)) {
			redirectAttributes.addFlashAttribute("usrHaveBookInFav", true);
		} else {
			userService.saveFavoriteUserBook(book, user);
			redirectAttributes.addFlashAttribute("addedFavUsrBookSuccessed", true);
		}
		return "redirect:/account";
	}
	
	@RequestMapping(value = "/delete/favorite/book", method = RequestMethod.POST)
	public String deleteFavoriteUserBook(@RequestParam("id") Integer id, Principal principal,
			RedirectAttributes redirectAttributes) {
		String userName = principal.getName();
		User user = userService.findUserByName(userName);
		Book book = bookService.getBookById(id);
		if (userService.getFavoriteUserBooks(user.getUserId()).contains(book)) 
			userService.removeFavoriteUserBook(book, user);
			redirectAttributes.addFlashAttribute("deleteFavUsrBookSuccessed", true);
		return "redirect:/account";
	}

}

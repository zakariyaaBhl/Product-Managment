package com.bhl.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bhl.crm.user.CrmUser;

@Controller
public class LoginController {

	@Autowired
	private UserDetailsManager userDetailsManager;
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/showLoginPage")
	public String login() {
		return "loginPage";
	}
	
	
	
	@GetMapping("/showRegistrationForm")
	public String registerForm(Model model) {
		model.addAttribute("user", new CrmUser());
		return "register";
	}
	
	///processRegistrationForm
	
	@PostMapping("/processRegistrationForm")
	public String register(Model model,@ModelAttribute("crmUser") @Valid CrmUser user, BindingResult bindingResult) {
		
		// form validation
		if (bindingResult.hasErrors()) {
			model.addAttribute("crmUser", user);
			return "register";
		}
		// check the database if user already exists
		if (doesUserExist(user.getUserName()) == true) {
			model.addAttribute("exist","the user already exists");
			return "register";
		}
		// encrypt the password
			String encodedPassword = bcpe.encode(user.getPassword());
		
		// give user default role of "employee"
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		// create user details object
			User tempUser = new User(user.getUserName(), encodedPassword, authorities);
		// save user in the database
			userDetailsManager.createUser(tempUser);
		return "registration-confirmation";
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	private boolean doesUserExist(String userName) {
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		return exists;
	}
}

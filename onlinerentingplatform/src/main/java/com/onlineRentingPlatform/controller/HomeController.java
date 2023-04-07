package com.onlineRentingPlatform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineRentingPlatform.dao.ProductRepository;
import com.onlineRentingPlatform.dao.UserRepository;
import com.onlineRentingPlatform.entities.Product;
import com.onlineRentingPlatform.entities.User;
import com.onlineRentingPlatform.helper.Message;

@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
@RequestMapping("/home")
public String home() {
	return "home";
}
@RequestMapping("/contactus")
public String contactus() {
	return "contactus";
}




@RequestMapping("/register")
public String register(Model model) {
	model.addAttribute("titlel" , "Register");
	model.addAttribute("user" , new User());
	return "register";
}

//handeler for registering
@RequestMapping(value="/register",method=RequestMethod.POST)

public String registerUser(@ModelAttribute("user")User user , @RequestParam(value="agreement",defaultValue = "false") boolean agreement,Model model , HttpSession session) {
	try {
	if(!agreement) {
		System.out.println("You have to agree the terms and condition");
	}
	user.setRole("ROLE_USER");
	user.setEnabled(true);
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	
	
	System.out.println("Agreement"+ agreement);
	System.out.println("User "+user);
	
	User result=this.userRepository.save(user);
	model.addAttribute("user" , result);
	session.setAttribute("message", new Message("Successfully Registered " , "aleart-Success"));
	return "register";
}catch(Exception e){
	e.printStackTrace();
	model.addAttribute("user" , user);
	session.setAttribute("message", new Message("Something is wrong!" +e.getMessage(),"Aleart-error"));
	return "register";
}

	


}
@GetMapping("/signin")
public String customLogin(Model model) {
	model.addAttribute("title","onlineRenting - login page");
	return "login";
}

@GetMapping("/rent/{pid}")
public String rent(@PathVariable int pid) {
	productRepository.deleteById(pid);
	return "show_products";
}

}

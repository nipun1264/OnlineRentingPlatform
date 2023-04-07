package com.onlineRentingPlatform.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineRentingPlatform.dao.ProductRepository;
import com.onlineRentingPlatform.dao.UserRepository;
import com.onlineRentingPlatform.entities.Product;
import com.onlineRentingPlatform.entities.User;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public ProductRepository productRepository;
	
	//method for having common data for all
	@ModelAttribute
	public void addCommonData(Model model,Principal principal) {
		String userName = principal.getName();
		System.out.println("User name =" +userName);
		User user=this.userRepository.getUserByUserName(userName);
		System.out.println("User : "+user);
		model.addAttribute("user", user);
	}
	
	
	//Landing Page after Log in
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		
		return "roleSelect";
	}
	
	
	
	
	
	//product details Form handeler
	@GetMapping("/lender")
	public String openAddProductForm(Model model) {
		model.addAttribute("Title" , "Add product");
		model.addAttribute("product",new Product());
		
		
		return "add_product_form";
	}
	
	//processing add product form
	@PostMapping("/process-product")
	public String processProduct(@ModelAttribute Product product,Principal principal){
		String name=principal.getName();
		User user=this.userRepository.getUserByUserName(name);
		product.setUser(user);
		user.getProducts().add(product);
		this.userRepository.save(user);
		System.out.println("Data : "+product);
		System.out.println("Contact added successfully");
		return "add_product_form";
	}

	//show Products
	@GetMapping("/show-products")
	public String showAllProducts(Model m,Principal principal) {
		List<Product> products=this.productRepository.findAll();
		m.addAttribute("products",products);
		return "show_products";
	}
	
	
	//updating form
	

}

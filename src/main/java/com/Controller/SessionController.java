package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.Num;
import com.Bean.UserBean;

@Controller
public class SessionController {
	
	@GetMapping("/signup")
	public String signup() {
		return  "Signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return  "Login";
	}
	
	@PostMapping("/saveuser")
	public String saveuser(UserBean userbean, Model model) {

		System.out.println("Firstname"+ userbean.getFirstName());
		System.out.println("Firstname"+ userbean.getEmail());
		System.out.println("Firstname"+ userbean.getConfirmPassword());
		System.out.println("Firstname"+ userbean.getPassword());
		System.out.println("Firstname"+ userbean.getLastName());
		
		//send data to home
		model.addAttribute("user",userbean);
		
		return  "Home";
		
	}
	
	@GetMapping("/number")
	public String number() {
		return "Number";
	}
	
	@PostMapping("/add")
	public String add(Num num, Model model) {
		int ans = num.getNumber1() + num.getNumber2();

		
		//send data to result
		model.addAttribute("ans",ans);
		model.addAttribute("num", num);
		return "Result";
	}
}

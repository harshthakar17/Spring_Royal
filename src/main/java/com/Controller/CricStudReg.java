package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.CricStudBean;
import com.Util.Validator;



@Controller
public class CricStudReg {
				
		@GetMapping("/boxcricketregistration")
		public String boxRegistration() {
			return "BoxCricReg";
		}
		
		@PostMapping("/savereg")
		public String saveRegistration(CricStudBean crs, Model model) {
			System.out.println("Name" + crs.getStudentName());
			System.out.println("Name" + crs.getDrink());
			System.out.println("Name" + crs.getFoodPreference());
			System.out.println("Name" + crs.getPlayerType());
			
			boolean isError = false;


			if (Validator.isBlank(crs.getStudentName())) {
				isError = true;
				model.addAttribute("studentNameError","Please Enter Student Name");
			}else if(Validator.isAlph(crs.getStudentName())) {
				isError = true;
				model.addAttribute("studentNameError","Please enter Valid student name");
			}else {
				model.addAttribute("studentNameValue", crs.getStudentName());
			}

			
			if (Validator.isBlank(crs.getPlayerType())) {
				isError = true;
				model.addAttribute("playerTypeError","Please Select PlayerType");
			}

			if (Validator.isBlank(crs.getFoodPreference())) {
				isError = true;
				model.addAttribute("foodPreferenceError","Please Selecct FoodPreference");
			}
			if (Validator.isBlank(crs.getDrink())) {
				isError = true;
				model.addAttribute("drinkError","Please Selecct Drink");
			}

			if (isError == true) {
				model.addAttribute("reg", crs);
				return "BoxCricReg";
			}
			else {
				// how to send data to jsp from controller ?
				model.addAttribute("reg", crs);// data name -> data value
				
			
				return "RegDetail";
			}
		}
	}


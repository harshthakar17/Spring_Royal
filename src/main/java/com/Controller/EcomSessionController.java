package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.EUserBean;
import com.Dao.EUserDao;
import com.Service.FileUploadService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EcomSessionController {
	@Autowired
	EUserDao userDao;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@GetMapping(value = {"/","elogin"})
	public String welcome() {
		return "EcomLogin";
	}
	
	@PostMapping("/elogin")
	public String eLogin(EUserBean userbean,Model model, HttpSession session) {
		
		EUserBean dbUser =userDao.authenticate(userbean.getEmail(),userbean.getPassword());
		if (dbUser == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "EcomLogin";
		} else {

			session.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("profilePicPath", dbUser.getProfilePicPath());	
			return "EcomHome";
		}
	}
	
	@GetMapping("/esignup")
	public String signup() {
		return "EcomSignup"; 
	}

	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) {
		//jsp form -> controller -> 
		
		//validation 
		
		fileUploadService.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());

		// images//profilepic//rock1@gmail.com//123.png

		userBean.setProfilePicPath(
				"images//profilepic//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
		
		//insert  	
		userDao.insertUser(userBean);
		
		return "EcomLogin";
	}
	
	@GetMapping("elogout")
	public String LogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/elogin";
	}
	
}

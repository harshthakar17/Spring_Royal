package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Bean.EProductBean;
import com.Dao.EProductDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EProductController {

	@Autowired
	EProductDao productDao;
	
	@GetMapping("/newproduct")
	public String newProduct() {// method name
		return "NewProduct";// jsp name
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean) {
		// using bean read data-->product bean
		
		//validation using xx
		
		//dao insert
		productDao.addProduct(productBean);
		return "Welcome";
	}
	
}

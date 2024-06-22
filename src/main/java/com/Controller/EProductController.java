package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
		return "Home";
	} 
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<EProductBean> products = productDao.getAllProducts();// return type

		model.addAttribute("products", products);

		return "EcomListProducts";
	}
	
}

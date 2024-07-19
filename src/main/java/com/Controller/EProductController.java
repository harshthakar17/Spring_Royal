package com.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.Bean.EProductBean;
import com.Dao.EProductDao;
import com.Service.FileUploadService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class EProductController {

	@Autowired
	EProductDao productDao;
	
	@Autowired
	FileUploadService fileUploadService; 
	
	@GetMapping("/newproduct")
	public String newProduct() {// method name
		return "NewProduct";// jsp name
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean,@RequestParam("masterImage") MultipartFile masterImage) {
		// using bean read data-->product bean
		
		//validation using xx
		
		//dao insert

		//fileUploadService.uploadProductImage(masterImage);
		productDao.addProduct(productBean);
		
		return "redirect:/products";
	} 
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<EProductBean> products = productDao.getAllProducts();// return type

		model.addAttribute("products", products);

		return "EcomListProducts";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		
		productDao.deleteProduct(productId);
		return "redirect:/products";
	}
	
	@GetMapping("/productname")
	public String productName() {
		return "DeleteProductName";
	}
	
	@PostMapping("/deleteproductname")
	public String deleteProductName(EProductBean productBean) {
		productDao.deleteProductName(productBean.getProductName());
		return "redirect:/products";
	}
	// form ->data -> read -> bean

		// hyperlink -> ? -> query string -> @RequestParam("q") datatyep variablename
		// @RequestParam("productId") Integer productId

		@GetMapping("/viewproduct")
		public String viewProduct(@RequestParam("productId") Integer productId, Model model) {

			// id->details->table : products
			// select * from products where productId = ?
			EProductBean productBean = productDao.getProductById(productId);
			model.addAttribute("product", productBean);

			return "ViewProduct";
		}
	
}

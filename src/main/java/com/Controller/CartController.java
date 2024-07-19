package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.ECartBean;
import com.Bean.EUserBean;
import com.Dao.CartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	CartDao cartDao;
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("productId") Integer productId, HttpSession session) {

		EUserBean userbean = (EUserBean) session.getAttribute("user");

		Integer userId = userbean.getUserId();

		ECartBean cartBean = new ECartBean();

		cartBean.setProductId(productId);
		cartBean.setUserId(userId);

		cartDao.addToCart(cartBean);

		return "redirect:/userproducts";// url
	}
	
}

package com.example.restartboard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restartboard.dto.ProductDTO;
import com.example.restartboard.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/order")
@Controller
@RequiredArgsConstructor
public class OrderController {

	private final ProductService productService;
	
	@GetMapping({"", "/"})
	public String order(Model model) {
		
		List<ProductDTO> productList = productService.getProductList();
		
		model.addAttribute("productList", productList);
		
		return "order/list"; 
	}
	
	@GetMapping("/detail/{productId}")
	public String orderDetail(@PathVariable Long productId, Model model) {
		
		ProductDTO product = productService.getProduct(productId);
		
		model.addAttribute("product", product);
		
		return "order/detail"; 
	}
	
	@GetMapping("/orderPage/{productId}")
	public String orderPage(@PathVariable Long productId, Model model) {
		
		ProductDTO product = productService.getProduct(productId);
		
		model.addAttribute("product", product);
		
		return "order/orderPage"; 
	}

	
}

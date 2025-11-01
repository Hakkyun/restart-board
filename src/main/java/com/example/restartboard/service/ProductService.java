package com.example.restartboard.service;

import java.util.List;

import com.example.restartboard.dto.ProductDTO;

public interface ProductService {

	public List<ProductDTO> getProductList();
	
	public ProductDTO getProduct(Long productId);
}

package com.example.restartboard.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restartboard.dto.ProductDTO;
import com.example.restartboard.mapper.ProductMapper;
import com.example.restartboard.service.ProductService;

@Service
public class productServiceImpl implements ProductService {

	private final ProductMapper productMapper;
	
	public productServiceImpl(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	@Override
	public List<ProductDTO> getProductList() {

		List<ProductDTO> productList = productMapper.getProductList();
		
		return productList;
	}

	@Override
	public ProductDTO getProduct(Long productId) {

		ProductDTO product = productMapper.getProduct(productId);
		
		return product;
	}

}

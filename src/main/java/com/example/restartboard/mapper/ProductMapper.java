package com.example.restartboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.restartboard.dto.ProductDTO;

@Mapper
public interface ProductMapper {

	// 상품 리스트 조회
	public List<ProductDTO> getProductList();
	
	// 단일 상품 조회
	public ProductDTO getProduct(Long productId);
	
}

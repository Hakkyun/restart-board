package com.example.restartboard.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

	private Long productId;
	private String productName;
	private Integer productUnitPrice;
	private LocalDateTime productRegistTime;
	private String userName;
	private String userEmail;
	
}

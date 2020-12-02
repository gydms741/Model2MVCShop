package com.model2.mvc.service.product;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


public interface ProductService {
	
	public void addProduct(Product product) throws Exception;
	//상품등록을 위한 비즈니스 로직을 수행한다.
	
	public Product getProduct(int prodNo) throws Exception;
	//상품정보 조회를 위한 비즈니스 로직을 수행한다.

	public Map<String,Object> getProductList(Search search) throws Exception;
	//상품목록 조회를 위한 비즈니스 로직을 실행한다.
	
	public int removeProduct(String prodName) throws Exception;
	//상품삭제를 위한 비즈니스 로직 실행
	
	public void updateProduct(Product product) throws Exception;
	//상품정보 수정을 위한 비즈니스 로직을 실행한다. 
	
}
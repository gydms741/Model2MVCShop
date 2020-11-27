package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration ¿ÃøÎ Wiring, Test «“ instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testInsertProduct() throws Exception {
		
		Product product = new Product();
		
		//product.setProdNo(00000001);
		product.setProdName("testProdName");
		product.setProdDetail("testProdDetail");
		product.setManuDate("ManuDate");
		product.setPrice(5000);
		product.setFileName("testFileName");
		
		productService.addProduct(product);
		
		//==> console »Æ¿Œ
		System.out.println(product);
		
		//==> API »Æ¿Œ
		//Assert.assertEquals(00000001, product.getProdNo());
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("ManuDate", product.getManuDate());
		Assert.assertEquals(5000, product.getPrice());
		Assert.assertEquals("testFileName", product.getFileName());
	}
	
	
	//@Test
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
		product = productService.getProduct(10084);
		System.out.println(product);

		
		//==> API »Æ¿Œ
		Assert.assertEquals(10084, product.getProdNo());
		Assert.assertEquals("ƒ´ƒ´ø¿", product.getProdName());
		Assert.assertEquals("√ ƒ⁄∑ø", product.getProdDetail());
		Assert.assertEquals("2020-11-01", product.getManuDate());
		Assert.assertEquals(3500, product.getPrice());

		
		//Assert.assertNotNull(productService.getProduct(10344));
	}
	
	//@Test
	 public void testUpdateProduct() throws Exception{
		 
		Product product = productService.getProduct(10084);
		
//		Assert.assertEquals("testProdName", product.getProdName());
//		Assert.assertEquals("testProdDetail", product.getProdDetail());
//		Assert.assertEquals("ManuDate", product.getManuDate());
//		Assert.assertEquals(5000, product.getPrice());
//		Assert.assertEquals("testFileName", product.getFileName());

		product.setProdName("¡¶¿∞∫∫¿Ω");
		product.setProdDetail("∏¿¿÷¥Ÿ ∏¿¿÷æÓ");
		product.setManuDate("2020-11-16");
		product.setPrice(5500);
		product.setFileName(" ");
		
		productService.updateProduct(product);
		
		product = productService.getProduct(10084);
		
		Assert.assertEquals("¡¶¿∞∫∫¿Ω", product.getProdName());
		Assert.assertEquals("∏¿¿÷¥Ÿ ∏¿¿÷æÓ", product.getProdDetail());
		Assert.assertEquals("2020-11-16", product.getManuDate());
		Assert.assertEquals(5500, product.getPrice());
		Assert.assertEquals(" ", product.getFileName());
	 }
	 
	
	 //@Test
	 public void testGetProductList() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(5, list.size());
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("10084");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	// @Test
	 public void testGetProductListByPrice() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("2");
	 	search.setSearchKeyword("333");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console »Æ¿Œ
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console »Æ¿Œ
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 @Test
	 public void testGetProductListByProdName() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("¡¶¿∞∫∫¿Ω");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(2, list.size());
	 	
		//==> console »Æ¿Œ
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console »Æ¿Œ
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }	 
}
package com.model2.mvc.service.product.test;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductDaoImpl11;
import com.model2.mvc.service.product.impl.ProductServiceImpl12;

/*
 * FileName : MyBatisTestApp101.java
  */
public class ProductTestApp13 { 
	
	///main method
	public static void main(String[] args) throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"/config/commonservice13.xml",
																						"/config/productservice13.xml"});
		System.out.println("\n");
		
		ProductService productService = (ProductService)context.getBean("productServiceImpl12");
		
		//==> Test �� Product instance ����  
		Product product = new Product("����", "���־�", "20-11-11", 30000, "filename");
		
		//1. UserMapper10.addUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK 
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		productService.addProduct(product);
		System.out.println("insertProductȮ��:"+product);
		System.out.println("\n");

		System.out.println(":: 2. getProduct(SELECT)  ? ");
		System.out.println(":: "+ productService.getProduct(10084));
		System.out.println("\n");
		
		//3. UserMapper10.uadateUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK
		//:: ���� ==> ���� ����
		product.setProdName("����");
		product.setPrice(16000);
		
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		productService.updateProduct(product);
		System.out.println("updateProduct"+product);
		System.out.println("\n");
		
		//4. UserMapper10.getUserList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. getProductList(SELECT)  ? ");
		
		Search search = new Search();
		
		search.setSearchCondition("1");
		search.setSearchKeyword("īī��");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("����");
		search.setProdDetail(arrayList);
		
		System.out.println(":: List<User> ���� :"+ productService.getProductList(search));
		System.out.println("\n");
		
		//5. UserMapper10.removeUser Test
		System.out.println(":: 5. removeProduct (DELETE)  ? ");
		Product product2 = new Product();
		product2.setProdName("����");
		System.out.println(":: "+ productService.removeProduct(product2.getProdName()));
		System.out.println("\n");
		
		System.out.println(":: 6. getProductList (SELECT)  ? ");
		System.out.println("List<Product> "+ productService.getProductList(search));
		System.out.println("\n");

	}//end of main
}//end of class
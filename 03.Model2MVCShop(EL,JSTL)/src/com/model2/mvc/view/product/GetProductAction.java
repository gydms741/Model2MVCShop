package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;


public class GetProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		String menu = request.getParameter("menu");
		//String prodName = request.getParameter("prodName");//��û�� String���� �ް�
		//NumberFormatException ����!
		System.out.println("GetProductAction"+prodNo);//�ҹ�������
		ProductService service = new ProductServiceImpl();
		Product product = service.getProduct(prodNo);
		//ProductVO vo = service.getProduct(Integer.parseInt(prodNo));
		
		request.setAttribute("product", product);
		request.setAttribute("menu", menu);
		
		System.out.println("product"+product);
		
		return "forward:/product/getProduct.jsp";
	}
}
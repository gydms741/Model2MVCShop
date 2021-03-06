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
		//String proNo = request.getParameter("prodNo");//요청은 String으로 받고
		//NumberFormatException 주의!
		System.out.println("GetProductAction"+prodNo);//소문자주의
		ProductService service = new ProductServiceImpl();
		Product product = service.getProduct(prodNo);
		//ProductVO vo = service.getProduct(Integer.parseInt(prodNo));
		
		request.setAttribute("product", product);
		request.setAttribute("menu", menu);
		
		System.out.println("product"+product);
		
		return "forward:/product/getProduct.jsp";
	}
}
package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String prodName = (request.getParameter("prodName"));
		//int prodNo = Integer.parseInt(request.getParameter("prodNo"));
//		String menu = (String)request.getParameter("menu");
		
		Product product = new Product();
		product.setProdNo(product.getProdNo());
		product.setProdName(request.getParameter("prodName"));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setManuDate(request.getParameter("manuDate"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));
		
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(product);
		System.out.println("product���� �����"+product);
		
		HttpSession session=request.getSession();//���� �� �� ���ǿ� ��´�
		String sessionId=((Product)session.getAttribute("product")).getProdName();
		System.out.println("session�� ���� ���� �����");
		
		if(sessionId.equals(prodName)){
			session.setAttribute("product", product);
		}
		
		return "forward:/updateProduct.do?prodName="+prodName;
	}

}
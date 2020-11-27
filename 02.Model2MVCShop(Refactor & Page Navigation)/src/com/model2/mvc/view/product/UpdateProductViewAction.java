package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class UpdateProductViewAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));//주의 : 
		String menu = request.getParameter("menu");

		ProductService service=new ProductServiceImpl();
		Product product=service.getProduct(prodNo);
		System.out.println(prodNo+"prodNo입니다");

		request.setAttribute("product", product);//담아서 화면으로 출력

			return "forward:/product/updateProductView.jsp";
	}


}

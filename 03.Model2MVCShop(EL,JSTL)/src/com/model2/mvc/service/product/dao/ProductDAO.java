package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.domain.Product;

public class ProductDAO {

	public ProductDAO() {
	}
	
	public void insertProduct(Product product) throws Exception{
		
		Connection con = DBUtil.getConnection();
		//새로운 객체 생성하지 않아도 된다. 
		
		String sql = "insert into product values (seq_product_prod_no.nextval,?,?,?,?,?,sysdate)";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, product.getProdName());
		stmt.setString(2, product.getProdDetail());
		stmt.setString(3, product.getManuDate());
		stmt.setInt(4, product.getPrice());
		stmt.setString(5, product.getFileName());

		//stmt.executeUpdate();
		
		//디버깅용
		int confirm = stmt.executeUpdate();
		
		if (confirm == 1) {
			System.out.println("완");
			System.out.println(product);
		}else {
			System.out.println("패");
		}
		
		con.close();
	}
	
public Map<String, Object> getProductList(Search search) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Connection con = DBUtil.getConnection();
		
		//Original Query구성
		String sql = "select * from PRODUCT ";
		
		if (search.getSearchCondition() != null) {
			if (search.getSearchCondition().equals("0") &&  !search.getSearchKeyword().equals("") ){
				sql += "where PROD_NO like '%' || '"+search.getSearchKeyword()+"' || '%'";
			}else if (search.getSearchCondition().equals("1") && !search.getSearchKeyword().equals("")) {
				sql += "where PROD_NAME='"+search.getSearchCondition()+"'";
			}else if (search.getSearchCondition().equals("2") && !search.getSearchKeyword().equals("")) {
				sql += "where PRICE='"+search.getSearchKeyword()+"'";
			}
		}
		sql += "order by PROD_NO";
		
		System.out.println("ProductDAO::Original SQL ::" + sql);
		
		int totalCount = this.getTotalCount(sql);
		
		sql = makeCurrentPageSql(sql, search);
		PreparedStatement pStmt = 
				con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		
		System.out.println(search);
		
		List<Product> list = new ArrayList<Product>();
		
		while(rs.next()) {
			Product product = new Product();
			product.setFileName(rs.getString("IMAGE_FILE"));
			product.setProdDetail(rs.getString("PROD_DETAIL"));
			product.setProdName(rs.getString("PROD_NAME"));
			product.setManuDate(rs.getString("MANUFACTURE_DAY"));
			product.setPrice(rs.getInt("PRICE"));
			product.setProdNo(rs.getInt("PROD_NO"));
			product.setRegDate(rs.getDate("REG_DATE"));
			list.add(product);
		}
		
		map.put("totalCount", new Integer(totalCount));
		map.put("list", list);
		
		rs.close();
		pStmt.close();
		con.close();
		
		return map;
	}

	

	public Product findProduct(int prodNo) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select * from PRODUCT where PROD_NO = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, prodNo);
		
		ResultSet rs = stmt.executeQuery();
		
		System.out.println(prodNo);
		System.out.println("findProduct : productDAO sql 해결?");
		Product productVO = null;
		while (rs.next()) {
			productVO = new Product();
			productVO.setProdNo(rs.getInt("PROD_NO"));
			productVO.setProdName(rs.getString("PROD_NAME"));
			productVO.setProdDetail(rs.getString("PROD_DETAIL"));
			productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
			productVO.setPrice(rs.getInt("PRICE"));
			productVO.setFileName(rs.getString("IMAGE_FILE"));
			productVO.setRegDate(rs.getDate("REG_DATE"));
			
			System.out.println("productVO까지옴");
		}
		
		con.close();
		
		return productVO;
		
	}
	
	public void updateProduct(Product product) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql = "update PRODUCT set PROD_NAME=?,PROD_DETAIL=?,MANUFACTURE_DAY=?,PRICE=?,IMAGE_FILE=? where PROD_NO=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, product.getProdName());
		stmt.setString(2, product.getProdDetail());
		stmt.setString(3, product.getManuDate());
		stmt.setInt(4, product.getPrice());
		stmt.setString(5, product.getFileName());
		stmt.setInt(6, product.getProdNo());
		
		
		int confirm = stmt.executeUpdate();
		if (confirm == 1) {
			System.out.println("product update완료");
			System.out.println(product);
		}else {
			System.out.println("product update실패");
		}
		con.close();
	}
	
	private int getTotalCount(String sql) throws Exception {
		
		sql = "SELECT COUNT(*) "+
		          "FROM ( " +sql+ ") countTable";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		
		int totalCount = 0;
		if( rs.next() ){
			totalCount = rs.getInt(1);
		}
		
		pStmt.close();
		con.close();
		rs.close();
		
		return totalCount;
	}


	private String makeCurrentPageSql(String sql, Search search) {
		sql = 	"SELECT * "+ 
				"FROM (		SELECT inner_table. * ,  ROWNUM AS row_seq " +
								" 	FROM (	"+sql+" ) inner_table "+
								"	WHERE ROWNUM <="+search.getCurrentPage()*search.getPageSize()+" ) " +
				"WHERE row_seq BETWEEN "+((search.getCurrentPage()-1)*search.getPageSize()+1) +" AND "+search.getCurrentPage()*search.getPageSize();
	
		System.out.println("ProductDAO :: make SQL :: "+ sql);	
	
		return sql;
	}

}





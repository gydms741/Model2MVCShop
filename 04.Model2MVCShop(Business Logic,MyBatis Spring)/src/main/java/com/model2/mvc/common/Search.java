package com.model2.mvc.common;

import java.util.ArrayList;

//==>리스트화면을 모델링(추상화/캡슐화)한 Bean 
public class Search {
	
	///Field
	private String[] prodName;
	private ArrayList<String> prodDetail;
	
	private int currentPage;
	private String searchCondition;
	private String searchKeyword;
	private int pageSize;
	//==> 리스트화면 currentPage에 해당하는 회원정보를 ROWNUM 사용 SELECT 위해 추가된 Field 
	//==> UserMapper.xml 의 
	//==> <select  id="getUserList"  parameterType="search"	resultMap="userSelectMap">
	//==> 참조
	private int endRowNum;
	private int startRowNum;
	
	///Constructor
	public Search() {
	}
	
	///Method
	
	
	public int getPageSize() {
		return pageSize;
	}
	public String[] getProdName() {
		return prodName;
	}

	public void setProdName(String[] prodName) {
		this.prodName = prodName;
	}

	public ArrayList<String> getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(ArrayList<String> prodDetail) {
		this.prodDetail = prodDetail;
	}

	public void setPageSize(int paseSize) {
		this.pageSize = paseSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	//==> Select Query 시 ROWNUM 마지막 값 
	public int getEndRowNum() {
		return 5;
	}
	//==> Select Query 시 ROWNUM 시작 값
	public int getStartRowNum() {
		return 1;
	}

	@Override
	public String toString() {
		return "Search [currentPage=" + currentPage + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword
				+ ", pageSize=" + pageSize + ", endRowNum=" + endRowNum
				+ ", startRowNum=" + startRowNum + "]";
	}

	
}
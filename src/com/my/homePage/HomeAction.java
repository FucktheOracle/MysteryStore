package com.my.homePage;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.my.entity.Customer;
import com.my.entity.Product;

public class HomeAction {

	private HomeService service;

	public void setService(HomeService service) {
		this.service = service;
	}

	/* ��ѯ��ҳ��ɫ��Ʒ��ʼ */
	private List<Product> listFeat;

	public List<Product> getListFeat() {
		return listFeat;
	}

	public void setListFeat(List<Product> listFeat) {
		this.listFeat = listFeat;
	}

	public String queryFeat() {
		this.listFeat = this.service.queryFeat();
		this.queryGenderNum();
		this.queryNew();
		this.queryCount();
		return "success";
	}

	/* ��ѯ��ҳ��ɫ��Ʒ���� */

	/* ��ѯ����������ʼ */
	private int menNum;
	private int womenNum;
	private int childNum;

	public int getWomenNum() {
		return womenNum;
	}

	public int getChildNum() {
		return childNum;
	}

	public int getMenNum() {
		return menNum;
	}

	public void queryGenderNum() {
		this.menNum = service.queryGenderNum("��");
		this.womenNum = service.queryGenderNum("Ů");
		this.childNum = service.queryGenderNum("��ͯ");
	}
	/* ��ѯ������������ */
	
	/*��ѯ�����ϼ� ------------begin*/
	private List productNewList;

	public List getProductNewList() {
		return productNewList;
	}
	
	public void queryNew() {
		this.productNewList = service.queryNew();
		
	}
	/*��ѯ�����ϼ� -----------end*/
	
	/*��ѯ��Ը�������ﳵ����------begin*/
	private int cartNum;
	
	public int getCartNum() {
		return cartNum;
	}

	public String queryCount() {
		Customer cust = (Customer) ServletActionContext.getRequest()
				.getSession().getAttribute("custInfo");
		if(cust != null) {
			this.cartNum = service.queryCartCount(cust);
			int wishNum = service.queryWishConut(cust);
			ServletActionContext.getRequest().getSession().setAttribute("cartNum", cartNum);
			ServletActionContext.getRequest().getSession().setAttribute("wishNum", wishNum);
		}
		return "success";
	}
	/*��ѯ��Ը�������ﳵ����------end*/
	
	
	
	
	
	
}

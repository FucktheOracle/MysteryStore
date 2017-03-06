package com.my.customer;

import org.apache.struts2.ServletActionContext;

import com.my.entity.Customer;

public class LoginAction {

	private LoginService service;

	public void setService(LoginService service) {
		this.service = service;
	}
	
	/*��֤�û��������û���Ϣ����session��------------ ��ʼ*/
	private Customer cust;
	
	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String testLogin() {
		Customer custInfo = service.testLogin(this.cust);
		if(custInfo != null) {
			ServletActionContext.getRequest().getSession().setAttribute("custInfo", custInfo);
			return "success";
		} else {
			return "fail";
		}
	}
	/*��֤�û�------------------------����*/
	
	/*��֤�û��Ƿ��¼----------------��ʼ*/
	private boolean isLogin;

	public boolean getIsLogin() {
		return isLogin;
	}

	public String checkLogin() {
		Customer cust = (Customer) ServletActionContext.getRequest()
				.getSession().getAttribute("custInfo");
		if (cust != null) {
			this.isLogin = true;
		} else {
			this.isLogin = false;
		}
		return "success";
	}
	/*��֤�û��Ƿ��¼----------------����*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * 
 * @Description 增删改查
 * @author FLD
 * @version
 * @date 2020年2月22日下午5:25:48
 *
 */
public class CustomerList {
	private Customer[] customers;
	private int total;
	//用来初始化数组
	public CustomerList(int totalCustomer) {
		customers=new Customer[totalCustomer];
	}
	//添加客户,成功返回true
	public boolean addCustomer(Customer customer) {
		if(total>=customers.length) return false;
		customers[total]=customer;
		total++;
		return true;
	}
	//修改指定索引位置的客户信息，成功返回true
	public boolean replaceCustomer(int index,Customer cust) {
		if(index<0||index>=total) return false;
		customers[index]=cust;
		return true;
	}
	//删除指定索引位置的客户，成功返回true
	public boolean deleteCustomer(int index) {
		if(index<0||index>=total) return false;
		for(int i=index;i<total-1;i++) {
			customers[i]=customers[i+1];
		}
		customers[total-1]=null;
		total--;
		return true;
	}
	//获取所有客户信息
	public Customer[] getAllCustomers() {
		Customer [] custs=new Customer[total];
		for(int i=0;i<total;i++) {
			custs[i]=customers[i];
		}
		return custs;
	}
	//获取指定索引位置上的客户
	public Customer getCustomer(int index) {
		if(index<0||index>=total) return null;
		return customers[index];
	}
	//获取客户数量
	public int getTotal() {
		return total;
	}
}

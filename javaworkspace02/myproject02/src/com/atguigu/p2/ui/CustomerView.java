package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

/**
 * 
 * @Description 负责菜单的显示和用户的操作
 * @author FLD
 * @version
 * @date 2020年2月22日下午5:27:30
 *
 */
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);

	public CustomerView() {
		Customer customer = new Customer("王涛", '男', 23, "13212341234", "wt@fmil.com");
		customerList.addCustomer(customer);
	}

	// 显示界面
	public void enterMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			System.out.println("\n---------------客户信息管理软件---------------\n");
			System.out.println("               1 添加客户");
			System.out.println("               2 修改客户");
			System.out.println("               3 删除客户");
			System.out.println("               4 客户列表");
			System.out.println("               5 退        出\n");
			System.out.println("              请选择(1-5):");
			char menu = CMUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("确认是否退出(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
				}
			}
		}
	}

	// 添加客户的操作
	private void addNewCustomer() {
		System.out.println("\n---------------添加客户---------------");
		System.out.println("姓名:");
		String name = CMUtility.readString(10);
		System.out.println("性别:");
		char gender = CMUtility.readChar();
		System.out.println("年龄:");
		int age = CMUtility.readInt();
		System.out.println("电话:");
		String phone = CMUtility.readString(13);
		System.out.println("邮箱:");
		String email = CMUtility.readString(30);
		// 将上数据封装
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean issuccess = customerList.addCustomer(customer);
		if (issuccess) {
			System.out.println("---------------添加完成---------------");
		} else {
			System.out.println("---------------客户目录已满，添加失败---------------");
		}

	}

	// 修改客户的操作
	private void modifyCustomer() {
		System.out.println("\n---------------修改客户---------------");
		Customer cust;
		int number;
		for (;;) {
			System.out.println("请选择待修改客户编号(-1退出)");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			} else {
				cust = customerList.getCustomer(number - 1);
				if (cust == null) {
					System.out.println("无法找到指定客户!");
				} else {
					break;
				}
			}
		}
		System.out.println("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.println("性别(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("电话(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.println("邮箱(" + cust.getEmail() + "):");
		String email = CMUtility.readString(30, cust.getEmail());
		Customer newCust = new Customer(name, gender, age, phone, email);
		boolean isrepalaced = customerList.replaceCustomer(number - 1, newCust);
		if (isrepalaced) {
			System.out.println("---------------修改完成---------------");
		} else {
			System.out.println("---------------修改失败---------------");
		}
	}

	// 删除客户的操作
	private void deleteCustomer() {
		System.out.println("\n---------------删除客户---------------");
		int number;
		Customer customer;
		for (;;) {
			System.out.println("请选择待删除客户编号(-1退出)");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}
			customer = customerList.getCustomer(number-1);
			if(customer==null) {
				System.out.println("无法找到指定客户!");
			}else {
				break;
			}
		}
		System.out.println("确认是否删除(Y/N):");
		char isdelete = CMUtility.readConfirmSelection();
		if(isdelete=='Y') {
			 boolean deletesuccess = customerList.deleteCustomer(number-1);
			 if(deletesuccess) {
				 System.out.println("---------------删除成功---------------");
			 }else {
				 System.out.println("---------------删除失败---------------");
			 }
		}else {
			return;
		}
	}

	// 显示客户列表的操作
	private void listAllCustomers() {
		System.out.println("\n---------------客户列表---------------");
		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
						+ "\t" + cust.getPhone() + "\t" + cust.getEmail());
			}
		}
		System.out.println("---------------客户列表完成---------------");
	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}

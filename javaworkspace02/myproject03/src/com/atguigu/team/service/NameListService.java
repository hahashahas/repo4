package com.atguigu.team.service;

import static com.atguigu.team.service.Data.*;
import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

/**
 * 
 * @Description
 * @author FLD
 * @version
 * @date 2020年3月14日下午1:07:36
 *
 */
public class NameListService {
	private Employee[] employees;

	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0; i < employees.length; i++) {
			// 获取员工类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// 获取Employee的四个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}

	/**
	 * 
	 * @Description获取指定index上的员工的设备
	 * @author FLD
	 * @date 2020年3月15日上午9:04:12
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch (type) {
		case PC:
			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK:
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(EQUIPMENTS[index][1], price);
		case PRINTER:
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		return null;
	}
	/**
	 * 
	 * @Description获取当前所有员工
	 * @author FLD
	 * @date 2020年3月15日上午9:45:16
	 * @return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * 
	 * @Description获取指定Id的员工对象
	 * @author FLD
	 * @date 2020年3月15日上午9:46:05
	 * @param id
	 * @return
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id) throws TeamException {
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId()==id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
}

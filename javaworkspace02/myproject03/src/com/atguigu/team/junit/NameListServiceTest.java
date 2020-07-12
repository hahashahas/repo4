package com.atguigu.team.junit;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

/**
 * 
 * @Description 对namelistserves的测试
 * @author FLD
 * @version
 * @date 2020年3月17日上午8:19:28
 *
 */
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service =new NameListService();
		Employee[] employees=service.getAllEmployees();
		for(int i=0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	@Test
	public void testGetEmployee() {
		NameListService service =new NameListService();
		int id=101;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}

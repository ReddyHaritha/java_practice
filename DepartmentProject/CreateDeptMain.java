package com.hcl.dept;

import java.util.List;


public class CreateDeptMain {
	public static void main(String[] args) {
		DepartmentDAO dao=new DepartmentDAO();
		List<Department> deptList=dao.showDepartment();
		for (Department dept : deptList) {
			System.out.println("Dept no: "+dept.getDeptNo());
			System.out.println("Dept name "+dept.getdName());
			System.out.println("Location "+dept.getLoc());
			System.out.println("City "+dept.getCity());
			System.out.println("Head "+dept.getHead());
			System.out.println("-------------------------");
		}
	}
}

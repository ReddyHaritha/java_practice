package com.hcl.dept;

import java.util.Scanner;


public class AddDepartmentMain {
	public static void main(String[] args) {
		DepartmentDAO dao=new DepartmentDAO();
		//System.out.println(dao.generateDepartment());
		Department dept=new Department();
		int deptno=dao.generateDepartment();
		dept.setDeptNo(deptno);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Dept name ");
		dept.setdName(sc.nextLine());
		System.out.println("Enter City ");
		dept.setCity(sc.nextLine());
		System.out.println("Enter Loc ");
		dept.setLoc(sc.nextLine());
		System.out.println("Enter Head ");
		dept.setHead(sc.nextLine());
		System.out.println(dao.addDepartment(dept));
	}
}

package com.hcl.dept;

import java.util.Scanner;


public class DeleteDepartmentMain {
	public static void main(String[] args) {
		int deptno;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Department no: ");
		deptno=sc.nextInt();
		DepartmentDAO dao=new DepartmentDAO();
		System.out.println(dao.deleteDepartment(deptno));	
	}
}

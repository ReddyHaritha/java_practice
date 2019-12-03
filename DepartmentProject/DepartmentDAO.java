package com.hcl.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
	Connection connection;
	PreparedStatement pst;
	public String deleteDepartment(int deptno) {
		connection=DaoConnection.getConnection();
		Department dept=searchDepartment(deptno);
		String result="";
		if(dept!=null) {
			String cmd=" Delete From Department where Deptno=? ";
			try {
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, deptno);
				pst.executeUpdate();
				result="Record Deleted...";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else {
			result="Record not found...";
		}
		return result;
	}
	public Department searchDepartment(int deptno) {
		connection=DaoConnection.getConnection();
		String cmd=" select *from Department where Deptno=? ";
		Department dept=null;
		try {
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, deptno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				dept=new Department();
				dept.setdName(rs.getString("Dname"));
				dept.setCity(rs.getString("City"));
				dept.setLoc(rs.getString("Loc"));
				dept.setHead(rs.getString("Head"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
	public String addDepartment(Department dept) {
		connection=DaoConnection.getConnection();
		String cmd=" insert into Department(deptno,dname,loc,city,head) "
				+" values(?,?,?,?,?) ";
		String result="";
		try {
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, dept.getDeptNo());
			pst.setString(2, dept.getdName());
			pst.setString(3, dept.getLoc());
			pst.setString(4, dept.getCity());
			pst.setString(5, dept.getHead());
			pst.executeUpdate();
			result="Department Record Added...";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=e.getMessage();
		}
		return result;
	}
	public int generateDepartment() {
		connection=DaoConnection.getConnection();
		String cmd=" select case when max(deptno) is NULL THEN 1 "
					+ " ELSE Max(deptno)+1 END deptno From department ";
		int deptno=0;
		try {
			pst=connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			rs.next();
			deptno=rs.getInt("deptno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptno;
	}
	public List<Department> showDepartment() {

		connection=DaoConnection.getConnection();

		String cmd="Select * from Department";
		Department dept=null;

		List<Department> deptList=new ArrayList<>();
		try {
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {

		dept=new Department();
		dept.setDeptNo(rs.getInt("deptno"));
		dept.setdName(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
		dept.setCity(rs.getString("city"));
		dept.setHead(rs.getString("head"));
		deptList.add(dept);

		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return deptList;

		}
}

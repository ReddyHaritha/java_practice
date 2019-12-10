<%@page import="com.hcl.jsp.DaoConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Connection con=DaoConnection.getConnection();
    String cmd="select max(empno)+1 empno from Employ";
    PreparedStatement pst=con.prepareStatement(cmd);
    ResultSet rs=pst.executeQuery();
    rs.next();
    int empno=rs.getInt("empno");
%>
<form method="get" action="AddEmploy.jsp">
		<center>
			Employ No : 
		<input type="text" value="<%=empno%>"
		 readonly="readonly" name="empno" /> <br/><br/> 
			Employ Name : 
		<input type="text" name="name" /> <br/><br/> 
			Department : 
		<input type="text" name="dept" /> <br/><br/>
			Designation : 
		<input type="text" name="desig" /> <br/><br/> 
			Basic : 
		<input type="text" name="basic" /> <br/><br/> 
		<input type="submit" value="Insert" />
		</center>
	</form>
<%
	if(request.getParameter("empno") !=null && 	request.getParameter("basic") !=null) {
		cmd="insert into Employ values(?,?,?,?,?)";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(request.getParameter("empno")));
		pst.setString(2, request.getParameter("name"));
		pst.setString(3, request.getParameter("dept"));
		pst.setString(4, request.getParameter("desig"));
		pst.setInt(5, Integer.parseInt(request.getParameter("basic")));
		pst.executeUpdate();
%>
<jsp:forward page="EmployShow.jsp" />
<%
	}
	%>
</body>
</html>
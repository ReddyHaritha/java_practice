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
		int empno=Integer.parseInt(request.getParameter("empno"));
		String cmd="delete from Employ where Empno=?";
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1, empno);
		pst.executeUpdate();
	%>
	<jsp:forward page="EmployShow.jsp" />
</body>
</html>
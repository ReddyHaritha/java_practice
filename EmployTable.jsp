<%@page import="com.hcl.jsp.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3">
<tr>
	<th>Empno</th>
	<th>Name</th>
	<th>Dept</th>
	<th>Desig</th>
	<th>Salary</th>
	<th>Update</th>
	<th>Delete</th>
</tr>
<%
Connection con=DaoConnection.getConnection();
	String cmd="select * from employ";
	PreparedStatement pst=con.prepareStatement(cmd);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		%>
	<tr>
	<td> <%=rs.getInt("empno")%> </td>
	<td> <%=rs.getString("name")%> </td>
	<td> <%=rs.getString("dept")%> </td>
	<td> <%=rs.getString("desig")%> </td>
	<td> <%=rs.getInt("basic")%> </td>
	<td> <a href="UpdateEmploy.jsp?empno=<%=rs.getInt("empno")%>">Update</a>
	<td> <a href="DeleteEmploy.jsp?empno=<%=rs.getInt("empno")%>">Delete</a>
	</tr>
	<%
	}
	%>
	
</table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="AddEmploy.jsp">Add Employ</a>
</body>
</html>
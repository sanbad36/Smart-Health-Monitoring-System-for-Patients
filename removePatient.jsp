<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.icu.*"%>

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
Statement statement = null;
ResultSet resultSet = null;
%>

<%
try{
Connection conn=DBconnect.getConnect();
statement=conn.createStatement();
String id1=request.getParameter("id");
java.sql.PreparedStatement ps=conn.prepareStatement("delete from patient where kit=?");
ps.setString(1,id1);
java.sql.PreparedStatement ps1=conn.prepareStatement("delete from  paitientrecord where kit=?");
ps1.setString(1,id1);
int i=ps.executeUpdate();
int j=ps1.executeUpdate();
if(i==1)
{
	response.sendRedirect("welcomeSupervisor.jsp");
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
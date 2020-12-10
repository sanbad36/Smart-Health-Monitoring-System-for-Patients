<%@page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.icu.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		Blob image = null;

		Connection cn = null;

		byte[] imgData = null;

		Statement st = null;

		ResultSet rs = null;

		try {

			cn = DBconnect.getConnect();

			st = cn.createStatement();

			String id1 = request.getParameter("id");
			rs = st.executeQuery("select photo from supervisor where id = '" + id1 + "'");

			if (rs.next()) {

				image = rs.getBlob(1);

				imgData = image.getBytes(1, (int) image.length());
				

			} else {

				out.println("Display Blob Example");

				out.println("image not found for given id");

				return;

			}

			response.setContentType("image/jpg");

			OutputStream os = response.getOutputStream();

			os.write(imgData);

			os.flush();

			os.close();

		} catch (Exception e) {

			out.println("Unable To Display image");

			out.println("Image Display Error=" + e.getMessage());

			return;

		} finally {

			try {

				rs.close();

				st.close();

				

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}
	%>





</body>
</html>
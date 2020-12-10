package com.servlet;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icu.DBconnect;

/**
 * Servlet implementation class SupervisorAdd
 */
@WebServlet("/SupervisorAdd")
@MultipartConfig(maxFileSize = 16177215)
public class SupervisorAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		{
			String supervisorname = request.getParameter("nameTxt");

			String email = request.getParameter("emailTxt");

			String contact = request.getParameter("ContactTxt");

			String password = request.getParameter("passwordTxt");

			String qualification = request.getParameter("qualificationTxt");

			String shift = request.getParameter("shiftTxt");
			

			String gender = request.getParameter("genderTxt");

			InputStream inputStream = null; // input stream of the upload file

			// obtains the upload file part in this multipart request
			Part filePart = request.getPart("photo");
			if (filePart != null) {
				// prints out some information for debugging
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
			}

			Connection conn = null; // connection to the database
			String message = null; // message will be sent back to client

			try {
				// connects to the database

				conn = DBconnect.getConnect();
				// constructs SQL statement
				String sql = "INSERT INTO supervisor (supervisorname, email,contact, password, qualification, shift, gender, photo) values (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, supervisorname);
				statement.setString(2, email);
				statement.setString(3, contact);
				statement.setString(4, password);
				statement.setString(5, qualification);
				statement.setString(6, shift);
				statement.setString(7, gender);
				if (inputStream != null) {
					// fetches input stream of the upload file for the blob column
					statement.setBlob(8, inputStream);
				}

				// sends the statement to the database server
				int n = statement.executeUpdate();
				System.out.println("Recort inserted");
				if (n >= 1) {
					request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
					response.sendRedirect("welcomeAdmin.jsp");
				} else {
					request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
					response.sendRedirect("addSupervisor.jsp");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

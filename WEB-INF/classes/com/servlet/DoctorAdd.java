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
 * Servlet implementation class DoctorAdd
 */
@WebServlet("/DoctorAdd")
@MultipartConfig(maxFileSize = 16177215)
public class DoctorAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorAdd() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
			String doctor = request.getParameter("nameTxt");

			String email = request.getParameter("emailTxt");

			String contact = request.getParameter("ContactTxt");

			String password = request.getParameter("passwordTxt");

			String specialization = request.getParameter("specializationTxt");

			String visitdate = request.getParameter("visitdateTxt");
			
			String hospitalname = request.getParameter("hospitalTxt");
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
			
			try {
				// connects to the database

				conn = DBconnect.getConnect();
				// constructs SQL statement
				String sql = "INSERT INTO doctor (	name, email,contact, password, specialization, visitdate, hospitalname, gender, photo) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, doctor);
				statement.setString(2, email);
				statement.setString(3, contact);
				statement.setString(4, password);
				statement.setString(5, specialization);
				statement.setString(6, visitdate);
				statement.setString(7, hospitalname);
				statement.setString(8, gender);
				if (inputStream != null) {
					// fetches input stream of the upload file for the blob column
					statement.setBlob(9, inputStream);
				}

				// sends the statement to the database server
				int n = statement.executeUpdate();
				System.out.println(n+"Recort inserted");
				//response.sendRedirect("welcomeAdmin.jsp");
				
				
				if (n == 1) {
				     System.out.println("if loop");
					//request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
					response.sendRedirect("welcomeAdmin.jsp");
				} else {
					System.out.println("el;sre");
					request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
					response.sendRedirect("addDoctor.jsp");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}



package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icu.DBconnect;
import com.icu.Id;

/**
 * Servlet implementation class PatientsEdit
 */
@WebServlet("/PatientsEdit")
public class PatientsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientsEdit() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String id=Id.getId();
		String name = request.getParameter("nameTxt");

		String email = request.getParameter("emailTxt");

		String contact = request.getParameter("ContactTxt");

		String password = request.getParameter("passwordTxt");

		String address = request.getParameter("addressTxt");

		String disease = request.getParameter("diseaseTxt");
		
		String kit = request.getParameter("kitTxt");
		String gender = request.getParameter("genderTxt");
		String doctor = request.getParameter("doctorTxt");
		String status = request.getParameter("statusTxt");
		// obtains the upload file part in this multipart request
		
		Connection conn = null; // connection to the database
		
		try {
			// connects to the database

			conn = DBconnect.getConnect();
			// constructs SQL statement
			String sql = "Update patient set name=? , icuward=? ,contact=? ,bedno=? ,address=? ,disease=? ,kit=? ,gender=? ,doctor=? ,status=? where id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, contact);
			statement.setString(4, password);
			statement.setString(5, address);
			statement.setString(6, disease);
			statement.setString(7, kit);
			statement.setString(8, gender);
			statement.setString(9, doctor);
			statement.setString(10, status);
			statement.setString(11, id);

			// sends the statement to the database server
			int n = statement.executeUpdate();
			System.out.println(n+"Recort inserted");
			//response.sendRedirect("welcomeAdmin.jsp");
			
			
			if (n == 1) {
				response.sendRedirect("Patient.jsp");
			} else {
				System.out.println("el;sre");
				request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
				response.sendRedirect("addPatient.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



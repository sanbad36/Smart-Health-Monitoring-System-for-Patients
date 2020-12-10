package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icu.CreateDirectory;
import com.icu.DBconnect;

/**
 * Servlet implementation class PatientsAdd
 */
@WebServlet("/PatientsAdd")
@MultipartConfig(maxFileSize = 16177215)
public class PatientsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientsAdd() {
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
		int id=0;
		String name = request.getParameter("nameTxt");

		String email = request.getParameter("emailTxt");

		String contact = request.getParameter("ContactTxt");

		String password = request.getParameter("passwordTxt");

		String address = request.getParameter("addressTxt");

		String disease = request.getParameter("diseaseTxt");
		
		String kit = request.getParameter("kitTxt");
		String gender = request.getParameter("genderTxt");
		String doctor = request.getParameter("doctorTxt");
		
		     
		
		String blood = request.getParameter("bloodTxt");

		String occupation = request.getParameter("Occupation");

		String adhar = request.getParameter("adharTxt");
		
		String rname = request.getParameter("rnameTxt");
		String rcontact = request.getParameter("rContactTxt");
		String rgender = request.getParameter("rgenderTxt");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   String admitdate = dtf.format(now) ;
		
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
			String sql = "insert into patient values (?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, email);
			statement.setString(4, contact);
			statement.setString(5, password);
			statement.setString(6, address);
			statement.setString(7, disease);
			statement.setString(8, kit);
			statement.setString(9, gender);
			statement.setString(10, doctor);
			if (inputStream != null) {
				// fetches input stream of the upload file for the blob column
				statement.setBlob(11, inputStream);
			}
//sensor
			statement.setString(12, "0");
			statement.setString(13, "0");
			statement.setString(14, "0");
			statement.setString(15, "0");
			statement.setString(16, "0");
			
			
			statement.setString(17, blood);
			statement.setString(18, occupation);
			statement.setString(19, adhar);
			statement.setString(20, rname);
			statement.setString(21, rcontact);
			statement.setString(22, rgender);
			
			statement.setString(23, "Admit");
			statement.setString(24, admitdate);
			statement.execute();
			// sends the statement to the database server
			ResultSet rsss = statement.getGeneratedKeys();
			int generatedKey = 0;
			System.out.println("Recort inserted");
			//response.sendRedirect("welcomeAdmin.jsp");
			
			
			if (rsss.next()) {
				System.out.println("111111111");
				generatedKey = rsss.getInt(1);
				CreateDirectory.createdirectory(Integer.toString(generatedKey));
				request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
				response.sendRedirect("viewPatient.jsp");
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



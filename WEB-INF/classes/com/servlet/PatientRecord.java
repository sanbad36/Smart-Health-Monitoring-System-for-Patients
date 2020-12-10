package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icu.DBconnect;
import com.icu.Id;

/**
 * Servlet implementation class PatientRecord
 */
@WebServlet("/PatientRecord")
public class PatientRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRecord() {
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
		// TODO Auto-generated method stub
				doGet(request, response);
				PrintWriter out = response.getWriter();
				{
					int id = 0;

					String kit = request.getParameter("kitTxt");

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
					   LocalDateTime now = LocalDateTime.now();  
					   System.out.println(dtf.format(now));  
					   
					   
//					
//					Date today = Calendar.getInstance().getTime();
//					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
					String visitdate = dtf.format(now) ;
					System.out.println();
					String prescription = request.getParameter("prescriptionTxt");
					
					String nextvisit = request.getParameter("nextvisitTxt");

					String decription = request.getParameter("decriptionTxt");
					

					Connection conn = null; // connection to the database
					String message = null; // message will be sent back to client

					try {
						
						conn = DBconnect.getConnect();
						
						String sql = "INSERT INTO paitientrecord values (?, ?, ?, ?, ?, ?)";
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setInt(1, id);
						statement.setString(2, kit);
						statement.setString(3, visitdate);
						statement.setString(4, prescription);
						statement.setString(5, nextvisit);
						statement.setString(6, decription);
						

						// sends the statement to the database server
						int n = statement.executeUpdate();
						System.out.println("Recort inserted");
						if (n >= 1) {
							Id.setKit(kit);
							request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
							response.sendRedirect("viewPatienthistroy.jsp");
						} else {
							request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
							response.sendRedirect("welcomeDoctor.jsp");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}

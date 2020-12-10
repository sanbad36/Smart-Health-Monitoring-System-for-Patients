package com.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icu.CreateDirectory;
import com.icu.DBconnect;


/**
 * Servlet implementation class SupervisorLogin
 */
@WebServlet("/SupervisorLogin")
public class SupervisorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorLogin() {
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
    doGet(request, response);
		
    File file = new File("D:/file");
    file.mkdir();
    
    
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		try
			{
				Connection conn=DBconnect.getConnect();
				PreparedStatement ps = conn.prepareStatement("select * from   supervisor where email=? and password=?");
				ps.setString(1, email);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					PreparedStatement ps1 = conn.prepareStatement("select * from   patient ");
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()) {
						CreateDirectory.createdirectory(rs1.getString(1));
						
					}
					request.getSession().setAttribute("msg", "Wrong User Credentials..!!");
					response.sendRedirect("welcomeSupervisor.jsp");
				}
				else
				{
					request.getSession().setAttribute("msg", "Wrong User Credentials..!!");
					response.sendRedirect("index.jsp");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

}

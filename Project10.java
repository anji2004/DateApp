package com.ihub.www;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Project10 extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String n1=req.getParameter("firstName");
		String n2=req.getParameter("lastName");
		String n3=req.getParameter("email");
		String n44=req.getParameter("phone");
		String n5=req.getParameter("subject");
		int n4=Integer.parseInt(n44);
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			String q="insert into student1 values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,n1);
			ps.setString(2,n2);
			ps.setString(3,n3);
			ps.setInt(4,n4);
			ps.setString(5,n5);
			int result=ps.executeUpdate();
			if(result==0)
			{
				pw.println("<h1 style='color:red;'>No Rows inserted<h1>");
			}
			
			else
			{
				pw.println("<h1  style='color:green;'>Data was submitted<h1>");

			}

            con.close();
            ps.close();
            
            
		}  
            catch(Exception e)
            {
            	pw.println(e);
            }

        pw.close();
		}
		

	}




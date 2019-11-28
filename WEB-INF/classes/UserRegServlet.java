import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UserRegServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		Connection con=null;
		Statement st1=null;
		Statement st2=null;
		Statement st3=null;
		ResultSet rs=null;
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
        	String name=req.getParameter("name");
			String mob=req.getParameter("mob");
			String email=req.getParameter("email");
			String pwd=req.getParameter("pwd");
			String city=req.getParameter("city");
        try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eatout","root","");
		}
		catch(ClassNotFoundException e1)
		{
			pw.println(e1);
		}
		catch(SQLException e2)
		{
			pw.println(e2);
		}
		
		try
		{
			st1=con.createStatement();
			st2=con.createStatement();
			st1.executeUpdate("insert into user_login values('"+mob+"','"+pwd+"','user')");
			st2.executeUpdate("insert into user_profile values('"+name+"','"+mob+"','"+email+"','"+city+"')");
		
			
			String s="<html><head><title>EatOut</title>"+
"<link type='text/css' rel='stylesheet' href='proj1.css'>"+
"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>"+
"<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>"+
"<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1' crossorigin='anonymous'></script>"+
"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>"+
"</head>"+
"<body class='foo'>"+
"<aside class='container'>"+
"<nav class='navbar navbar-expand-xl navbar-dark bg-secondary'>"+
"<a class='navbar-brand c'><img src='logo.png' width='50' height='50'>Your Food,Your Place</a>"+
"<button type='button' class='navbar-toggler' data-toggle='collapse' data-target='#N1'>"+
"<span class='navbar-toggler-icon'></span></button>"+
"<div class='collapse navbar-collapse justify-content-end' id='N1'>"+
"<ul class='navbar-nav'>"+
"<li class='nav-item'><a href='index.html' class='nav-link'>Home</a></li>"+
"<li class='nav-item'><a href='logout.html' class='nav-link'>Log out</a></li>"+
"<li class='nav-item'><a href='about.html' class='nav-link'>about us</a></li>"+
"</ul></div></nav></aside>"+
"<div class='li'>Welcome,"+ name+"</div>";
pw.println(s);
pw.println("<form class='book' action='BookingServlet' method='post'>");
pw.println("<div class='lin'>Book your place</div>");
pw.println("<select >");
pw.println("<option selected>city</option>");
pw.println("<option value='kota'>kota</option>");
pw.println("<option value='udaipur'>udaipur</option>");
pw.println("<option value='jaipur'>jaipur</option>");
pw.println("</select><input type='submit' value='next'></form></body></html>");
		
		con.close();
		}
		catch(SQLException e3)
		{
			pw.println(e3);
		}
		catch(Exception e4)
		{
			pw.println(e4);
		}
    }
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		doGet(req,res);
	}
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RestroRegServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		Connection con=null;
		Statement st1=null;
		Statement st2=null;
		ResultSet rs=null;
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
        	String rname=req.getParameter("rname");
			String rstd=req.getParameter("rstd");
			String rphone=req.getParameter("rphone");
			String rcity=req.getParameter("rcity");
			String remail=req.getParameter("remail");
			String radd=req.getParameter("radd");
			String rot=req.getParameter("rot");
			String rct=req.getParameter("rct");
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
			rs=st1.executeQuery("select * from restro_city where city='"+rcity+"'");
			if(!rs.next())
			{
				st1.executeUpdate("insert into restro_city values('"+rcity+"')");
			}
			st2.executeUpdate("insert into restro_profile values('"+rname+"','"+rstd+"','"+rphone+"','"+rcity+"','"+remail+"','"+radd+"','"+rot+"','"+rct+"')");
			con.close();
			String s1="<html>"+
"<head>"+
"<link rel='icon' href='logo.png' sizes='16x16' type='image/png'>"+
"<title>EatOut</title>"+
"<link type='text/css' rel='stylesheet' href='grid.css'>"+
"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>"+
"<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>"+
"<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1' crossorigin='anonymous'></script>"+
"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>"+
"</head>"+
"<body>"+
"<aside class='container'>"+
"<nav class='navbar navbar-expand-xl navbar-dark bg-secondary'>"+
"<a class='navbar-brand c'><img src='logo.png' width='50' height='50'>Your Food,Your Place</a>"+
"<button type='button' class='navbar-toggler' data-toggle='collapse' data-target='#N1'>"+
"<span class='navbar-toggler-icon'></span></button>"+
"<div class='collapse navbar-collapse justify-content-end' id='N1'>"+
"<ul class='navbar-nav'>"+
"<li class='nav-item'><a href='index.html' class='nav-link'>Home</a></li>"+
"<li class='nav-item'><a href='restaurant.html' class='nav-link'>Restaurants</a></li>"+
"<li class='nav-item'><a href='foodies.html' class='nav-link'>Foodies</a></li>"+
"<li class='nav-item'><a href='about.html' class='nav-link'>about us</a></li>"+
"</ul></div></nav></aside>"+
"<div class='rwc'>"+
"<div>Welcome, "+rname+"</div>"+
"<div><img src='collab.jpg' width='150' height='150'></div>"+
"<div>Your registration is confirmed with EatOut </div>"+
"<a type='button' class='btn-info btn-outline-danger' href='index.html'>Return to Home</a>"+
"</div></body></html>";
              pw.println(s1);

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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		Connection con=null;
		Statement st1=null;
		ResultSet rs=null;
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
        	String mob=req.getParameter("mob");
			String pwd=req.getParameter("pwd");
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
			rs=st1.executeQuery("select * from user_login where mobile='"+mob+"' and password='"+pwd+"'");
			if(rs.next())
			{
				pw.println(" welcome "+mob);
				HttpSession session = req.getSession();
				session.setAttribute("mobile",mob);
				pw.println("<a href='about.html'>click here to see profile</a>");
			}	
			else
				pw.println(" wrong password ");
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
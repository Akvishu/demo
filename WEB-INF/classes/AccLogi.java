import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class AccLogi extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String email = req.getParameter("email");
			String password = req.getParameter("password");

				out.print("<html><body>");
			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_manag","root","vishal");
				Statement st = c.createStatement();
				ResultSet rs=st.executeQuery("select * from accountant_info where email='"+email+"' and password='"+password+"'");
				if(rs.next()){
					res.sendRedirect("accountantpanel.html");
				  
			    }else
			        {
					out.print("<h1>Wrong Entries</h1><br>");
					out.print("<a href='index.html'>Click here</a>");

					out.close();				
				    }
					out.print("</body></html>");
				}catch(Exception e){
					out.print(e);
		}
	}
}


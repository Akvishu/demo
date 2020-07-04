import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class FeeUpdate extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String id = req.getParameter("id");
			String paid = req.getParameter("paid");
			String due = req.getParameter("due");

			out.print("<html><body>");
			out.print("<center><h1>Hellow Sir....</h1>");
			Class.forName("com.mysql.jdbc.Driver");
		   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_manag","root","vishal");
		   Statement st=c.createStatement();
		   st.executeUpdate( "update std_info set paid="+paid+",due="+due+" where id ="+id+" ");
       
	          
	           	 out.print("---Updated---<br> Ivalid Etries");
	           	 out.print("<a href='index.html'>Log Out</a></center>");
				
				
            
              
               
			out.print("</body></html>");
			out.close();
		}catch(Exception e){
			 out.print("---Not Updated---<br> Ivalid Etries");
			 out.print(e);
	           	 out.print("<a href='index.html'>Log Out</a></center>");
			
		}
	}
}

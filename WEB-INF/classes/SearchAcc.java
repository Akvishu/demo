import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class SearchAcc extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String name = req.getParameter("name");
			out.print("<html><body>");
			out.print("<center><h1>Hellow Sir....</h1>");
			Class.forName("com.mysql.jdbc.Driver");
		   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_manag","root","vishal");
		   Statement st=c.createStatement();
		   ResultSet rs=st.executeQuery( "select * from accountant_info where name like '%"+name+"%' ");
           int f=0;
	           while(rs.next()) 
	           {
	           		f=1 ;
	  				out.print("<center>"+"Name : <b>"+rs.getString("name")+"</b><br>");
	  				out.print("E-mail : <b>"+rs.getString("email")+"</b><br>");
	  				out.print("gender : <b>"+rs.getString("gender")+"</b><br>");
	  				
	  				out.print("DOB : <b>"+rs.getString("dob")+"</b><br>");

	  				out.print("Address : <b>"+rs.getString("address")+"</b><br>");
	  				out.print("phone : <b>"+rs.getString("phone")+"</b><br><hr></center></center>");
				}
				
				out.print("<a href='index.html'>Log Out</a>");
            if(f==0)
              {
               out.print("---Invalid Name OR Accountant not founnd---<br> Ivalid Etries");
               }
			out.print("</body></html>");
			out.close();
		}catch(Exception e){
			out.print(e);
		}
	}
}

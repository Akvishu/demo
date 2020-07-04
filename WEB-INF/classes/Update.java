import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class Update extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String id = req.getParameter("name");
			out.print("<html><body>");
			out.print("<center><h1>Hellow Sir....</h1>");
			Class.forName("com.mysql.jdbc.Driver");
		   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_manag","root","vishal");
		   Statement st=c.createStatement();
		   ResultSet rs=st.executeQuery( "select * from std_info where id like '%"+id+"%' ");
           int f=0;
	           if(rs.next()) 
	           {
	           		f=1 ;
	  				out.print("<center>"+"I'D : <b>"+rs.getString("id")+"</b><br>");
	  				out.print("Name : <b>"+rs.getString("name")+"</b><br>");
	  				out.print("Course : <b>"+rs.getString("course")+"</b><br>");
	  				out.print("Fee : <b>"+rs.getString("fee")+"</b><br>");
	  				out.print("paid : <b>"+rs.getString("paid")+"</b><br>");
	  				out.print("due : <b>"+rs.getString("due")+"</br><br><hr></center>");
						
						out.print("<form action='Updfee' method='post'>");
	  					out.print("<hr><h3>Update Fee Detail</h3></br><br>");
						out.print("Enter STD ID : <input type='text' name='id'></br><br>");
						out.print("Enter final paid : <input type='text' name='paid'></br><br>");
						out.print("Remamber Dues: <input type='text' name='due'><br>");
						out.print("<input type='submit' value='Update'/></form><hr>");


				out.print("<a href='index.html'>Log Out</a></center>");}
            else
              {
               out.print("---Studet not founnd---<br> Ivalid Etries");
               }
			out.print("</body></html>");
			out.close();
		}catch(Exception e){
			out.print(e);
		}
	}
}

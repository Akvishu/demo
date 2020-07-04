import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class AddStd extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();

			int id = Integer.parseInt (req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");


			String course = req.getParameter("course");


			int fee = Integer.parseInt (req.getParameter("fee"));
			int paid = Integer.parseInt (req.getParameter("paid"));
			int due = Integer.parseInt (req.getParameter("due"));


			String address = req.getParameter("address");
			String phone = req.getParameter("phone");


			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_manag","root","vishal");
				Statement st = c.createStatement();
				st.executeUpdate( "insert into std_info values ("+id+",'"+name+"','"+email+"','"+gender+"','"+course+"',"+fee+","+paid+","+due+",'"+address+"','"+phone+"')");
				out.print("<html><body>");
				out.print("<h1> Added Successfully </h1>");
				out.print("<a href='index.html'>Click Here</a>");
				out.print("</body></html>");
				out.close();
		}catch(SQLIntegrityConstraintViolationException ex)
			{
			res.sendRedirect("alreadyexist.html");
				out.print("<a href='ex2.java'>Click Here</a>");
			}
		catch(Exception e){
			out.print(e);
		}
	}
}

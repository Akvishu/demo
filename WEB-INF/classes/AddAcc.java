import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class AddAcc extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			String dob = req.getParameter("dob");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");


			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_manag","root","vishal");
				Statement st = c.createStatement();
				st.executeUpdate( "insert into accountant_info values ('"+name+"','"+email+"','"+gender+"','"+dob+"','"+address+"','"+phone+"','"+password+"')");
				out.print("<html><body>");
				out.print("<h1> Added Successfully </h1>");

				out.print("<a href='index.html'>Click here</a>");
				
				out.print("</body></html>");
				out.close();
		}catch(SQLIntegrityConstraintViolationException ex)
			{
				out.print("already-exist");
				out.print("<a href='index.html'>Click here</a>");
			}
		catch(Exception e){
			out.print(e);
		}
	}
}

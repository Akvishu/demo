import javax.servlet.*;
import java.io.* ;
public class ex extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			out.print("<html><body>");
			out.print("<form action='aaaddd' method='post'>");
			out.print("<h1><center><h3 style='color: blue'><u> Add Accountant </h3></u><hr>");
			
			out.print("Name :  <input type='text' name='name' ><br>");
			out.print("E-Male :  <input type='email' name='email' ><br>");
			out.print("Gender :<input type='text' name='gender' ><br>");
			out.print("D.O.B. :<input type='text' name='dob' ><br>");
			out.print("Address :<input type='text' name='address' ><br>");
			out.print("Contact no :<input type='text' name='phone' ><br>");
			out.print("Password :<input type='password' name='password' ><br><br>");
			out.print("<input type='submit' value='Add Accountant'/><br>");
			out.print("</center></form>");
			out.print("</body></html>");
		}catch(Exception e){
		out.print(e);
	}
	}
}

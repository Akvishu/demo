import javax.servlet.*;
import java.io.* ;
public class ex2 extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			out.print("<html><body>");
			out.print("<form action='adstd' method='post'>");
			out.print("<h1><center><h3 style='color: blue'><u> Add Student </h3></u><hr>");
			
			out.print("I'D :  <input type='text' name='id' ><br>");
			out.print("Name :  <input type='text' name='name' ><br>");
			out.print("E-Male :  <input type='email' name='email' ><br>");
			out.print("Gender :<input type='text' name='gender' ><br>");

			out.print("Course :  <input type='text' name='course' ><br>");
			out.print("Fee :  <input type='text' name='fee' ><br>");
			out.print("Paid :  <input type='text' name='paid' ><br>");

			out.print("Due :  <input type='text' name='due' ><br>");

			out.print("Address :<input type='text' name='address' ><br>");
			out.print("Contact no :<input type='text' name='phone' ><br><hr>");
			out.print("<input type='submit' value='Add Studet'/><br>");
			out.print("</center></form>");
			out.print("</body></html>");
		}catch(Exception e){
		out.print(e);
	}
	}
}

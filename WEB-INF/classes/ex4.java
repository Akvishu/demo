import javax.servlet.*;
import java.io.* ;
public class ex4 extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			out.print("<html><body>");
			out.print("<form action='SearchAcc' method='post'>");
			out.print("<h1><center><h3 style='color: blue'><u> ***Search Accountant*** </h3></u><hr>");
			
			out.print("Accountant-Name :  <input type='text' name='name' ><br>");

			out.print("<input type='submit' value='Search'/><br>");
			out.print("</center></form>");
			out.print("</body></html>");
		}catch(Exception e){
		out.print(e);
	}
	}
}

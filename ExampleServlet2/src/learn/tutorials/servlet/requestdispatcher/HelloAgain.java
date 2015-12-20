package learn.tutorials.servlet.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAgain
 */
public class HelloAgain extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getServletContext().toString());
		ServletConfig config = getServletConfig();
		String query = config.getInitParameter("query");
		response.setContentType("text/html");
		response.sendRedirect("http://www.google.com/#q=" + query);//+ request.getParameter("username"));
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>");
//		out.print("<br>Login Failed</br>");
//		out.print("</html></body>");
//		out.close();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
	}

}

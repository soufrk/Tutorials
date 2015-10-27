package learn.tutorials.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if (userName.equals("Saurabh") && password.equals("Nimda1234")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet2");
			dispatcher.forward(request, response);
		} else {
//			out.print("Sorry username/password didn't match, kindly try again");
			// Without crossAuth="true" in context.xml, Tomcat 7 would return null.
			System.out.println(getServletContext().toString());
			ServletContext extContext = request.getServletContext().getContext("/ExampleServlet2");
			RequestDispatcher dispatcher = extContext.getRequestDispatcher("/Servlet3");
			dispatcher.forward(request, response);
		}
		out.close();
	}
}

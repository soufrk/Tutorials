package learn.tutorials.servlet.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHttpSession extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/html");
		try (PrintWriter out = res.getWriter()){
			req.getRequestDispatcher("link.html").include(req, res);
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			if (password.equals("admin123")) {
				out.print("You are successfully logged in!");
				out.print("<br>Welcome, " + name);
				HttpSession session = req.getSession();
				session.setAttribute("name", name);
//				Cookie ck = new Cookie("name", name);
//				res.addCookie(ck);
			} else {
				out.print("Sorry wrong username/password");
				req.getRequestDispatcher("login.html").include(req, res);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}

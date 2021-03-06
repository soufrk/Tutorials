package learn.tutorials.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
		try (PrintWriter out = resp.getWriter()) {
			req.getRequestDispatcher("link.html").include(req, resp);
			Cookie ck[] = req.getCookies();
			String name = "";
			if (ck != null) {
				name = ck[0].getValue();
				if (!name.equals("") || name != null) {
					out.print("<br>Welcome To Profile</br>");
					out.print("<br>Welcome " + name + "</br>");

				}
			} else {
				out.print("Please Login First");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}
}

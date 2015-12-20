package learn.tutorials.servlet.httpsession;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
public class LogoutHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			request.getRequestDispatcher("link.html").include(request, response);
			request.getSession().invalidate();
			/*Cookie ck = new Cookie("name", "");
			ck.setMaxAge(0);
			response.addCookie(ck);*/
			out.print("You have logged out successfully");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}

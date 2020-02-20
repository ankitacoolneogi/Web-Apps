package ibm.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

			out.print("<HTML>");
			out.print("<HEAD><TITLE>Login page</TITLE></HEAD>");
			out.print("<BODY>");
			out.print("<form action=\"index.html\" method=\"get\" >");
			out.print("<br><center><input type='submit' value='LOGOUT' name='logout'>");
			out.print("<center><h2> The username : " + request.getParameter("userName"));
			out.print("<br>D-O-B: " + request.getParameter("date"));
			out.print("<br>Gender: " + request.getParameter("gen"));
			out.print("<br>Enrolled in: " + request.getParameter("admission"));
			out.print("<br>Specialized in: ");

			for (String str : request.getParameterValues("c1")) {
				out.print(str + " ");
			}
			
			out.print("<br><img src='" + request.getContextPath() + "/images/image.jpg' />");
			
			
			if(request.getParameter("logout") != null) {
				response.getWriter().print("<h3><center> <p style='color:red'>Successfully Logged out...</p></center></h3>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);
				session.invalidate();
			}
			
			out.print("</BODY>");
			out.print("</HTML>");
			
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userName")!=null) {
			doPost(request,response);
//		dispatcher.include(request, response);
	}
	}
}

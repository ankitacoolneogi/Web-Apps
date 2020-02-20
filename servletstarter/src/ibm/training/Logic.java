package ibm.training;

import java.io.IOException;
import ibm.training.DBConnect;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/logic")
public class Logic extends HttpServlet {

	public static final String NAMEPATTERN = "[A-Za-z]{6}";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

		HttpSession session = request.getSession();
		// Set the content type
		response.setContentType("text/html");
		ResultSet rs = null;
		// Get the value from form
		PrintWriter out = response.getWriter();
		boolean search = false;
		// Validate the user
		if (request.getParameter("userName").trim().matches(NAMEPATTERN)) {
			if (request.getParameter("registeration") == null) {

//				RequestDispatcher regis = request.getRequestDispatcher("db");
//				regis.include(request, response);
				DBConnect db_obj = new DBConnect();
				String qry_name = "select * from registeration where userName = ? ";

				try {

					db_obj.pstmt = db_obj.dbCon.prepareStatement(qry_name);
					db_obj.pstmt.setString(1, request.getParameter("userName"));
					rs = db_obj.pstmt.executeQuery();

					while (rs.next())
						if (rs.getString("userName").equals(request.getParameter("userName").trim()))
							if (rs.getString("password").equals(request.getParameter("u_password").trim()))
								search = true;

				} catch (SQLException e) {
					System.out.println("Error with searching: " + e.getMessage());
				}

				if (search == false) {

					out.print("<h3><center> <p style='color:green'>PLEASE REGISTER BEFORE LOGIN...</p></center></h3>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
					dispatcher.include(request, response);
				}
				if (search == true) {
					search = false;

					session.setAttribute("userName", request.getParameter("userName"));

//					request.setParameter("userName");
					out.print("<h3><center><p style='color:purple'>Successfully Logged in...</p></center>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login");
					dispatcher.include(request, response);

				}

			} else {
//				out.println("Name: " + request.getParameter("userName"));
//				out.println("Pass: " + request.getParameter("u_password"));
//				out.println("Admission: " + request.getParameter("admission"));
//				out.println("Date: " + request.getParameter("date"));
				if (request.getParameter("userName") == null || request.getParameter("u_password") == null
						|| request.getParameter("admission") == null || request.getParameter("date") == null
						|| request.getParameter("userName") == "" || request.getParameter("u_password") == ""
						|| request.getParameter("admission") == "" || request.getParameter("date") == "") {

					out.print("<h3><center> <p style='color:blue'>PLEASE ENTER VALID CREDENTIALS...</p></center></h3>");
					RequestDispatcher dis = request.getRequestDispatcher("index.html");
					dis.include(request, response);

				} else {
					// System.out.println("Insertion in progress...");
					RequestDispatcher regis = request.getRequestDispatcher("db");
					regis.include(request, response);
					// response.getWriter().print("Welcome " + user) ;
					out.print("<h3><center><p style='color:pink'>Successfully registered...</p></center>");

					session.setAttribute("userName", request.getParameter("userName"));
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("login");
					dispatcher.include(request, response);
				}

			} // dispatcher.include(request, response);
		}

		else {
			response.getWriter().print("<h3><center> <p style='color:red'>Invalid username...</p></center></h3>");

//			response.sendRedirect("index.html");
//			response.sendRedirect("invalid");
//			Use a RequestDispatcher to forward the same request, response
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			// Dispatch the request further
//			dispatcher.forward(request, response);
			dispatcher.include(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().print("Post requests now supported...");

		//doPost(request, response);
	}

}

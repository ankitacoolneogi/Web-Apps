package ibm.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/db")
public class DBConnect extends HttpServlet {

	Connection dbCon;
	PreparedStatement pstmt;

	public DBConnect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydatabase?serverTimezone=UTC", "root",
					"");
		} catch (SQLException e) {
			System.out.print("Error Connecting not found" + e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.print("Error class not found" + e.getMessage());

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {

//			response.getWriter().append("Connected to DB...");

			String insertion = "Insert into registeration values(?,?,?,?)";

			pstmt = dbCon.prepareStatement(insertion);

			pstmt.setString(1, request.getParameter("userName"));
			pstmt.setString(2, request.getParameter("u_password"));
			pstmt.setString(3, request.getParameter("admission"));
			pstmt.setString(4, request.getParameter("date"));

			if (pstmt.executeUpdate() != 0)
				return;

		} catch (SQLException e) {
			out.print("Can't connect" + e.getMessage());
		}

	}
}

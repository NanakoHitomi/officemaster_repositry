package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/officelist")
public class OfficeListServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "社員データ");
			
		}
		
		HttpSession session = request.getSession();
        Integer  userid = (Integer) session.getAttribute("id");
		
		String url = "jdbc:mysql://localhost/officemaster";
		String user = "root";
		String password = "";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		String sql = "SELECT * FROM users";
		String sql = "SELECT *  FROM users WHERE userid =?";
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userid);
				
		ResultSet results = statement.executeQuery() ;
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			
			while (results.next()) {
				HashMap<String, String> columns = new HashMap<String, String>();
				
				String id = results.getString("id");
				columns.put("id", id);
				
				String username = results.getString("username");
				columns.put("username", username);
				
				String email = results.getString("email");
				columns.put("email", email);
				
				String userpassword = results.getString("userpassword");
				columns.put("userpassword", userpassword);
				
				String grade = results.getString("grade");
				columns.put("grade", grade);
				
				String department = results.getString("department");
				columns.put("department", department);
				
				
				rows.add(columns);
			}
			request.setAttribute("rows", rows);
		} catch (Exception e) {
			request.setAttribute("message", "Exception:" + e.getMessage());
		}
		
		String view = "/WEB-INF/views/officelist.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
  	}

}

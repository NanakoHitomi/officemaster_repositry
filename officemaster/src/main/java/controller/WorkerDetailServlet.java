package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class WorkerDetailServlet extends HttpServlet { 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getAttribute("message") == null) {
            request.setAttribute("message", "従業員ページ詳細");
        }
        
        int userId = Integer.parseInt(request.getParameter("id"));

        String url = "jdbc:mysql://localhost/officemaster";
        String user = "root";
        String password = ""; //mysqlでpwなしに設定されているためpw設定するとダメそう
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(sql)) {
        	
        	statement.setInt(1, userId);
        	
        	ResultSet results = statement.executeQuery();
        			
            while (results.next()) {

                String id = results.getString("id");
                request.setAttribute("id", id);

                String username = results.getString("username");
                request.setAttribute("username", username);
                
                String email = results.getString("email");
                request.setAttribute("email", email);
                
                String userpassword = results.getString("userpassword");
                request.setAttribute("userpassword", userpassword);

                String grade = results.getString("grade");
                request.setAttribute("grade", grade);
                
                String department = results.getString("department");
                request.setAttribute("department", department);
                
//                String officepassword = results.getString("password");
//                request.setAttribute("password", officepassword);
//                

            }
        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }


        String view = "/WEB-INF/views/workerdetail.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);


    }
    
}

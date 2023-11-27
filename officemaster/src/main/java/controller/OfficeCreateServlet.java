package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/officecreate")
public class OfficeCreateServlet extends HttpServlet {  

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getAttribute("message") == null) {
            request.setAttribute("message", "社員データを追加");
        }
        
       
        String username = request.getParameter("username");
        String department = request.getParameter("department");
        String grade = request.getParameter("grade");
        String email = request.getParameter("email");
       

        String url = "jdbc:mysql://localhost/officemaster";
        String user = "root";
        String password = ""; 
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO users (username, email, password, department,grade) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(sql)) {
        	
        	statement.setString(1, username);
        	statement.setString(2, email);
        	statement.setString(3, password);
        	statement.setString(4, department);
        	statement.setString(5, grade);
        	
        	
      
        	int number = statement.executeUpdate();
        	request.setAttribute("message", "タイトル:" + username + "さんの新規作成ができました");
        			
            
        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }


        String forward = "/adminlist";
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);


    }
    
}


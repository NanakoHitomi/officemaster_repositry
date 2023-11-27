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

@WebServlet("/destroy")
public class OfficeDestroyServlet extends HttpServlet {  

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getAttribute("message") == null) {
            request.setAttribute("message", "従業員管理");
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

        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(sql)) {
        	
        	
        	statement.setInt(1, userId);
        	int number = statement.executeUpdate();
        	request.setAttribute("message", "ID:" + userId + "の削除ができました");
        			
            
        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }


        String forward = "/officelist";
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);


    }
    
}


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

@WebServlet("/update")
public class OfficeUpdateServlet extends HttpServlet {  //親クラスを継承　
    //HttpServletはさまざまなSクラスを含む。継承することでリストサーブレットはうまく動く

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getAttribute("message") == null) {
            request.setAttribute("message", "従業員管理");
        }
        
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String department = request.getParameter("department");
        String grade = request.getParameter("grade");
        

        String url = "jdbc:mysql://localhost/officemaster";
        String user = "root";
        String password = ""; //mysqlでpwなしに設定されているためpw設定するとダメそう
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "UPDATE users SET username = ?, department = ?, grade = ?  WHERE id = ?";  //探したい項目WHEREは一番最後
     
        try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(sql)) {
    
        	
        	statement.setString(1, username);
        	statement.setString(2, department);
        	statement.setString(3, grade);
        	statement.setInt(4, userId);
 
        	
        	
        	int number = statement.executeUpdate();
        	request.setAttribute("message", "ID:" + userId + "の更新ができました");
        			
            
        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }


        String forward = "/show?id=" + userId;
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);


    }
    
}


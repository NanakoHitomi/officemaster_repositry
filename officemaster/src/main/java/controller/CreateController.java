package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.HashGenerator;

@WebServlet("/createaccount")
public class CreateController extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost/officemaster";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String view = "/WEB-INF/views/accountcreate.jsp";
        req.getRequestDispatcher(view).forward(req, res);
    }
    

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpassword = req.getParameter("userpassword");
        String email = req.getParameter("email");
        String grade = req.getParameter("grade");
        String department  = req.getParameter("department");
        String userid = req.getParameter("userid");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        	
            // フォームに入力したパスワードを平文のままにせずハッシュ化する
            String hashedPassword = HashGenerator.generateHash(userpassword);
            String sql = "INSERT INTO users (username, userpassword, email, grade, department) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//               stmt.setString(1, userid);
            	stmt.setString(1, username);
                stmt.setString(2, hashedPassword);
                stmt.setString(3, email);
                stmt.setString(４, grade);
                stmt.setString(５, department);
                stmt.execute();

                String view = "/WEB-INF/views/login.jsp";
                req.getRequestDispatcher(view).forward(req, res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database Connection Failed", e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ServletException("Generate hash Failed", e);
        }
    }
}
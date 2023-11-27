<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>AdminLogin Page</title>
</head>
<body>
<!-- リクエストスコープからエラーメッセージを受け取る -->
<%-- <%String failureMessage = (String)request.getAttribute("loginFailure); %> --%>

<!-- エラーメッセージが存在する時だけ表示 -->
<%-- <% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %> --%>


    <h1>管理者ログイン</h1>
    
<!-- ログインフォームここから。ユーザーネームとパスワードの入力 -->
<!-- action="login"で＠Webservlet("/login")へ -->
    <form method="POST" action="adminlogin">
    
    <!-- formを使って、ユーザーネームをusername、パスワードをpasswordという名前でサーブレットに送っている -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="userpassword">Password:</label>
        <input type="password" id="userpassword" name="userpassword" required><br>
         <label for="grade">grade:</label>
        <input type="grade" id="grade" name="grade" required><br>
    
    <form method ="POST" action="adminlogin">
    <input type="submit" value="管理者ログイン">
    </form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Create</h1>
    <form method="POST" action="createaccount">
    <!-- <label for="userid">社員番号:</label>
        <input type ="text" id="grade" name="grade" required><br> -->
        <label for="username">氏名:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="userpassword">パスワード:</label>
        <input type="password" id="userpassword" name="userpassword" required><br>
        <label for="email">メールアドレスl:</label>
        <input type ="email" id="email" name="email" required><br>
        <label for="grade">役職:</label>
        <input type ="text" id="grade" name="grade" required><br>
         <label for="departmentr">部署:</label>
        <input type ="text" id="department" name="department" required><br>
         <label for="id">部署:</label>
        <input type ="text" id="id" name="id" required><br>
        
        <input type="submit" value="Create" required>
    </form>
</body>
</html>
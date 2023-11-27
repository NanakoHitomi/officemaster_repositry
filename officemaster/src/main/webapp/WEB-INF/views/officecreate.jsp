<%@ page language="java"
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>newofficeworker</title>
  <style>ul {list-style: none; margin: 0; padding: 0;} li {float: left; margin-right: 20px; }</style>
</head>
<body>
    <h1>社員追加</h1>
    <% String message = (String)request.getAttribute("message"); %>   
    <p><%= message %></p>
    <form action="officecreate" method="get">
      <label for="username">従業員名</label><br>
      <input type="text" name="username" value=''><br>
      
       <label for="email">メールアドレス</label><br>
      <input type="email" name="email" value=''></textarea><br>
      
       <label for="password">パスワード</label><br>
      <input type="password" name="password" value=''></textarea><br>
      
      <label for="department">部署</label><br>
      <input type="text" name="department" value=''></textarea><br>
      
       <label for="grade">役職</label><br>
      <input type="text" name="grade" value=''><br>
    
      <p></p>
      <button type="submit">追加</button>
      <a href='oficelist'>キャンセル</a>
  </form>
<ul>
      <li><p><a href='adminlist'>戻る</a></p></li>
    </ul>      
</body>
</html>

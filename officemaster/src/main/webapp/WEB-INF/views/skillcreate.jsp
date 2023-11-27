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
    <form action="skill" method="get">
      <label for="final_education">最終学歴</label><br>
      <input type="text" name="final_education" value=''><br>
      
       <label for="formal_job">前職</label><br>
      <input type="text" name="formal_job" value=''></textarea><br>
    
      <p></p>
      <button type="submit">追加</button>
      <a href='adminlist'>キャンセル</a>
  </form>
<ul>
      <li><p><a href='adminlist'>戻る</a></p></li>
    </ul>      
</body>
</html>

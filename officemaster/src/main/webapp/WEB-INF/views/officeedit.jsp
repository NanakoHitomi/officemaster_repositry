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
  <title>社員編集</title>
  <style>ul {list-style: none; margin: 0; padding: 0;} li {float: left; margin-right: 20px; }</style>
</head>
<body>
    <h1>社員編集</h1>
   	  <% String message = (String)request.getAttribute("message"); %>   
    <p><%= message %></p>
    <form action="update" method="get">
   <!--  idは見せないで送るから hidden-->
      <input type="hidden" name="id" value='<%= request.getAttribute("id") %>'>
      <label for="username">従業員名</label><br>
      <input type="text" name="username" value='<%= request.getAttribute("username") %>'><br>
      <br>
      <label for="department">部署</label><br>
      <input type="text" name="department" value='<%= request.getAttribute("department") %>'>
      <br>
       <label for="grade">役職</label><br>
      <input type="text" name="grade" value='<%= request.getAttribute("grade") %>'><br>
      
      <p></p>
      <button type="submit">保存する</button>
      <a href='show?id=<%= request.getAttribute("id") %>'>キャンセル</a>
  </form>
<ul>
      <li><p><a href='adminlist'>戻る</a></p></li>
    </ul>      
</body>
</html>
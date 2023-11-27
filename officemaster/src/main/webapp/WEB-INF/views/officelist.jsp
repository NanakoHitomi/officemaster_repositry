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
<title>社員データ</title>
</head>
<body>
	<h1>社員データ</h1>
	<% String message = (String)request.getAttribute("message"); %>
	<p><%= message %></p>
	
	<span><strong>社員ID</strong></span>
	<span><strong>名前</strong></span><br>
	
	
	<%
	  ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String,String>>)request.getAttribute("rows");
	%>
	
	<%
	  for (HashMap<String, String> columns : rows) {
	%>
	<span><%= columns.get("id") %></span>
	<span><a href='show?id=<%= columns.get("id") %>'><%= columns.get("username") %></a></span><br>
	<% } %>
	<!-- <p><a href ="serch">検索</a> -->

	<!-- <p><a href="createaccount">新規作成</a></p> -->

</body>
</html>
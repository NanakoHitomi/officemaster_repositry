<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h1>Welcome</h1>
    <!-- セッションから値を取得 -->
    <p>ようこそ, <%= session.getAttribute("username") %>さん!</p>

    <table>
      <tbody>
        <tr>
          <th>社員ID</th>
          <td><%= session.getAttribute("id") %></td>
        </tr>
        <tr>
          <th>名前</th>
          <td><%= session.getAttribute("username") %></td>
        </tr>
        <tr>
          <%-- <th>役職</th>
          <td><%= session.getAttribute("grade") %></td> --%>
        </tr>
      </tbody>
    </table>

    <form method="POST" action="logout">
      <input type="submit" value="Logout">
    </form>
    
    <p>or <a href="officelist">home</a></p>
</body>
</html>
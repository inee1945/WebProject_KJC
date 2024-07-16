<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join</title>
</head>
<body>
    <h1>회원가입</h1>
    <form method="post" action="joinAction.jsp">
        <label for="userID">아이디:</label>
        <input type="text" id="userID" name="userID" required>
        <br>
        <label for="userPassword">비밀번호:</label>
        <input type="password" id="userPass" name="userPass" required>
        <br>
        <label for="userName">이름:</label>
        <input type="text" id="userName" name="userName" required>
        <br>
       
        <input type="submit" value="Join">
    </form>
</body>
</html>
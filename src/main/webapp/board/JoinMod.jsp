<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="./js/common.js"></script>
</head>
<body>

<span>
	<%=request.getAttribute("JoinErrMsg")==null? "":request.getAttribute("JoinErrMsg") %>
</span>
    <h1>회원정보 수정</h1>
    <form method="post" action="../board/joinMod.do" name = "loginFrm" 
    	onsubmit ="return validateForm_join(this)">
        <label for="userID">아이디:</label>
        <input type="text" id="userID" name="user_id" value = "<%= session.getAttribute("UserId") %>" readonly="readonly">
        <br>
        <label for="userPassword">비밀번호:</label>
        <input type="password" id="userPass" name="user_pwd" value = "<%= session.getAttribute("UserPwd") %>">
        <br>
        <label for="userName">이름:</label>
        <input type="text" id="userName" name="user_name" value = "<%= session.getAttribute("UserName") %>">
        <br>
       
        <input type="submit" value="수정">
    </form>
</body>
</html>
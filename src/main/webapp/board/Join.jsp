<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join</title>
</head>
<body>

	<%
		if(session.getAttribute("JoinErrMsg")!=null){		
	%>
		<script type="text/javascript">
			alert("회원가입이 실패하였습니다.");
			</script>
	<%
		}
	%>
    <h1>회원가입</h1>
    <form method="post" action="../board/join.do">
        <label for="userID">아이디:</label>
        <input type="text" id="userID" name="user_id" required>
        <br>
        <label for="userPassword">비밀번호:</label>
        <input type="password" id="userPass" name="user_pwd" required>
        <br>
        <label for="userName">이름:</label>
        <input type="text" id="userName" name="user_name" required>
        <br>
       
        <input type="submit" value="가입">
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="./js/common.js"></script>
</head>
<body>
	<h2>로그인 페이지</h2>
	<input type="hidden" name = "status" id="status" value="off">

	<%
	if(session.getAttribute("UserId")==null){		
	%>
		<%
		if(request.getAttribute("LoginErrMsg")!=null){
		%>
			<%=request.getAttribute("LoginErrMsg") %>아이디 비번을 확인하세요.<br />
		<%
		}
		%>
	
	<form action="../board/login.do" method="post" name = "loginFrm"
		onsubmit ="return validateForm_login(this)">
		아이디 : <input type = "text" id ="user_id" name="user_id"/><br />
		패스워드 : <input type="password" name ="user_pwd"/><br />
		<input type ="submit" value="로그인하기" />
	</form>
	<%
	}else{
	%>
		<%
		if(session.getAttribute("JoinErrMsg")!=null){
		%>
			
			<%=request.getAttribute("JoinErrMsg") %><br />
		<%
		}
		%>
		<%=session.getAttribute("UserName") %>회원님, 로그인하셨습니다.<br />
			
		<a href="Logout.jsp">[로그아웃]</a>
		<a href="JoinMod.jsp"  >[회원정보 수정]</a>
		<a href="../board/list.do">[자유게시판]</a>
	<%		
	}
	%>	
</body>
</html>
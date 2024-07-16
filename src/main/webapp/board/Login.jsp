<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	
	<%
	if(session.getAttribute("UserId")==null){		
	%>
		<%
		if(session.getAttribute("LoginErrMsg")!=null){
		%>
			<%=session.getAttribute("LoginErrMsg") %>아이디 비번을 확인하세요.<br />
		<%
		}
		%>
		
	<script>
	function validateForm(form){
		if(!form.user_id.value){
			alert("아이디를 입력하세요..");
			form.user_id.focus();
			return false;
		}
		if(form.user_pw.value==""){
			alert("패스워드를 입력하세요")
			form.user_pw.focus()
			return false;
		}
	}
	</script>	
	
	<form action="../board/login.do" method="post" name = "loginFrm"
		onsubmit ="return validateForm(this)">
		아이디 : <input type = "text" name="user_id"/><br />
		패스워드 : <input type="password" name ="user_pwd"/><br />
		<input type ="submit" value="로그인하기" />
	</form>
	<%
	}else{
	%>
		<%
		if(session.getAttribute("JoinErrMsg")!=null){
		%>
			<script type="text/javascript">
			alert("회원가입을 축하드립니다.");
			</script>
		<%
		}
		%>
		<%=session.getAttribute("UserName") %>회원님, 로그인하셨습니다.<br />
		<a href="Logout.jsp">[로그아웃]</a>
	<%		
	}
	%>	
</body>
</html>
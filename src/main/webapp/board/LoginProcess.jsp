<%@page import="board.MemberDTO"%>
<%@page import="board.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
String userId = request.getParameter("user_id");
String userPwd = request.getParameter("user_pw");

MemberDAO dao = new MemberDAO();
MemberDTO memberDTO = dao.getMember(userId, userPwd);
dao.close();

if(memberDTO.getId()!=null){
	session.setAttribute("UserId", memberDTO.getId());
	session.setAttribute("UserName",memberDTO.getName());
	response.sendRedirect("Login.jsp");
}else{
	request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
package member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/sessionOut.do")
public class SessionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg= "";
		HttpSession session = req.getSession();
		
		session.removeAttribute("SessionId");
		session.removeAttribute("SessionName");
		//세션의 모든영역 삭제
		
		msg = "회원탈퇴dddd 처리되었습니다.";
		session.setAttribute("msgM",msg);
		resp.sendRedirect("../main/index.do");
	}
}

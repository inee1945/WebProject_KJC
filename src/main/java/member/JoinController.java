package member;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.driver.Message;

@WebServlet("/member/join.do")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/authentication-register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = 	req.getParameter("id");
		String pass = 	req.getParameter("pass");
		String name = 	req.getParameter("name");
		String email = 	req.getParameter("email");
		String phone = req.getParameter("phone");
		String msg= "";
		MemberDAO dao = new MemberDAO();
		int result = dao.setJoin(id, pass, name,email,phone);
		HttpSession session=req.getSession();  
	//가입	성공하면 로그인화면으로 포워드
		if(result==1) {
			 msg = "회원가입에 성공하였습니다. 로그인 하세요.";
			session.setAttribute("msg",msg);
			resp.sendRedirect("../member/login.do");
		}else if(result==0) {
			msg = "이미 가입되어있는 회원입니다.아이디를 다시 확인해주세요";
			session.setAttribute("msgJ",msg);
			  resp.sendRedirect("../member/join.do");
		}else {
			msg = "회원가입에 실패하였습니다. 입력정보를 다시 확인해주세요";
			session.setAttribute("msgJ",msg);
			  resp.sendRedirect("../member/join.do");
		}
		
	}
}

package member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.driver.Message;

@WebServlet("/member/joinMod.do")
public class JoinModController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id =	req.getParameter("id");
	System.out.println(id);
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getMemInfo(id);
	req.setAttribute("dto", dto);
	req.getRequestDispatcher("/jsp/editRegister.jsp").forward(req, resp);

	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = 	req.getParameter("id");
		String pass = 	req.getParameter("pass");
		String name = 	req.getParameter("name");
		String email = 	req.getParameter("email");
		String phone = req.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		int rs = dao.updateJoin(id, pass, name,email,phone);
		
	//가입	성공하면 로그인화면으로 포워드
		if(rs==1) {
			resp.sendRedirect("../member/login.do");
		}else {
			  resp.sendRedirect("../member/join.do");
		}
		
	}
}

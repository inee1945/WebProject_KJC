package board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.driver.Message;

@WebServlet("/board/joinMod.do")
public class JoinModController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = 	req.getParameter("user_id");
		String pwd = 	req.getParameter("user_pwd");
		String name = 	req.getParameter("user_name");
		
		MemberDAO dao = new MemberDAO();
		int rs = dao.updateJoin(id, pwd, name);
		dao.close();
		
    	HttpSession session=req.getSession();  
    		
		 // 로그인정보 저장 후 로그인화면으로 포워드
		if(rs>=1) {
			req.setAttribute("rs", rs);
			session.setAttribute("UserId", id);
			session.setAttribute("UserName",name);
		    req.setAttribute("JoinErrMsg","회원정보 수정이 완료되었습니다..");
		    req.getRequestDispatcher("/board/Login.jsp").forward(req, resp);
		}else {
			req.setAttribute("JoinErrMsg","회원정보 수정이 실패하였습니다.");
			  req.getRequestDispatcher("/board/JoinMod.jsp").forward(req, resp);
		}
		
	}
}

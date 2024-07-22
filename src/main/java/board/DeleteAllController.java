package board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDAO;

@WebServlet("/board/deleteAll.do")
public class DeleteAllController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int result = 0;
		BoardDAO dao = new BoardDAO();
		MemberDAO memDao = new MemberDAO();		
		result = dao.deleteAllPost(id);
		String msg= "";
		HttpSession session=req.getSession();  
		if(result>=1) {
			memDao.deleteJoin(id);
			//삭제 성공
			msg = "회원탈퇴 처리되었습니다.";
			session.setAttribute("msg",msg);
			resp.sendRedirect("../member/login.do");
		}
	}
}

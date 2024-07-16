package board;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/board/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 게시물 불러오기
    	MemberDAO dao = new MemberDAO();
    	MemberDTO dto = dao.getMember(req.getParameter("user_id"), req.getParameter("user_pw"));
    
    	HttpSession session=req.getSession();  
    	session.setAttribute("UserId", dto.getId());
		session.setAttribute("UserName",dto.getName());
		session.setAttribute("LoginErrMsg","로그인 오류입니다.");
		        
        // 로그인정보 저장 후 로그인화면으로 포워드
		if(dto!=null) {
			req.setAttribute("dto", dto);
		    req.getRequestDispatcher("/board/Login.jsp").forward(req, resp);
		}
       
    }
}

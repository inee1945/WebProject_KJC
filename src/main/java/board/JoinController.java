package board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.driver.Message;

@WebServlet("/board/join.do")
public class JoinController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = 	req.getParameter("user_id");
		String pwd = 	req.getParameter("user_pwd");
		String name = 	req.getParameter("user_name");
		
		MemberDAO dao = new MemberDAO();
		int rs = dao.setJoin(id, pwd, name);
		System.out.println("%%%%%%%%%%%"+rs);
		dao.close();
		
    	HttpSession session=req.getSession();  
    		
		 // 로그인정보 저장 후 로그인화면으로 포워드
		if(rs>=1) {
			req.setAttribute("rs", rs);
			session.setAttribute("UserId", id);
			session.setAttribute("UserName",name);
		    session.setAttribute("JoinErrMsg","회원가입이 완료되었습니다..");
		    req.getRequestDispatcher("/board/Login.jsp").forward(req, resp);
		}else {
			  session.setAttribute("JoinErrMsg","회원가입이 실패하였습니다.");
			  req.getRequestDispatcher("/board/Join.jsp").forward(req, resp);
		}
		
	}
}

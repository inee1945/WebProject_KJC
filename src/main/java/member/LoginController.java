package member;

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

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/authentication-login.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
    	String id = req.getParameter("id");
    	String pass = req.getParameter("pass");
    	
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id, pass);
    	
		if(dto.getId().equals("")) {
			resp.sendRedirect("../member/login.do");
		}else {
			HttpSession session=req.getSession();  
			session.setAttribute("SessionId", dto.getId());
			session.setAttribute("SessionName", dto.getName());
			resp.sendRedirect("../main/index.do");
		}
    	
       
    }
}

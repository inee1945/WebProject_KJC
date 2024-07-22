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
		int result = 0;
		String mode = req.getParameter("mode");
		String id = 	req.getParameter("id");
		String pass = 	req.getParameter("pass");
		String name = 	req.getParameter("name");
		String email = 	req.getParameter("email");
		String phone = req.getParameter("phone");
		String msg= "";
		HttpSession session=req.getSession();  
		MemberDAO dao = new MemberDAO();
		
		if(mode.equals("U")) {
			 result = dao.updateJoin(id, pass, name,email,phone);	
		}else {
			result = dao.writeListYn(id);
			System.out.println("모드"+result);
			if(result==0) {
				result = dao.deleteJoin(id);
			}else{result = 2;}
		
		}
		
		
	//가입(탈퇴)	성공하면 로그인화면으로 포워드
		if(result==1) {
			 msg = "회원정보를 수정하였습니다. 로그인 하세요.";
				session.setAttribute("msg",msg);
			resp.sendRedirect("../member/login.do");
		}else if(result==0) {
			msg = "회원정보 수정에 실패하였습니다. 입력정보를 다시 확인하세요.";
			session.setAttribute("msg",msg);
			  resp.sendRedirect("../member/joinMod.do?id="+id);
		}else if(result==3) {
			msg = "회원탈퇴 처리되었습니다.";
			session.setAttribute("msg",msg);
			session.removeAttribute("SessionId");
			resp.sendRedirect("../main/index.do");
		}else if(result==2) { 
			System.out.println("여기까지 오는거야?");
			msg ="게시글이 있는 경우 탈퇴가 불가능합니다. 삭제 후 탈퇴하시겠습니까?";
			session.setAttribute("wNum","Y" );
			session.setAttribute("msg",msg);
		resp.sendRedirect("../member/joinMod.do?id="+id);
			
		}else {msg = "회원정보 수정에 실패하였습니다. 입력정보를 다시 확인하세요.";
		session.setAttribute("msg",msg);
		  resp.sendRedirect("../member/joinMod.do?id="+id);
		  }
	}
}

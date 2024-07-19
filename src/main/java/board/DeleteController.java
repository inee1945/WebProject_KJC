package board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bk = req.getParameter("bk");
		String idx = req.getParameter("idx");
		int result = 0;
		BoardDAO dao = new BoardDAO();
				
		result = dao.deletePost(idx);
		if(result==1) {
			//삭제 성공
			resp.sendRedirect("../board/list.do?bk="+bk);
		}
	}
}

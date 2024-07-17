package board;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 게시물 불러오기
        BoardDAO dao = new BoardDAO();
        String idx = req.getParameter("idx");
        dao.updateVisitCount(idx);  // 조회수 1 증가
        BoardDTO dto = dao.selectView(idx);
        dao.close();

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
        
        //첨부파일 확장자 추출 및 이미지 타입 확인
        String extension =null; 
        String fileName = dto.getSfile();
        if(fileName!=null) {
        	extension = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        
        
        // 게시물(dto) 저장 후 뷰로 포워드
        req.setAttribute("dto", dto);
        req.setAttribute("extension", extension);
        req.getRequestDispatcher("/board/View.jsp").forward(req, resp);
    }
}

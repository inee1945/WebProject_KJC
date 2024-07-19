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
        String bk = req.getParameter("bk");
		String boardName = bk.equals("A")?"자유":(bk.equals("B")?"Q&A":"자료실");
        dao.updateVisitCount(idx);  // 조회수 1 증가
        BoardDTO dto = dao.selectView(idx);
        dao.close();
        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
        //본인여부

        
        //첨부파일 확장자 추출 및 이미지 타입 확인
        String extension =null,  mimeType =null;; 
        String fileName = dto.getSfile();
        if(fileName!=null) {
        	extension = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        
        String[] extArray1 = {"png", "jpg", "gif"};
        String[] extArray2 = {"mp3", "wav"};
        String[] extArray3 = {"mp4", "avi", "wmv"};
        
        List<String> mimeList1 = Arrays.asList(extArray1);
        List<String> mimeList2 = Arrays.asList(extArray2);
        List<String> mimeList3 = Arrays.asList(extArray3);
        
        if (mimeList1.contains(extension)) mimeType = "img";
        else if(mimeList2.contains(extension))   mimeType = "audio";
        else if(mimeList3.contains(extension))   mimeType = "video";
        
        
        //  뷰로 포워드
        req.setAttribute("mimeType", mimeType);
        req.setAttribute("boardName", boardName);
    	req.setAttribute("bk", bk);
        req.setAttribute("dto", dto);
        req.setAttribute("extension", extension);
        req.getRequestDispatcher("/jsp/view.jsp").forward(req, resp);
    }
}

package board;

import java.io.IOException;

import common.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

@WebServlet("/board/write.do")

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2mb
        maxFileSize = 1024 * 1024 * 10, // 10mb
        maxRequestSize = 1024 * 1024 * 50 //50mb
        
)
public class WriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/write.jsp").forward(req, resp);
		
	}
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
			String bk = req.getParameter("bk");
			System.out.println();
			String boardName = bk.equals("A")?"자유":(bk.equals("B")?"Q&A":"자료실");
	        // 1. 파일 업로드 처리 =============================
	        // 업로드 디렉터리의 물리적 경로 확인
	        String saveDirectory = req.getServletContext().getRealPath("/Uploads");
	                
	        // 파일 업로드
	        String originalFileName = "";
	        try {
	        	originalFileName = FileUtil.uploadFile(req, saveDirectory);
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        	JSFunction.alertLocation(resp, "파일 업로드 오류입니다.",
	                    "../board/write.do");
	        	return;
			}

	        // 2. 파일 업로드 외 처리 =============================
	        // 폼값을 DTO에 저장
	        BoardDTO dto = new BoardDTO(); 
	        dto.setName(req.getParameter("name"));
	        dto.setTitle(req.getParameter("title"));
	        dto.setContent(req.getParameter("content"));
	        dto.setId(req.getParameter("id"));

	        // 원본 파일명과 저장된 파일 이름 설정
	        if (originalFileName != "") { 
	        	// 파일명 변경
	        	String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
	        	
	            dto.setOfile(originalFileName);  // 원래 파일 이름
	            dto.setSfile(savedFileName);  // 서버에 저장된 파일 이름
	        }

	        // DAO를 통해 DB에 게시 내용 저장
	        BoardDAO dao = new BoardDAO();
	        int result = dao.insertWrite(dto);
	        req.setAttribute("bk", bk);
			req.setAttribute("boardName", boardName);
	        dao.close();

	        // 성공 or 실패?
	        if (result == 1) {  // 글쓰기 성공
	            resp.sendRedirect("../board/list.do?bk="+bk);
	        }
	        else {  // 글쓰기 실패
	        	 JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.",
	                     "../board/write.do");
	        }
	    }
	}

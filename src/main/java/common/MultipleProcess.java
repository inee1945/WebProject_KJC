package common;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/13FileUpload/MultipleProcess.do")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 1,
	maxRequestSize = 1024 * 1024 * 10
)
public class MultipleProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			// 디렉토리의 물리적 경로 
		    String saveDirectory = getServletContext().getRealPath("/Uploads");
		    
		    //다중 파일 업로드 하기
		    ArrayList<String> listFileName = FileUtil.multipleFile(req, saveDirectory);
	         
		    //파일 갯수만큼 반복
		    for(String originalFileName : listFileName) {
		        //저장된 파일명 변경하기
		        String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
		       
		    }
	        resp.sendRedirect("FileList.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "파일 업로드 오류");
			req.getRequestDispatcher("MultiUploadMain.jsp").forward(req, resp);
		}
	}
}
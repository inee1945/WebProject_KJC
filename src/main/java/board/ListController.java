package board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.BoardPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/list.do")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BoardDAO boardDao = new BoardDAO();
		Map<String, Object>map = new HashMap<String, Object>();
		
		//where절 필드명과 검색어
		String searchWord =	req.getParameter("searchWord");
		String searchField = req.getParameter("searchField");
		if(searchWord != null) {
			map.put("searchWord", searchWord);
			map.put("searchField", searchField);
		}
		int totalCnt = boardDao.selectCount(map);
		
		//페이지네이션 처리.. 어렵다.
		int pageSize = 10;
		int pageBlock = 5;
		
		//현재 페이지
		int pageNum = 1; 
		String pageTemp = req.getParameter("pageNum");
		if(pageTemp !=null && !pageTemp.equals("")) pageNum = Integer.parseInt(pageTemp);
		
		//페이지당 표현할 게시물 범위
		int start = (pageNum-1)*pageSize +1 ; // 첫 게시물 번호
		int end = pageNum*pageSize; // 마지막 게시물 번호
		
		map.put("start", start);
		map.put("end", end);
		/*  페이지 처리 끝		*/		
		
		List<BoardDTO> boardLists = boardDao.getBoardList(map); 
		
		String pagingImg = BoardPage.pagingStr(totalCnt, pageSize, pageBlock, pageNum, "../board/list.do");
		map.put("pagingImg", pagingImg);
		map.put("totalCnt", totalCnt);
		map.put("pageSize", pageSize);
		map.put("pageNum",pageNum);
		
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		
		req.getRequestDispatcher("../board/List.jsp").forward(req, resp);
	}
}

package kr.or.ddit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.boards.dao.BoardDaoInf;
import kr.or.ddit.boards.model.BoardVo;
import kr.or.ddit.boards.service.BoardService;
import kr.or.ddit.boards.service.BoardServiceInf;

/**
 * Servlet implementation class BoardAddServlet
 */
@WebServlet("/boardAdd")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	* Method : doGet
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC11
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 수정
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoard_code(request.getParameter("board_code"));
		boardVo.setBoard_use(request.getParameter("boardUse"));
		
		BoardServiceInf boardService = BoardService.getInstance();
		boardService.updateBoardUse(boardVo);
		HttpSession session = request.getSession();
		session.setAttribute("useBoardList",boardService.selectUseBoard());
		request.setAttribute("boardAllList", boardService.getAllBoard());
		request.getRequestDispatcher("/board/boardAdd.jsp").forward(request, response);
	}

	/**
	 * 
	* Method : doPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC11
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 생성 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_nm=request.getParameter("newboard");
		String board_use=request.getParameter("boardUse");
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_nm(board_nm);
		boardVo.setBoard_use(board_use);
		BoardServiceInf boardService = BoardService.getInstance();
		HttpSession session = request.getSession();
		session.setAttribute("useBoardList",boardService.selectUseBoard());
		boardService.insertBoardAdd(boardVo);
		request.setAttribute("boardAllList", boardService.getAllBoard());
		request.getRequestDispatcher("/board/boardAdd.jsp").forward(request, response);
	}

}

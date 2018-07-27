package kr.or.ddit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.boards.model.BoardVo;
import kr.or.ddit.boards.service.BoardService;
import kr.or.ddit.boards.service.BoardServiceInf;


@WebServlet("/boardCreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf boardService = BoardService.getInstance();
		
		List<BoardVo> boardAllList = boardService.getAllBoard();
		HttpSession session = request.getSession();
		session.setAttribute("currentPage", "boardCreate");
		request.setAttribute("boardAllList", boardAllList);
		request.getRequestDispatcher("/board/boardAdd.jsp").forward(request, response);
	}



}

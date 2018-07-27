package kr.or.ddit.boards.service;

import java.util.List;

import kr.or.ddit.boards.dao.BoardDao;
import kr.or.ddit.boards.dao.BoardDaoInf;
import kr.or.ddit.boards.model.BoardVo;

public class BoardService implements BoardServiceInf {
	static private BoardServiceInf boardService = new BoardService();
	private BoardDaoInf boardDao;
	
	private BoardService(){
		boardDao = BoardDao.getInstance();
	}
	
	static public BoardServiceInf getInstance(){
		return boardService;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		return boardDao.getAllBoard();
	}

	@Override
	public boolean insertBoardAdd(BoardVo boardVo) {
		return boardDao.insertBoardAdd(boardVo);
	}

	@Override
	public boolean updateBoardUse(BoardVo boardVo) {
		return boardDao.updateBoardUse(boardVo);
	}

	@Override
	public List<BoardVo> selectUseBoard() {
		return boardDao.selectUseBoard();
	}

	@Override
	public String selectBoardName(String board_code) {
		return boardDao.selectBoardName(board_code);
	}
	
}

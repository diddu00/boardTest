package boardProjectTest.boardDaoTest;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.boards.dao.BoardDao;
import kr.or.ddit.boards.dao.BoardDaoInf;
import kr.or.ddit.boards.model.BoardVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import boardProjectTest.studentDaoTest.StudentDaoTest;

public class BoardDaoTest {
	private Logger logger = LoggerFactory.getLogger(StudentDaoTest.class);
	private BoardDaoInf dao = BoardDao.getInstance();

	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		  
		/***When***/
		List<BoardVo> boardList = dao.getAllBoard();
		/***Then***/
		assertEquals(3, boardList.size());
	}
	

	public void insertBoardAddTest() {
		/***Given***/
		BoardVo tmp = new BoardVo();
		tmp.setBoard_nm("개꿀팁게시판");

		/***When***/
		boolean result = dao.insertBoardAdd(tmp);
		/***Then***/
		assertEquals(true, result);

	}
	
	
	public void updateBoardUseTest() {
		/***Given***/
		BoardVo tmp = new BoardVo();
		tmp.setBoard_code("b001");
		tmp.setBoard_use("false");
		/***When***/
		boolean result = dao.updateBoardUse(tmp);
		/***Then***/
		assertEquals(true, result);
	}
	
	@Test
	public void selectUseBoardTest() {
		/***Given***/
		

		/***When***/
		List<BoardVo> useBoardList = dao.selectUseBoard();
		for (BoardVo boardVo : useBoardList) {
			logger.debug("----------------------------"+boardVo.toString());
		}
		/***Then***/
		assertEquals(2, useBoardList.size());
	}

}

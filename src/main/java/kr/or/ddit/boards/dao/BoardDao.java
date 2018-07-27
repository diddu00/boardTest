package kr.or.ddit.boards.dao;

import java.util.List;

import kr.or.ddit.boards.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao implements BoardDaoInf {
	private static BoardDaoInf boardDao = new BoardDao();
	private SqlSessionFactory sqlSessionFactory= SqlMapSessionFactory.getSqlSessionFactory();
	
	public static BoardDaoInf getInstance() {
		return boardDao;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAllBoard");
		session.close();
		return boardList;
	}

	@Override
	public boolean insertBoardAdd(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("board.insertBoardAdd", boardVo);
		boolean result = false;
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		return result;
	}

	@Override
	public boolean updateBoardUse(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("board.updateBoardUse", boardVo);
		boolean result = false;
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		return result;
	}

	@Override
	public List<BoardVo> selectUseBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> useBoardList = session.selectList("board.selectUseBoard");
		session.close();
		return useBoardList;
	}

	@Override
	public String selectBoardName(String board_code) {
		SqlSession session = sqlSessionFactory.openSession();
		String board_nm = session.selectOne("board.selectBoardName",board_code);
		session.close();
		return board_nm;
	}
	
	
	
	

}

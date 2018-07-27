package kr.or.ddit.boards.service;

import java.util.List;

import kr.or.ddit.boards.model.BoardVo;

public interface BoardServiceInf {
	/**
	 * 
	* Method : getAllBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판정보를 조회하는 메서드
	 */
	List<BoardVo> getAllBoard();
	
	/**
	 * 
	* Method : insertBoardAdd
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC11
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판정보 추가
	 */
	boolean insertBoardAdd(BoardVo boardVo);
	
	/**
	 * 
	* Method : updateBoardUse
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC11
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 해당 게시판 사용여부 수정
	 */
	boolean updateBoardUse(BoardVo boardVo);
	
	
	/**
	 * 
	* Method : selectUseBoard
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 사용하는 게시판들의 정보만을 조회
	 */
	List<BoardVo> selectUseBoard();
	
	/**
	 * 
	* Method : selectBoardName
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : PC11
	* 변경이력 :
	* @param board_nm
	* @return
	* Method 설명 : 해당 게시판 이름을 가져오는 메서드
	 */
	String selectBoardName(String board_code);
}

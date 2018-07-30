package kr.or.ddit.comments.dao;

import java.util.List;

import kr.or.ddit.comments.model.CommentVo;

public interface CommentDaoInf {
	/**
	 * 
	* Method : selectGetCommentsByPost_Code
	* 최초작성일 : 2018. 7. 27.
	* 작성자 : PC11
	* 변경이력 :
	* @param post_code
	* @return
	* Method 설명 : 해당 게시물 댓글조회
	 */
	List<CommentVo>selectGetCommentsByPost_Code(String post_code);
	/**
	 * 
	* Method : insertComment
	* 최초작성일 : 2018. 7. 27.
	* 작성자 : PC11
	* 변경이력 :
	* @param commentVo
	* @return
	* Method 설명 : 댓글 삽입
	 */
	boolean insertComment(CommentVo commentVo);
	/**
	 * 
	* Method : deleteComment
	* 최초작성일 : 2018. 7. 27.
	* 작성자 : PC11
	* 변경이력 :
	* @param comment_code
	* @return
	* Method 설명 : 해당 댓글 삭제 
	 */
	boolean deleteComment(String comment_code);
}

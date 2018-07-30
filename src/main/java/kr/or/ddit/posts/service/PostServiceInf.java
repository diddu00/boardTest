package kr.or.ddit.posts.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.posts.model.PostVo;

public interface PostServiceInf {
	/**
	 * 
	* Method : selectRecentPostCode
	* 최초작성일 : 2018. 7. 30.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 가장 최근의 post_code 반환
	 */
	String selectRecentPostCode();
	/**
	 * 
	* Method : selectPostPageList
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC11
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 삭제여부가 false인 해당게시판의 게시글을 조회와 페이징처리
	 */
	Map<String, Object> selectPostPageList(Map<String, Object> map);
	
	/**
	 * 
	* Method : selectGetPostbyCode
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : PC11
	* 변경이력 :
	* @param post_code
	* @return
	* Method 설명 :
	 */
	PostVo selectGetPostbyCode(String post_code);
	
	/**
	 * 
	* Method : updatePost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC11
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 해당 게시글 수정
	 */
	boolean updatePost(PostVo postVo);
	
	
	/**
	 * 
	* Method : insertPost
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC11
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글추가
	 */
	boolean insertPost(PostVo postVo);
	/**
	 * 
	* Method : insertAttach
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC11
	* 변경이력 :
	* @param attachVo
	* @return
	* Method 설명 : 첨부파일 추가
	 */
 	boolean insertAttach(AttachmentVo attachVo);
}

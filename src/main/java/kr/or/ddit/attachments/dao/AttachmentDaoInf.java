package kr.or.ddit.attachments.dao;

import java.util.List;

import kr.or.ddit.attachments.model.AttachmentVo;

public interface AttachmentDaoInf {
	
	/**
	 * 
	* Method : selectGetAttach
	* 최초작성일 : 2018. 7. 26.
	* 작성자 : PC11
	* 변경이력 :
	* @param attach_code
	* @return
	* Method 설명 : 해당 첨부파일 정보조회
	 */
	AttachmentVo selectGetAttach(String attach_code);
 	/**
 	 * 
 	* Method : deleteAttach
 	* 최초작성일 : 2018. 7. 24.
 	* 작성자 : PC11
 	* 변경이력 :
 	* @param attach_code
 	* @return
 	* Method 설명 : 첨부파일 삭제
 	 */
 	boolean deleteAttach(String attach_code);
 	/**
 	 * 
 	* Method : selectAttachbyCode
 	* 최초작성일 : 2018. 7. 24.
 	* 작성자 : PC11
 	* 변경이력 :
 	* @param post_code
 	* @return
 	* Method 설명 : 게시글 첨부파일 조회 
 	 */
 	List<AttachmentVo> selectAttachbyCode(String post_code);
}

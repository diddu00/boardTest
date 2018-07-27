package kr.or.ddit.student.dao;

import kr.or.ddit.student.model.StudentVo;

public interface StudentDaoInf {
	/**
	 * 
	* Method : loginStudent
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC11
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 로그인 메서드
	 */
	StudentVo loginStudent(StudentVo studentVo);
}

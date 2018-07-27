package kr.or.ddit.student.service;

import kr.or.ddit.KISA_SHA256.KISA_SHA256;
import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf{
	static private StudentServiceInf studentService = new StudentService();
	private StudentDaoInf studentDao;
	
	private StudentService() {
		studentDao = StudentDao.getInstance();
	}
	
	static public StudentServiceInf getInstance(){
		return studentService;
	}
	
	
	@Override
	public StudentVo loginStudent(StudentVo studentVo) {
		studentVo.setPass(KISA_SHA256.encrypt(studentVo.getPass()));
		return studentDao.loginStudent(studentVo);
	}
	
}

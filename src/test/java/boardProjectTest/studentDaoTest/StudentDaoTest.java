package boardProjectTest.studentDaoTest;

import static org.junit.Assert.*;
import kr.or.ddit.KISA_SHA256.KISA_SHA256;
import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentDaoTest {
	private Logger logger = LoggerFactory.getLogger(StudentDaoTest.class);
	StudentDaoInf dao = StudentDao.getInstance();
	
	@Test
	public void loginStudentTest() {
		/***Given***/
		StudentVo std = new StudentVo();
		std.setStd_id("test8");
		std.setPass(KISA_SHA256.encrypt("qwer1"));

		/***When***/
		StudentVo std2 = dao.loginStudent(std);
		logger.debug(std2.toString());
		/***Then***/
		assertEquals("차득림", std2.getName());
		
		
	}

}

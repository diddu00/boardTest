package kr.or.ddit.student.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf{
	static private StudentDaoInf studentDao = null;
	private SqlSessionFactory sqlSessionFactory= SqlMapSessionFactory.getSqlSessionFactory();
	
	static public StudentDaoInf getInstance(){
		if(studentDao==null){
			studentDao = new StudentDao();
		}
		return studentDao;
	}
	
	@Override
	public StudentVo loginStudent(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo std = session.selectOne("student.loginStudent",studentVo);  
		session.close();
		return std;
	}

}

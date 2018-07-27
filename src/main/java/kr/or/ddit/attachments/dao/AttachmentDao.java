package kr.or.ddit.attachments.dao;

import java.util.List;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AttachmentDao implements AttachmentDaoInf{
	private static AttachmentDaoInf attachmentDao = new AttachmentDao();
	private SqlSessionFactory sqlSessionFactory= SqlMapSessionFactory.getSqlSessionFactory();
	
	private AttachmentDao(){
		
	}
	
	public static AttachmentDaoInf getInstance(){
		return attachmentDao;
	}

	

	@Override
	public boolean deleteAttach(String attach_code) {
		SqlSession session = sqlSessionFactory.openSession();
		boolean result = false;
		int cnt = session.delete("attach.deleteAttach",attach_code);
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public List<AttachmentVo> selectAttachbyCode(String post_code) {
		SqlSession session = sqlSessionFactory.openSession();
		List<AttachmentVo> attachList = session.selectList("attach.selectAttachbyCode",post_code);
		session.close();
		
		return attachList;
	}

	@Override
	public AttachmentVo selectGetAttach(String attach_code) {
		SqlSession session = sqlSessionFactory.openSession();
		AttachmentVo attachVo = session.selectOne("attach.selectGetAttach",attach_code);
		session.close();
		
		return attachVo;
	}
	
	
}

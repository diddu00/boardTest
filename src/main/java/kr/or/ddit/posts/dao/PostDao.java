package kr.or.ddit.posts.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.posts.model.PostVo;

public class PostDao implements PostDaoInf{
	private static PostDaoInf postDao = new PostDao();
	private SqlSessionFactory sqlSessionFactory; 
	
	private PostDao() {
		 sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}
	
	public static PostDaoInf getInstance(){
		return postDao;
	}
	
	
	
	@Override
	public List<PostVo> selectPostPageList(Map<String, Object> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postPageList = session.selectList("posts.selectPostPageList",map);
		session.close();
		
		return postPageList;
	}

	@Override
	public int selectPostTnt(String board_code) {
		SqlSession session = sqlSessionFactory.openSession();
		int postTnt = session.selectOne("posts.selectPostTnt",board_code);
		session.close();
		return postTnt;
	}

	@Override
	public boolean updatePost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("posts.updatePost",postVo);
		boolean result = false;
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		return result;
	}



	@Override
	public boolean insertPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("posts.insertPost",postVo);
		boolean result = false;
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public PostVo selectGetPostbyCode(String post_code) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVo post = session.selectOne("posts.selectGetPostbyCode",post_code);
		session.close();
		return post;
	}
	
	@Override
	public boolean insertAttach(AttachmentVo attachVo) {
		SqlSession session = sqlSessionFactory.openSession();
		boolean result = false;
		int cnt = session.insert("posts.insertAttach",attachVo);
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		
		return result;
	}
	
}

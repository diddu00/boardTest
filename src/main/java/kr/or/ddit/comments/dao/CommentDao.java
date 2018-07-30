package kr.or.ddit.comments.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.comments.model.CommentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class CommentDao implements CommentDaoInf {
	private static CommentDaoInf commentDao = new CommentDao();
	private SqlSessionFactory SqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	private CommentDao(){
		
	}
	
	public static CommentDaoInf getInstance(){
		return commentDao;
	}
	
	@Override
	public List<CommentVo> selectGetCommentsByPost_Code(String post_code) {
		SqlSession session = SqlSessionFactory.openSession();
		List<CommentVo> commentList=session.selectList("comment.selectGetCommentsByPost_Code",post_code);
		session.close();
		return commentList;
	}

	@Override
	public boolean insertComment(CommentVo commentVo) {
		SqlSession session = SqlSessionFactory.openSession();
		int cnt = session.insert("comment.insertComment",commentVo);
		boolean result = false;
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public boolean deleteComment(String comment_code) {
		SqlSession session = SqlSessionFactory.openSession();
		int cnt = session.update("comment.deleteComment",comment_code);
		boolean result = false;
		if(cnt>0){
			result = true;
		}
		session.commit();
		session.close();
		
		return result;
	}
	
}

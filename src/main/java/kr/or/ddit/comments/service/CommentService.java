package kr.or.ddit.comments.service;

import java.util.List;

import kr.or.ddit.comments.dao.CommentDao;
import kr.or.ddit.comments.dao.CommentDaoInf;
import kr.or.ddit.comments.model.CommentVo;

public class CommentService implements CommentServiceInf{
	private static CommentServiceInf commentService = new CommentService();
	private CommentDaoInf commentDao;
	
	private CommentService(){
		commentDao = CommentDao.getInstance();
	}
	
	public static CommentServiceInf getInstance(){
		return commentService;
	}
	
	@Override
	public List<CommentVo> selectGetCommentsByPost_Code(String post_code) {
		return commentDao.selectGetCommentsByPost_Code(post_code);
	}

	@Override
	public boolean insertComment(CommentVo commentVo) {
		return commentDao.insertComment(commentVo);
	}

	@Override
	public boolean deleteComment(String comment_code) {
		return commentDao.deleteComment(comment_code);
	}

}

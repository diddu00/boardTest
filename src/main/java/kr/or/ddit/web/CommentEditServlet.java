package kr.or.ddit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comments.model.CommentVo;
import kr.or.ddit.comments.service.CommentService;
import kr.or.ddit.comments.service.CommentServiceInf;
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/commentEdit")
public class CommentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //입력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_code=request.getParameter("id");
		String page = request.getParameter("page");
		String comment_ctt = request.getParameter("comment_ctt");
		
		CommentVo paramVo = new CommentVo();
		paramVo.setComment_ctt(comment_ctt);
		paramVo.setPost_code(post_code);
		
		StudentVo studentVo = (StudentVo)request.getSession().getAttribute("studentVo");
		paramVo.setStd_id(studentVo.getStd_id());
		
		CommentServiceInf commentService = CommentService.getInstance();
		commentService.insertComment(paramVo);
		response.sendRedirect("/postDetail?page="+page+"&id="+post_code);
	}
	
	//삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_code=request.getParameter("id");
		String page = request.getParameter("page");
		
		CommentServiceInf commentService = CommentService.getInstance();
		commentService.deleteComment(request.getParameter("comment_id"));
		response.sendRedirect("/postDetail?page="+page+"&id="+post_code);
	}

}

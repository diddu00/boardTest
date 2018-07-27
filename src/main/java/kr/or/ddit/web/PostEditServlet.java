package kr.or.ddit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.model.PostVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostServiceInf;

/**
 * Servlet implementation class PostEditServlet
 */
@WebServlet("/postEdit")
public class PostEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //수정
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_code = request.getParameter("deleteValue");
		int page = Integer.parseInt(request.getParameter("page"));
		
		PostServiceInf postService = PostService.getInstance();
		PostVo postVo = postService.selectGetPostbyCode(post_code);
		
		postVo.setPost_dlt("true");
		postService.updatePost(postVo);
		response.sendRedirect("/postList?page="+page+"&pageSize=10&board_code="+postVo.getBoard_code());
		
		
	}

}

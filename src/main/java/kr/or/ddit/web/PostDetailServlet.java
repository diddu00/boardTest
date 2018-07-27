package kr.or.ddit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.attachments.service.AttachmentService;
import kr.or.ddit.attachments.service.AttachmentServiceInf;
import kr.or.ddit.boards.service.BoardService;
import kr.or.ddit.boards.service.BoardServiceInf;
import kr.or.ddit.posts.model.PostVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostServiceInf;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_code=(String)request.getParameter("id");
		int page = Integer.parseInt(request.getParameter("page"));
	
		PostServiceInf postService = PostService.getInstance();
		AttachmentServiceInf attachmentService = AttachmentService.getInstance();
		
		PostVo postVo= postService.selectGetPostbyCode(post_code);
		List<AttachmentVo> attachList = attachmentService.selectAttachbyCode(post_code);
		BoardServiceInf boardService = BoardService.getInstance();
		String board_nm=boardService.selectBoardName(postVo.getBoard_code());
		request.setAttribute("postVo", postVo);
		request.setAttribute("board_nm", board_nm);
		request.setAttribute("page", page);  
		request.setAttribute("attachList", attachList);
		
		if(postVo.getPost_dlt().equals("true")){
			request.getRequestDispatcher("/common/deletePost.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/posts/postDetail.jsp").forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

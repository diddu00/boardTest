package kr.or.ddit.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.posts.model.PostVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostServiceInf;

@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_code = request.getParameter("board_code");
		request.getSession().setAttribute("currentPage", board_code);
		PostServiceInf postService = PostService.getInstance();
		Map<String, Object> map = new HashMap<String, Object>();
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page = pageStr==null?1:Integer.parseInt(pageStr);
		int pageSize = pageSizeStr==null?10:Integer.parseInt(pageSizeStr);
		map.put("board_code", board_code);
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		Map<String, Object> postMap=postService.selectPostPageList(map);
		request.setAttribute("pageNavi", postMap.get("pageNavi"));
		request.setAttribute("postPageList", postMap.get("postPageList"));
		request.setAttribute("page", page);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("board_code", board_code);
		
		request.getRequestDispatcher("/posts/postList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

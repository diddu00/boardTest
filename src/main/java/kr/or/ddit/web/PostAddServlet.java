package kr.or.ddit.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.attachments.service.AttachmentService;
import kr.or.ddit.attachments.service.AttachmentServiceInf;
import kr.or.ddit.posts.model.PostVo;
import kr.or.ddit.posts.service.PostService;
import kr.or.ddit.posts.service.PostServiceInf;

/**
 * Servlet implementation class PostAddServlet
 */
@WebServlet("/postAdd")
@MultipartConfig(maxFileSize=1024*1000*7, maxRequestSize=1024*1000*15)
public class PostAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//답글
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//새글
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PostServiceInf postService = PostService.getInstance();
		PostVo postVo = new PostVo();
		postVo.setBoard_code(request.getParameter("board_code"));
		postVo.setPost_ctt(request.getParameter("smarteditor"));
		postVo.setPost_super(request.getParameter("post_super"));
		postVo.setPost_ttl(request.getParameter("post_ttl"));
		postVo.setStd_id(request.getParameter("std_id"));
		postService.insertPost(postVo);
		String post_code = postService.selectRecentPostCode();
		
		Collection<Part> parts=request.getParts();
		//--> 넘어온 파라미터들 Collection(set,list 등등)에 나눠서 넣음(배열처럼)

		for(Part part:parts ){
			AttachmentVo attachVo = new AttachmentVo();
			attachVo.setPost_code(post_code);
			String contentDisposition = part.getHeader("Content-Disposition");
			System.out.println("contentDispostion : "+contentDisposition);
			if(contentDisposition!=null){
			String fileName = FileUtil.getFileName(contentDisposition);
			
			attachVo.setAttach_nm(fileName);
			System.out.println("attach_nm : "+attachVo.getAttach_nm());
			String path = FileUtil.fileUploadPath;
			attachVo.setAttach_path(path);
			System.out.println("attach_path : "+attachVo.getAttach_path());
			//파일이 정상적인지 확인 ==> size가 0보다 클때 업로드 수행하도록
			if(part.getSize()>0){
				String file=path+File.separator+UUID.randomUUID().toString();
				attachVo.setAttach_file(file);
				
				//사용자가 업로드한 실제파일명은 디비상에 저장하고, 물리적 파일명은 임의로 적용
				part.write(file); //파일 세퍼레이터 즉 나누는 기준 windows = '\' 여튼 OS마다 다 다르기때문에 File.separator라는 녀석으로 받아온다.
				System.out.println("attach_file : "+attachVo.getAttach_file());
				postService.insertAttach(attachVo);
				//임시파일을 지워주는 것
				part.delete();
			}
			}
		}
		
		PostListServlet postListServlet = new PostListServlet();
		postListServlet.doGet(request, response);
	}

}

package kr.or.ddit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.attachments.service.AttachmentService;
import kr.or.ddit.attachments.service.AttachmentServiceInf;

@WebServlet("/attachDownload")
public class AttachDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attach_code = request.getParameter("attach_code");
		
		AttachmentServiceInf attachmentService = AttachmentService.getInstance();
		
		AttachmentVo attachVo =attachmentService.selectGetAttach(attach_code);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"thanks.png\"");
		response.setContentType("application/octet-stream");
		
		
	}

}

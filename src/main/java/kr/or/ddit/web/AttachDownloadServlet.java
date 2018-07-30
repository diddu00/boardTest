package kr.or.ddit.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
		response.setHeader("Content-Disposition", "attachment; filename=\""+attachVo.getAttach_nm()+"\"");
		response.setContentType("application/octet-stream");
		String file = attachVo.getAttach_file();
		
		//file 입출력을 위한 준비
		//outputStream
		ServletOutputStream sos = response.getOutputStream();
		
		//inputStream
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b =new byte[512];
		int len = 0;
		
		//읽고 쓰고
		while((len=fis.read(b))!=-1){
			sos.write(b,0,len);
		}
		
		//입출력 닫아주기 
		sos.close();
		fis.close();
		
	}

}

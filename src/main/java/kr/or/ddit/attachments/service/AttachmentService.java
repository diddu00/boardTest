package kr.or.ddit.attachments.service;

import java.util.List;

import kr.or.ddit.attachments.dao.AttachmentDao;
import kr.or.ddit.attachments.dao.AttachmentDaoInf;
import kr.or.ddit.attachments.model.AttachmentVo;

public class AttachmentService implements AttachmentServiceInf{
	private static AttachmentServiceInf attachmentService = new AttachmentService();
	private AttachmentDaoInf attachmentDao;
	
	private AttachmentService(){
		attachmentDao = AttachmentDao.getInstance();
	}
	
	public static AttachmentServiceInf getInstance(){
		return attachmentService;
	}



	@Override
	public boolean deleteAttach(String attach_code) {
		return attachmentDao.deleteAttach(attach_code);
	}

	@Override
	public List<AttachmentVo> selectAttachbyCode(String post_code) {
		return attachmentDao.selectAttachbyCode(post_code);
	}

	@Override
	public AttachmentVo selectGetAttach(String attach_code) {
		return attachmentDao.selectGetAttach(attach_code);
	}
	
}

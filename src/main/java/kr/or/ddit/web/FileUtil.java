package kr.or.ddit.web;

public class FileUtil {
	
	 //파일 업로드 경로
    public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload";
	
	/**
	 * 
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : part의 Contet-Disposition header로 부터 업로드 파일명을 리턴한다.
	* 
	* ex) form-data; name="uploadFile"; filename="sally.png"
	* 	  return "sally.png"
	 */
	static public String getFileName(String contentDisposition){
		String[] spiltDispositions = contentDisposition.split("; ");
		String filename = null;
		
		for (int i=0; i<spiltDispositions.length;i++) {
			String[] disposition = spiltDispositions[i].split("=");
			if(disposition[0].equals("filename")){
				filename=disposition[1].replace("\"", "");
				break;
			}
		}
		
		return filename;
	}
}

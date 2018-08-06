package kr.or.ddit.posts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.attachments.model.AttachmentVo;
import kr.or.ddit.posts.dao.PostDao;
import kr.or.ddit.posts.dao.PostDaoInf;
import kr.or.ddit.posts.model.PostVo;

public class PostService implements PostServiceInf {
	private static PostServiceInf postService = new PostService();
	private PostDaoInf postDao;

	private PostService() {
		postDao = PostDao.getInstance();
	}

	public static PostServiceInf getInstance() {
		return postService;
	}

	@Override
	public Map<String, Object> selectPostPageList(Map<String, Object> map) {
		List<PostVo>postPageList = postDao.selectPostPageList(map);
		Map<String, Object> totMap = new HashMap<String, Object>();
		String pageNavi = makePagingnation((int)map.get("page"), (int)map.get("pageSize"),(String)map.get("board_code"), postDao.selectPostTnt((String)map.get("board_code")));
		totMap.put("pageNavi", pageNavi);
		totMap.put("postPageList", postPageList);
		return totMap;
	}

	public String makePagingnation(int page, int pageSize1,String board_code ,int totCnt) {
		// 페이지 네이게이션 html 생성
		int activePage = page;
		int pageSize = pageSize1;

		int pagingnationSize = totCnt % pageSize == 0 ? totCnt / pageSize
				: totCnt / pageSize + 1;

		StringBuilder pageNavi = new StringBuilder();
		pageNavi.append("<li><a href=\"postList?board_code="+board_code+"&page=1"
				+ "&pageSize=10\" "+(activePage==1?"disabled":"")+" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNavi.append("<li><a href=\"postList?board_code="+board_code+"&page="
				+ (activePage > 1 ? activePage - 1 : 1)
				+ "&pageSize=10\" "+(activePage==1?"disabled":"")+"aria-label=\"Previous\"><span aria-hidden=\"true\">&lt;</span></a></li>");
		for (int i = 1; i <= pagingnationSize; i++) {
			String activeClass = "";
			if (i == activePage)
				activeClass = " class=\"active\"";
			// }else{
			// activeClass=""; => 요딴거 할 필요가없음.. 맨위에서 초기화 다시하니까
			// }

			pageNavi.append("<li" + activeClass
					+ "><a href=\"/postList?board_code="+board_code+"&page=" + i + "&pageSize=10\">"
					+ i + "</a></li>");
		}
		pageNavi.append("<li><a href=\"/postList?board_code="+board_code+"&page="
				+ (activePage < pagingnationSize ? activePage + 1
						: pagingnationSize)
				+ "&pageSize=10\" "+(activePage==pagingnationSize?"disabled":"")+"aria-label=\"Next\"><span aria-hidden=\"true\">&gt;</span></a></li>");
		pageNavi.append("<li><a href=\"/postList?board_code="+board_code+"&page="+pagingnationSize
				+ "&pageSize=10\" "+(activePage==pagingnationSize?"disabled":"")+" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		return pageNavi.toString();

	}

	@Override
	public boolean updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}



	@Override
	public boolean insertPost(PostVo postVo) {
		return postDao.insertPost(postVo);
	}

	@Override
	public PostVo selectGetPostbyCode(String post_code) {
		return postDao.selectGetPostbyCode(post_code);
	}
	
	@Override
	public boolean insertAttach(AttachmentVo attachVo) {
		return postDao.insertAttach(attachVo);
	}

	@Override
	public String selectRecentPostCode() {
		return postDao.selectRecentPostCode();
	}

}

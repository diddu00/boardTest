package boardProjectTest.postDaoTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.posts.dao.PostDao;
import kr.or.ddit.posts.dao.PostDaoInf;
import kr.or.ddit.posts.model.PostVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostDaoTest {
	PostDaoInf dao;
	Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	
	@Before
	public void setup(){
		dao = PostDao.getInstance();
	}
	

	public void selectPostPageListTest() {
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", 1);
		paramMap.put("pageSize", 10);
		paramMap.put("board_code", "b001");

		/***When***/
		List<PostVo> postList=dao.selectPostPageList(paramMap);
		for (PostVo postVo : postList) {
			logger.debug(postVo.toString());
		}
		/***Then***/
		
	}
	
	@Test
	public void selectGetPostbyCodeTest(){
		/***Given***/
		String post_code = "p001";

		/***When***/
		PostVo postVo = dao.selectGetPostbyCode(post_code);
		logger.debug(postVo.toString());
		/***Then***/
		

	}
	
	public void updatePostTest(){
		/***Given***/
		dao.selectGetPostbyCode("");

		/***When***/

		/***Then***/

	}

}

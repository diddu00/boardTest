package kr.or.ddit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.boards.service.BoardService;
import kr.or.ddit.boards.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		StudentVo temp = new StudentVo();
		temp.setStd_id(id);
		temp.setPass(password);
		StudentServiceInf studentService = StudentService.getInstance();
		StudentVo studentVo = studentService.loginStudent(temp);
		BoardServiceInf boardService = BoardService.getInstance();
		HttpSession session = request.getSession();
		session.setAttribute("studentVo", studentVo);
		session.setAttribute("currentPage", "main");
		session.setAttribute("useBoardList", boardService.selectUseBoard());
		if(studentVo==null){
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}else{
			response.sendRedirect("/main");			
		}
	}

}

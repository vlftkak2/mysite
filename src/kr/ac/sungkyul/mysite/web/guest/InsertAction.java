package kr.ac.sungkyul.mysite.web.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.guestbookDao;
import kr.ac.sungkyul.mysite.vo.guestbookVo;
import kr.ac.sungkyul.web.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content =request.getParameter("content");

		guestbookVo vo =new guestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setIntroduction(content);

		guestbookDao dao=new guestbookDao();
		dao.insert(vo);
		
		response.sendRedirect("/mysite/guest?a=list");
	}

}

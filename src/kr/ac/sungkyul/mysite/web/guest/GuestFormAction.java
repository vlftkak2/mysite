package kr.ac.sungkyul.mysite.web.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.guestbookDao;
import kr.ac.sungkyul.mysite.vo.guestbookVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class GuestFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		guestbookDao dao = new guestbookDao();
		List<guestbookVo> list = dao.getList();
		
		//request 범위(scope)에 객체를 저장
		request.setAttribute("mylist", list);
		
		WebUtil.forward("/WEB-INF/views/guestbook/list.jsp", request, response);
	}

}

package kr.ac.sungkyul.mysite.web.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.guestbookDao;
import kr.ac.sungkyul.mysite.vo.guestbookVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");
		String no = request.getParameter("no");

		guestbookVo vo = new guestbookVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);

		guestbookDao dao = new guestbookDao();
		boolean info = dao.delete(vo);

		if (info == true) {

			WebUtil.redirect("/mysite/guest", request, response);

		} else {

			WebUtil.redirect("/mysite/guest?a=deleteform&r=false", request, response);
		}
	}

}

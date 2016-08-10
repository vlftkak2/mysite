package kr.ac.sungkyul.mysite.web.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.dao.guestbookDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.mysite.vo.guestbookVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class listFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session == null) {

			WebUtil.redirect("/mysite/main", request, response);
			return;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		
		BoardDao dao=new BoardDao();
		List<BoardVo> list=dao.getList();
		
		request.setAttribute("list", list);
		request.setAttribute("authUser", authUser);
		
		
		
		WebUtil.forward("/WEB-INF/views/board/list.jsp", request, response);

	}

}

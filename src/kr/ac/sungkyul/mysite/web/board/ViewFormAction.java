package kr.ac.sungkyul.mysite.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class ViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session == null) {

			WebUtil.redirect("/mysite/main", request, response);
			return;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}

		// Long no=authUser.getNo();
		String no=request.getParameter("no");
		
		BoardDao dao = new BoardDao();
		BoardVo vo=dao.get(Long.parseLong(no));
		
		request.setAttribute("BoardVo", vo);
		

		WebUtil.forward("/WEB-INF/views/board/view.jsp", request, response);
	}

}

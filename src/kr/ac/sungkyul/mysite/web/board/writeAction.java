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

public class writeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		if(session==null){
			
			WebUtil.redirect("/mysite/main", request, response);
		}
		
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		if(authUser==null){
			WebUtil.redirect("/mysite/main", request, response);
		}
		
		String userNo=request.getParameter("userno");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		BoardVo vo=new BoardVo();
		vo.setUserNo(Long.parseLong(userNo));
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDao dao=new BoardDao();
		dao.insert(vo);
		
		System.out.println(vo);
		
		WebUtil.redirect("/mysite/board?a=listform", request, response);
		
		
		
	}

}

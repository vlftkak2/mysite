package kr.ac.sungkyul.mysite.web.board;

import java.io.IOException;
import java.util.function.LongPredicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class replyAction implements Action {

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
		
		String userNo=request.getParameter("userno");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String groupNo=request.getParameter("groupno");
		String depth=request.getParameter("depth");
		String orderNo=request.getParameter("orderno");
		
		Long usernumber=Long.parseLong(userNo);
		int groupnumber=Integer.parseInt(groupNo);
		int depthlength=Integer.parseInt(depth)+1;
		int ordernumber=Integer.parseInt(orderNo)+1;
		
		BoardVo vo=new BoardVo();
		vo.setUserNo(usernumber);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setGroupNo(groupnumber);
		vo.setDepth(depthlength);
		vo.setGroupOrderNo(ordernumber);
		
		BoardDao dao=new BoardDao();
		System.out.println(vo);
		dao.updatereplyCount(groupnumber, ordernumber);		
		
		dao.insert(vo);
		
		WebUtil.redirect("/mysite/board?a=listform", request, response);

	}

}

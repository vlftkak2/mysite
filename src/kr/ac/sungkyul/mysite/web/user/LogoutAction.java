package kr.ac.sungkyul.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* logout 처리 */
		HttpSession session = request.getSession();
		if (session!= null) {
			
			session.removeAttribute("authUser");
			session.invalidate(); //기존에 쓰고있던 세션 객체를 다른 객체로 바꿔라.
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}

		WebUtil.redirect("/mysite/main", request, response);

	}

}

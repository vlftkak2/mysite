package kr.ac.sungkyul.mysite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.web.guest.GuestActionFactory;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

/**
 * Servlet implementation class GuestServlet
 */
@WebServlet("/guest")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");

			String actionName = request.getParameter("a");

			ActionFactory af = new GuestActionFactory();
			Action action = af.getAction(actionName);
			action.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

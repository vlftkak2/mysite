package kr.ac.sungkyul.mysite.web.user;

import kr.ac.sungkyul.mysite.web.main.MainAction;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action = null;
		if ("joinform".equals(actionName)) {

			action = new JoinFormAction();
			return action;
		} else if ("join".equals(actionName)) {

			action = new JoinAction();
			return action;

		} else if ("joinsuccess".equals(actionName)) {
			action = new JoinSuccess();
			return action;

		} else if ("loginform".equals(actionName)) {

			action = new LoginFormAction();
			return action;

		} else if ("login".equals(actionName)) {
			
			action = new LoginAction();
			return action;
			
		}else if("logout".equals(actionName)){
			action=new LogoutAction();
			return action;
			
		}else if("modifyform".equals(actionName)){
			action=new ModifyFormAtion();
			return action;
		}else if("modify".equals(actionName)){
			action=new ModifyAction();
			return action;
		}
		
		
		else {
			action = new MainAction();
			return action;
		}
	}

}

package kr.ac.sungkyul.mysite.web.guest;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class GuestActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action=null;
		if("list".equals(actionName)){
			
			action=new GuestFormAction();
			return action;
		}else if("insert".equals(actionName)){
			action =new InsertAction();
			return action;
		}else if("delete".equals(actionName)){
			action =new DeleteAction();
			return action;
		}else if("deleteform".equals(actionName)){
			action = new DeleteFormAction();
		}
		
		else{
			action = new MyAction();
			
		}
		
		return action;
	}

}

package kr.ac.sungkyul.mysite.web.board;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action=null;
		
		if("viewform".equals(actionName)){
			action=new ViewFormAction();
		}else if("writeform".equals(actionName)){
			action=new WriteFormAction();
		}else if("modifyform".equals(actionName)){
			action=new modifyFormAction();
		}else if("modify".equals(actionName)){
			action=new modifyAction();
		}else if("write".equals(actionName)){
			action=new writeAction();
		}else if("delete".equals(actionName)){
			action=new deleteAction();
		}else if("search".equals(actionName)){
			action=new searchAction();
		}else if("replyform".equals(actionName)){
			action=new replyFormAction();
		}else if("reply".equals(actionName)){
			action=new replyAction();
		}else if("search".equals(actionName)){
			action=new searchAction();
		}else{
			action=new listFormAction();
		}	
		return action;
	}

}

package LoginView;

import AdminView.View;
import CafeManagement.Manager;
import Menu.Menu;
import User.Login;
import User.User;

public class MyMenuView implements View{

	@Override
	public int view(Manager manager, User user) throws Exception {
		if(null == manager)
			throw new Exception("[Error]null == manager");
		
		if(null == user)
			throw new Exception("[Error]null == user");

		Login login = (Login)user;
		if(null == login)
			throw new Exception("[Error]null == login");
		
		Menu myMenu = login.getMyMenu();
		if(null == myMenu)
			System.out.println("myMenu가 없습니다");
		else
			System.out.println("myMenu 이름:"+myMenu.getName()+"\n가격:"+myMenu.getPrice());
		return 0;
	}

}

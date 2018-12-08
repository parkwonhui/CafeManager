package LoginView;

import AdminView.View;
import CafeManagement.Manager;
import Menu.Menu;
import User.User;

public class MenuSeasonView extends View{

	@Override
	public int view(Manager manager, User user) throws Exception {
		super.menuProcess(manager, user, Menu.MENUTYPE_SEASON);
		return 0;
	}
}

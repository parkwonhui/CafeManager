package GuestView;

import AdminView.View;
import CafeManagement.Manager;
import Menu.Menu;
import User.User;

public class MenuDessertView extends View{

	@Override
	public int view(final Manager manager, final User user) throws Exception {
		super.menuProcess(manager, user, Menu.MENUTYPE_DESSERT);
		return 0;
	}
}

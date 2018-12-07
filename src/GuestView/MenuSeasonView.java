package GuestView;

import AdminView.View;
import CafeManagement.Manager;
import Info.InfoManager;
import Menu.Coffee;
import Menu.Dessert;
import Menu.Menu;
import ScannerManager.ScannerManager;
import User.User;

public class MenuSeasonView extends View{

	@Override
	public int view(final Manager manager, final User user) throws Exception {		
		super.menuProcess(manager, user, Menu.MENUTYPE_SEASON);
	
		return 0;
		
	}
}

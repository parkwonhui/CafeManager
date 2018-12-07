package LoginView;

import AdminView.View;
import CafeManagement.Manager;
import Info.InfoManager;
import Menu.Coffee;
import Menu.Dessert;
import Menu.Menu;
import Save.SaveManager;
import ScannerManager.ScannerManager;
import User.User;

public class MenuDessertView extends View{
	@Override
	public int view(Manager manager, User user) throws Exception {
		super.menuProcess(manager, user, Menu.MENUTYPE_DESSERT);
		
		return 0;
	}
}

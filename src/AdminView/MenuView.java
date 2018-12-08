package AdminView;

import CafeManagement.Manager;
import Info.InfoManager;
import User.User;

public class MenuView extends View {

	@Override
	public int view(final Manager manager, final User user) throws Exception{
		InfoManager.getInst().allPrint();
		return 1;
	}
}

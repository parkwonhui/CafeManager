package AdminView;

import CafeManagement.Manager;
import Info.InfoManager;
import User.User;

public class AdminMenuCountView implements View{

	@Override
	public int view(final Manager manager, final User user) throws Exception{
		InfoManager.getInst().PrintStock();
		return 0;		
	}
}

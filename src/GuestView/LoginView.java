package GuestView;

import AdminView.View;
import CafeManagement.Manager;
import User.User;

public class LoginView extends View{

	@Override
	public int view(final Manager manager, final User user) throws Exception {
		return 1;		
	}
}

package AdminView;

import CafeManagement.Manager;
import User.User;

public interface View {
	int view(final Manager manager, final User user) throws Exception;
}

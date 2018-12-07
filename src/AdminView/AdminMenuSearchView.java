package AdminView;

import CafeManagement.Manager;
import Info.InfoManager;
import ScannerManager.ScannerManager;
import User.Login;
import User.User;

public class AdminMenuSearchView extends View{

	@Override
	public int view(final Manager manager, final User user) throws Exception{
		System.out.println("유저의 id를 입력해주세요");
		String name = ScannerManager.ReadString();
		
		// 유저가 좋아하는 메뉴를 출력하기 위해 user+userInfo를 합쳐야 한다
		User user1 = InfoManager.getInst().searchUser(name);
		if(null == user1)
			throw new Exception("유저를 찾을 수 없습니다");
		
		if(user1 instanceof Login){
			Login login = (Login)user1;
			login.printInfo();
		}

		return 0;
	}
}

package GuestView;

import AdminView.View;
import CafeManagement.Manager;
import Save.SaveManager;
import User.User;

public class MenuPayView extends View{

	@Override
	public int view(final Manager manager, final User user) throws Exception {
		if(null == manager)
			throw new Exception("[error]null == manager");
		
		final SaveManager saveManager = manager.GetSaveManager();
		if(null == saveManager)
			throw new Exception("[error]null == saveManager");			// 에러 시 몇번째 위치에서 에러인지 출력하는 함수 없나?
		
		saveManager.calAllMenu();   // 전체 계산
		saveManager.deleteAllMenu();// 출력 후 초기화
	
		return 0;
	}


}

package AdminView;

import CafeManagement.Manager;
import ScannerManager.ScannerManager;
import User.User;

public class MainCategoryView implements View{

	@Override
	public int view(final Manager manager, final User user) throws Exception{
		System.out.println("[관리자모드/매장관리] 1.메뉴추가 2.메뉴수정 3.메뉴삭제 4.회원검색 5.재고관리 6.매출 7.로그아웃");
		System.out.println("========================================================================");
		int value = ScannerManager.ReadInt();
		switch(value){
			case 1 : return User.INPUT_TYPE.ADMIN_MENU_ADD.getType();
			case 2 : return User.INPUT_TYPE.ADMIN_MENU_MODIFY.getType();
			case 3 : return User.INPUT_TYPE.ADMIN_MENU_DELETE.getType();
			case 4 : return User.INPUT_TYPE.ADMIN_MENU_SEARCH.getType();
			case 5 : return User.INPUT_TYPE.ADMIN_MENU_COUNT.getType();
			case 6 : return User.INPUT_TYPE.MENU_VIEW.getType();
			case 7 : return User.INPUT_TYPE.LOGOUT.getType();
			default : return 0;
		}

	}
}

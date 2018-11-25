package GuestView;

import AdminView.View;
import CafeManagement.Manager;
import ScannerManager.ScannerManager;
import User.User;

public class MainCategoryView implements View{

	@Override
	public int view(final Manager manager, final User user) throws Exception {
		System.out.println("EDIE Coffee에 방문하신 손님을 환영합니다");		
		System.out.println("1.음료 2.시즌메뉴 3.디저트 4.계산 5.로그인 6.회원가입");
		System.out.println("====================================");
		int value = ScannerManager.ReadInt();
		switch(value){
			case 1 : return User.INPUT_TYPE.MENU_COFFEE.getType();
			case 2 : return User.INPUT_TYPE.MENU_SEASON.getType();
			case 3 : return User.INPUT_TYPE.MENU_DESSERT.getType();
			case 4 : return User.INPUT_TYPE.MENU_PAY.getType();
			case 5 : return User.INPUT_TYPE.LOGIN.getType();		
			case 6 : return User.INPUT_TYPE.JOIN.getType();
			default : return 0;
		}
	}
}

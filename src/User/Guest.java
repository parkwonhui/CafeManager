package User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GuestView.LoginView;
import GuestView.LogoutView;
import GuestView.MenuCoffeeView;
import GuestView.MenuDessertView;
import GuestView.MenuPayView;
import AdminView.View;
import CafeManagement.Manager;
import GuestView.JoinView;
import Info.InfoManager;
import LoginView.MenuSeasonView;
import Menu.Coffee;
import Menu.Dessert;
import Menu.Menu;
import ScannerManager.ScannerManager;

public class Guest extends User{

	HashMap<Integer, View> viewList;
	
	public Guest(){
		viewList = new HashMap<>();
		viewList.put(User.INPUT_TYPE.JOIN.getType(), 				new JoinView());
		viewList.put(User.INPUT_TYPE.LOGIN.getType(), 				new LoginView());
		viewList.put(User.INPUT_TYPE.LOGOUT.getType(), 				new LogoutView());
		viewList.put(User.INPUT_TYPE.MENU_COFFEE.getType(), 		new MenuCoffeeView());
		viewList.put(User.INPUT_TYPE.MENU_DESSERT.getType(), 		new MenuDessertView());
		viewList.put(User.INPUT_TYPE.MENU_SEASON.getType(), 		new MenuSeasonView());
		viewList.put(User.INPUT_TYPE.MENU_PAY.getType(), 			new MenuPayView());
	}

	public View getProcess(int index) {
		Set set = viewList.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, View> temp = (Map.Entry<Integer, View>)iter.next();
			if(index == temp.getKey())
				return temp.getValue();
		}
		
		return null;
	}

	
	@Override
	public INPUT_TYPE mainMenu()  throws Exception{
		System.out.println("EDIE Coffee에 방문하신 손님을 환영합니다");		
		System.out.println("1.음료 2.시즌메뉴 3.디저트 4.계산 5.로그인 6.회원가입");
		System.out.println("====================================");
		int value = ScannerManager.ReadInt();
		switch(value){
			case 1 : return User.INPUT_TYPE.MENU_COFFEE;
			case 2 : return User.INPUT_TYPE.MENU_SEASON;
			case 3 : return User.INPUT_TYPE.MENU_DESSERT;
			case 4 : return User.INPUT_TYPE.MENU_PAY;
			case 5 : return User.INPUT_TYPE.LOGIN;		
			case 6 : return User.INPUT_TYPE.JOIN;
			default : return null;
		}
	}

	@Override
	public boolean login() throws Exception {
		return true;
	}

	@Override
	public boolean logout()  throws Exception{
		return false;	
	}
	
	// guest는 비밀번호와 상관없다
	public boolean isPassEquals(String pass) {
		return false;
	}
}

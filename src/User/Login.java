package User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import AdminView.View;
import CafeManagement.Manager;
import Info.InfoManager;
import Info.UserInfo;
import LoginView.LoginView;
import LoginView.LogoutView;
import LoginView.MenuCoffeeView;
import LoginView.MenuDessertView;
import LoginView.MenuPayView;
import LoginView.MenuSeasonView;
import LoginView.MyMenuModifyView;
import LoginView.MyMenuView;
import Menu.Coffee;
import Menu.Dessert;
import Menu.Menu;
import ScannerManager.ScannerManager;
import User.User.INPUT_TYPE;

public class Login extends User {
	
	// 마이메뉴
	private Menu myMenu;
	private UserInfo userInfo;
	Map<Integer, View> viewList;
	
	
	public Login(UserInfo user){
		myMenu = null;
		this.userInfo = user;
		
		viewList = new HashMap<>();
		viewList.put(User.INPUT_TYPE.LOGIN.getType(), 				new LoginView());
		viewList.put(User.INPUT_TYPE.LOGOUT.getType(), 				new LogoutView());
		viewList.put(User.INPUT_TYPE.MENU_COFFEE.getType(), 		new MenuCoffeeView());
		viewList.put(User.INPUT_TYPE.MENU_DESSERT.getType(), 		new MenuDessertView());
		viewList.put(User.INPUT_TYPE.MENU_SEASON.getType(), 		new MenuSeasonView());
		viewList.put(User.INPUT_TYPE.MENU_PAY.getType(), 			new MenuPayView());
		viewList.put(User.INPUT_TYPE.MY_MENU.getType(), 			new MyMenuView());
		viewList.put(User.INPUT_TYPE.MY_MENU_MODIFY.getType(), 		new MyMenuModifyView());
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

	public void SetMyMenu(Menu menu) throws Exception{
		myMenu = menu;	
	}
	
	@Override
	public INPUT_TYPE mainMenu() throws Exception {
		System.out.println("EDIE Coffee에 방문하신 "+userInfo.getId()+" 님을 환영합니다");
		System.out.println("[유저모드/메뉴] 1.음료 2.시즌메뉴 3.디저트 4.마이메뉴 5.마이메뉴 수정 6.결제 7.로그아웃");
		System.out.println("===============================================");
		int value = ScannerManager.ReadInt();
		switch(value){
			case 1 : return User.INPUT_TYPE.MENU_COFFEE;
			case 2 : return User.INPUT_TYPE.MENU_SEASON;
			case 3 : return User.INPUT_TYPE.MENU_DESSERT;
			case 4 : return User.INPUT_TYPE.MY_MENU;
			case 5 : return User.INPUT_TYPE.MY_MENU_MODIFY;
			case 6 : return User.INPUT_TYPE.MENU_PAY;
			case 7 : return User.INPUT_TYPE.LOGOUT;
			default : return null;
		}
	}

	@Override
	public boolean login() throws Exception {
		return false;
	}

	@Override
	public boolean logout() throws Exception {
		return true;	
	}
	
	public void printInfo(){
		System.out.print("id:"+userInfo.getId());
		
		if(null != myMenu)
			System.out.println(" myMenu:"+myMenu.getName()+"("+myMenu.getPrice()+")");
		else
			System.out.println(" myMenu가 없습니다");
	}
	
	public boolean isPassEquals(final String pass) {
		if(true == pass.equals(userInfo.getPass()))
			return true;

		return false;
	}
	
	public boolean checkInputMenu(final int index, final int menuType) throws Exception{
		Menu menu = InfoManager.getInst().searchMenu(index);
		if(menuType != menu.getType())
			return false;
		
		return true;
	}
	
	public String getId(){
		return userInfo.getId();
	}
	
	public String getPass(){
		return userInfo.getPass();
	}	
	
	public Menu getMyMenu() {
		return myMenu;
	}
}

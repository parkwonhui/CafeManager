package User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import CafeManagement.Manager;
import Info.InfoManager;
import Info.UserInfo;
import Menu.Coffee;
import Menu.Dessert;
import Menu.Menu;
import ScannerManager.ScannerManager;
import User.User.INPUT_TYPE;
import AdminView.AdminMenuAddView;
import AdminView.AdminMenuCountView;
import AdminView.AdminMenuDeleteView;
import AdminView.AdminMenuModifyView;
import AdminView.AdminMenuSearchView;
import AdminView.LoginView;
import AdminView.LogoutView;
import AdminView.MenuView;
import AdminView.View;;
public class Admin extends User{
	
	private UserInfo userInfo;
	HashMap<Integer, View> viewList;
	
	public Admin(UserInfo user){
		this.userInfo = user;
		viewList = new HashMap<>();
		viewList.put(User.INPUT_TYPE.LOGIN.getType(), 				new LoginView());
		viewList.put(User.INPUT_TYPE.LOGOUT.getType(), 				new LogoutView());
		viewList.put(User.INPUT_TYPE.ADMIN_MENU_ADD.getType(), 		new AdminMenuAddView());
		viewList.put(User.INPUT_TYPE.ADMIN_MENU_MODIFY.getType(), 	new AdminMenuModifyView());
		viewList.put(User.INPUT_TYPE.ADMIN_MENU_DELETE.getType(), 	new AdminMenuDeleteView());
		viewList.put(User.INPUT_TYPE.ADMIN_MENU_SEARCH.getType(), 	new AdminMenuSearchView());
		viewList.put(User.INPUT_TYPE.ADMIN_MENU_COUNT.getType(), 	new AdminMenuCountView());
		viewList.put(User.INPUT_TYPE.MENU_VIEW.getType(), 			new MenuView());
		
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
	public INPUT_TYPE mainMenu() throws Exception{
		System.out.println("[관리자모드/매장관리] 1.메뉴추가 2.메뉴수정 3.메뉴삭제 4.회원검색 5.재고관리 6.매출 7.로그아웃");
		System.out.println("========================================================================");
		int value = ScannerManager.ReadInt();
		switch(value){
			case 1 : return User.INPUT_TYPE.ADMIN_MENU_ADD;
			case 2 : return User.INPUT_TYPE.ADMIN_MENU_MODIFY;
			case 3 : return User.INPUT_TYPE.ADMIN_MENU_DELETE;
			case 4 : return User.INPUT_TYPE.ADMIN_MENU_SEARCH;
			case 5 : return User.INPUT_TYPE.ADMIN_MENU_COUNT;
			case 6 : return User.INPUT_TYPE.MENU_VIEW;
			case 7 : return User.INPUT_TYPE.LOGOUT;
			default : return null;
		}
	}
	
	public void viewMenu() throws Exception{
		InfoManager.getInst().allPrint();
	}


	@Override
	public boolean login() throws Exception{
		return false;
	}

	@Override
	public boolean logout() throws Exception{
		return true;	
	}

/*
	@Override
	public Menu menuChoice(int menutype){return null;}
	
	@Override
	public void myMenuPrint() throws Exception{}
	@Override
	public void myMenuModify() throws Exception{}

	@Override
	public void adminMenuAdd() throws Exception{
		 System.out.println("메뉴 이름 :");
		 String name = ScannerManager.ReadString();
		 System.out.println("메뉴 가격 :");
		 int price = ScannerManager.ReadInt();
		 System.out.println("메뉴 타입 (0:음료 1:시즌 2:디저트):");
		 int type = ScannerManager.ReadInt();
		 int discount = 100;
		 if(Menu.MENUTYPE_DESSERT == type) {
			 System.out.println("메뉴 할인(90%할인일 시 90):");
		 	 discount = ScannerManager.ReadInt();
		 }
		 
		 int index =  InfoManager.getInst().getMenuDataSize();		 
		 InfoManager.getInst().addMenu(index, name, price, discount, type);

		 // 메뉴추가 시 파일 저장
		 InfoManager.getInst().saveMenu();
		 System.out.println("[system]메뉴가 추가되었습니다");
	}

	@Override
	public void adminMenuModify() throws Exception{
		InfoManager.getInst().allPrint();
		int index = ScannerManager.ReadInt();
		
		Menu menu = InfoManager.getInst().searchMenu(index);
		System.out.println("index:"+menu.getIndex()+"name:"+menu.getName());
		if(null == menu){
			throw new Exception("메뉴를 찾을 수 없습니다");
		}
		System.out.println("이름 입력");
		String name = ScannerManager.ReadString();
		System.out.println("가격 입력");
		int price  = ScannerManager.ReadInt();
		System.out.println("타입 입력");		
		int type  = ScannerManager.ReadInt();
		int discount = 100;
		if(Menu.MENUTYPE_DESSERT == menu.getType()){
			System.out.println("할인율 입력");
			discount  = ScannerManager.ReadInt();
		}
		
		menu.modifyMenuInfo(name, price, type);

		if(Menu.MENUTYPE_DESSERT == menu.getType()){
			Dessert dessert = (Dessert)menu;
			dessert.setDiscount(discount);
		}
	}

	@Override
	public void adminMenuDelete() throws Exception{
		InfoManager.getInst().allPrint();
		System.out.println("삭제할 메뉴 index를 입력해주세요");
		int index = ScannerManager.ReadInt();
		
		InfoManager.getInst().deleteMenu(index);
	}

	@Override
	public void adminUserSearch() throws Exception{
		System.out.println("유저의 id를 입력해주세요");
		String name = ScannerManager.ReadString();
		
		// 유저가 좋아하는 메뉴를 출력하기 위해 user+userInfo를 합쳐야 한다
		User user = InfoManager.getInst().searchUser(name);
		if(null == user)
			throw new Exception("유저를 찾을 수 없습니다");
		
		if(user instanceof Login){
			Login login = (Login)user;
			login.printInfo();
		}
	}
	
	
	public void join() throws Exception{}*/

	//@Override
	public void adminMenuCount() throws Exception{
		InfoManager.getInst().PrintStock();
	}
	
	public boolean isPassEquals(String pass) {	
		if(true == pass.equals(userInfo.getPass()))
			return true;

		return false;
	}
	
	public String getId(){
		return userInfo.getId();
	}
	
	public String getPass(){
		return userInfo.getPass();
	}

}

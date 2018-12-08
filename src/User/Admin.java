package User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import Info.InfoManager;
import Info.UserInfo;
import ScannerManager.ScannerManager;
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

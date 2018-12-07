package LoginView;

import AdminView.View;
import CafeManagement.Manager;
import Info.InfoManager;
import Menu.Coffee;
import Menu.Menu;
import ScannerManager.ScannerManager;
import User.Login;
import User.User;

public class MyMenuModifyView extends View{

	@Override
	public int view(Manager manager, User user) throws Exception {
		if(null == user)
			throw new Exception("");
		System.out.println("MyMenu를 선택하세요(숫자입력)");
		int size = InfoManager.getInst().getMenuDataSize();
		for(int i = 0; i < size; ++i){
			Menu menu = InfoManager.getInst().searchMenu(i);
			if(menu instanceof Coffee){
				System.out.println(menu.getIndex()+"."+menu.getName());
			}
		}
		
		int index = ScannerManager.ReadInt();
		
		Menu newMyMenu = InfoManager.getInst().searchMenu(index);
		if(null == newMyMenu)
			throw new Exception("없는 메뉴를 선택하였습니다");
		
		if(Menu.MENUTYPE_COFFEE != newMyMenu.getType())
			throw new Exception("음료가 아닙니다");	
		
		Login login = (Login)user;
		System.out.println("새로운 MyMenu"+newMyMenu.getName()+"를 등록했습니다");
		login.SetMyMenu(newMyMenu);
		
		return 0;
	}

}

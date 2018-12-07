package AdminView;

import CafeManagement.Manager;
import Info.InfoManager;
import Menu.Menu;
import ScannerManager.ScannerManager;
import User.User;

public class AdminMenuAddView extends View{
	@Override
	public int view(final Manager manager, final User user) throws Exception{
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
		 
		 return 0;
	}
}

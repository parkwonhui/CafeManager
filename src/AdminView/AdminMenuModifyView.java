package AdminView;

import CafeManagement.Manager;
import Info.InfoManager;
import Menu.Dessert;
import Menu.Menu;
import ScannerManager.ScannerManager;
import User.User;

public class AdminMenuModifyView implements View {

	@Override
	public int view(final Manager manager, final User user) throws Exception{
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
		
		return 0;
		
	}
}

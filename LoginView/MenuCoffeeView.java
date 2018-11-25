package LoginView;

import AdminView.View;
import CafeManagement.Manager;
import Info.InfoManager;
import Menu.Coffee;
import Menu.Dessert;
import Menu.Menu;
import Save.SaveManager;
import ScannerManager.ScannerManager;
import User.User;

public class MenuCoffeeView implements View{
	
	@Override
	public int view(Manager manager, User user) throws Exception {
		if(null == manager)
			throw new Exception("null == manager");
		
		SaveManager saveManager = manager.GetSaveManager();
		if(null == saveManager)
			throw new Exception("null == manager");
			
		int menutype = Menu.MENUTYPE_COFFEE;
		Menu menu =user.menuChoice(menutype);	// 커피메뉴(논커피도 있지만 일단 네임을 이렇게 만든다)
		if(null == menu){
			throw new Exception("메뉴 번호를 잘못 입력하였습니다");
		}
		
		// 메뉴 갯수 체크
		if(0 >= menu.getStockNum()){
			System.out.println("[System] 재고가 남지 않았습니다");
			return 0;				
		}
		
		// 장바구니 최대 개수 체크
		if(true == saveManager.isFull()){
			System.out.println("[System] 최대 담을 수 있는 개수"+saveManager.MAX_SAVE+"를 넘었습니다");
			return 0;
		}
		// 구매성공이므로

		// 금액을 올려주고
		manager.addTotalMoney(menu.getPrice());
		
		Menu findMenu = InfoManager.getInst().searchMenu(menu.getIndex());
		if(null == findMenu) {
			return 0;
		}
		
		// 수량을 뺀다
		findMenu.minusOneStockNum();

		// 장바구니에 넣는다
		saveManager.saveMenu(menu);
		System.out.println("[Success]구매완료");
		saveManager.allPrint();
		
		return 0;
	}

	public Menu menuChoice(int menutype) throws Exception{
		Menu fineMenu = null;
		int choiceCategory = inputMenu(menutype);
		if(-1 == choiceCategory){
			return null;
		}
		
		Menu findMenu = InfoManager.getInst().searchMenu(choiceCategory);
		Menu newMenu = null;
		// 생성 정리해야할듯..(팩토리매니저만들까?)
		if(Menu.MENUTYPE_COFFEE == findMenu.getType()||
				Menu.MENUTYPE_SEASON == findMenu.getType()){
			newMenu = new Coffee(findMenu.getIndex(), findMenu.getName(), findMenu.getStockNum(), findMenu.getPrice(), findMenu.getType());
			addOption((Coffee)newMenu);
	
		}else if(Menu.MENUTYPE_DESSERT == findMenu.getType()){
			Dessert findMenutoDessert = (Dessert)findMenu;
			newMenu = new Dessert(findMenu.getIndex(), findMenu.getName(), findMenu.getStockNum(), findMenu.getPrice(), findMenu.getType(), findMenutoDessert.getDiscount());
		}
		
		return newMenu;
	}
	
	public int inputMenu(int menutype) throws Exception{
		// TODO: 시간될 때 분류별로 체크해서 출력하는 코드 추가할 것
		if(Menu.MENUTYPE_COFFEE == menutype)
			InfoManager.getInst().allCoffeePrint();
		else if(Menu.MENUTYPE_SEASON == menutype)
			InfoManager.getInst().allSeasonPrint();
		else if(Menu.MENUTYPE_DESSERT == menutype)
			InfoManager.getInst().allDessertPrint();
		else
			return -1;
	
		int index = ScannerManager.ReadInt();
		
		// 입력 범위 체크
		if(false == checkInputMenu(index, menutype))
			index = -1;

		
		return index;
	}
	
	public void addOption(Coffee coffee) throws Exception{
		boolean bSizeup 		= false; 	// 사이즈업
		boolean bAddShot	 	= false; 	// 샷추가
		boolean bWhippedCream	= false;	// 휘핑추가
		boolean bSyrup			= false;	// 시럽

		System.out.print("[옵션추가] 사이즈 업?(0:No 1:Yes)");
		bSizeup = (1 == ScannerManager.ReadInt() ? true:false);

		System.out.print("[옵션추가] 샷추가?(0:No 1:Yes)");
		bAddShot = (1 == ScannerManager.ReadInt() ? true:false);

		System.out.print("[옵션추가] 휘핑추가?(0:No 1:Yes)");
		bWhippedCream = (1 == ScannerManager.ReadInt() ? true:false);
		
		System.out.print("[옵션추가] 시럽추가?(0:No 1:Yes)");
		bSyrup = (1 == ScannerManager.ReadInt() ? true:false);
		
		coffee.setOption(bSizeup, bAddShot, bWhippedCream, bSyrup);
	}
	
	public boolean checkInputMenu(final int index, final int menuType) throws Exception{
		Menu menu = InfoManager.getInst().searchMenu(index);
		if(menuType != menu.getType())
			return false;
		
		return true;
	}

}

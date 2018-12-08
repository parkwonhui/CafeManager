package CafeManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AdminView.View;
import Info.InfoManager;
import Menu.Coffee;
import Menu.Menu;
import Menu.NonCoffee;
import User.User;
import User.User.INPUT_TYPE;
import User.User.LOGIN_STATE;
import Menu.Dessert;
import Save.SaveManager;
import ScannerManager.ScannerManager;

public class Manager {
	
	// 장바구니
	private SaveManager saveManager;
	private int	totalMoney;		// 총 판매 금액
	
	public Manager() {
		saveManager = new SaveManager();
		totalMoney = 0;
	}
	
	// 메뉴입력을 받음, 로그인 성공 시 로그인 클래스에서 유저를 생성하고 넘겨줌
	public LOGIN_STATE start(final User user) {		
	
		while (true) {
			try {
				INPUT_TYPE inputType = user.mainMenu(); // 메인메뉴를 보여줌과 동시에 사용자
														// 입력을 받는 함수
				if (true == isLogout(user, inputType)) // 로그아웃일 때 빼져나온다
					return LOGIN_STATE.LOGOUT;
				
				if(true == isLogin(user, inputType)) {
					return LOGIN_STATE.LOGIN;
				}
				
				View view = user.getProcess(inputType.getType());
				if(null == view)
					continue;
				
				view.view(this, user);
				
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하였습니다");
			}
		}
		
		// NOT WHILE BREAK, NO RETURN
	}
	
	public boolean isLogout(final User user, final INPUT_TYPE inputype) throws Exception {
		if(INPUT_TYPE.LOGOUT != inputype)
			return false;
		
		return user.logout();
	}
	
	public boolean isLogin(final User user, final INPUT_TYPE inputype) throws Exception {
		if(INPUT_TYPE.LOGIN != inputype) {
			return false;
		}
		
		return user.login();
	}
	
	public void addTotalMoney(final int money){
		totalMoney+=money;
	}
	
	public final int getTotalMoney(){
		return totalMoney;
	}
	
	public final SaveManager GetSaveManager() {
		return saveManager;
	}
	
	
}

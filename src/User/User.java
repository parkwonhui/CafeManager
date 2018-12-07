package User;

import AdminView.View;
import Menu.Menu;

public abstract  class User {
	
	public enum INPUT_TYPE{
		
		MAIN_CATEGORY(100),	// 메뉴고르기, 매장관리
		LOGIN(101),				// Login
		LOGOUT(102),				// Logout
		MENU_COFFEE(103),		// 커피
		MENU_SEASON(104),		// 시즌
		MENU_DESSERT(105),		// 디저트
		MENU_CHOICE(106),		// 안씀
		MENU_VIEW(107),			// 관리자만 보는 것(전체 메뉴보기)
		MENU_PAY(108),			// 메뉴 선택완료. 계산
		MY_MENU(109),			// 마이메뉴
		MY_MENU_MODIFY(110),		// 마이메뉴 수정
		ADMIN_MENU_ADD(111),		// 메뉴 추가
		ADMIN_MENU_MODIFY(112),	// 메뉴 수정
		ADMIN_MENU_DELETE(113),	// 메뉴삭제
		ADMIN_MENU_SEARCH(114),	// 회원검색
		ADMIN_MENU_COUNT(115),	// 재고보기
		JOIN(116);				// 회원가입
		
		private final int type;
		private INPUT_TYPE(int type) {
			this.type = type;
		}
		
		public int getType() {
			return type;
		}
		
	};
	
	public enum LOGIN_STATE{
		LOGIN,				// LoginLogout 함수에서 쓰이는 로그인, 로그아웃 결과
		LOGOUT,
	};

	public static final int TYPE_LOGIN = 0;
	public static final int TYPE_ADMIN = 1;

	
	public abstract INPUT_TYPE mainMenu() throws Exception;
	public abstract View getProcess(int index) throws Exception;
	public abstract boolean login() throws Exception;
	public abstract boolean logout() throws Exception;					// 결과값으로 로그아웃되면 manager roop를 벗어난다

	public abstract boolean isPassEquals(final String pass); 
}

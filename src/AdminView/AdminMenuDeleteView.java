package AdminView;

import CafeManagement.Manager;
import Info.InfoManager;
import ScannerManager.ScannerManager;
import User.User;

public class AdminMenuDeleteView extends View {

	@Override
	public int view(final Manager manager, final User user) throws Exception {
		InfoManager.getInst().allPrint();
		System.out.println("삭제할 메뉴 index를 입력해주세요");
		int index = ScannerManager.ReadInt();

		InfoManager.getInst().deleteMenu(index);

		return 0;
	}
}

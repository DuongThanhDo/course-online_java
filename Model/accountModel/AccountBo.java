package accountModel;

import java.util.ArrayList;

public class AccountBo {
	AccountDao adao = new AccountDao();
	ArrayList<Account> ds;

	public ArrayList<Account> getAllAccounts(int page, int pageSize, String searchValue, Integer role, Boolean locked)
			throws Exception {
		ds = adao.getAllAccounts(page, pageSize, searchValue, role, locked);
		return ds;
	}
	
	public ArrayList<Account> getNewestAccounts() throws Exception {
		return adao.getNewestAccounts();
	}

	public int count(String searchValue, Integer role, Boolean locked) throws Exception {
		return adao.count(searchValue, role, locked);
	}

	public int updateLock(int user_id, Boolean locked) throws Exception {
		return adao.updateLock(user_id, locked);
	}
}

package userModel;

public class UserBo {
	UserDao ud = new UserDao();
	
	public User login(String username, String password) throws Exception {
		return ud.login(username, password);
	}
	
	public int register(String username, String password, int role) throws Exception {
		return ud.register(username, password, role);
	}

	public boolean isUsernameExists(String username) throws Exception {
		return ud.isUsernameExists(username);
	}
}

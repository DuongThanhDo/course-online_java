package accountModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectModel.Connect;

public class AccountDao {
	public ArrayList<Account> getAllAccounts(int page, int pageSize, String searchValue, Integer role, Boolean locked)
			throws Exception {
		ArrayList<Account> ds = new ArrayList<>();

		Connect kn = new Connect();
		kn.connectDB();

		String roleCondition = (role == null) ? "1=1" : "role = ?";
		String lockedCondition = (locked == null) ? "1=1" : "locked = ?";

		String sql = "select * " + "from ( " + "    select *, ROW_NUMBER() over (order by user_id) as RowNumber  "
				+ "    from VAdminManagerAcounts " + "where (username like ? or full_name like ?) and " + roleCondition
				+ " and " + lockedCondition + ") as t " + "where (? = 0) "
				+ "or (RowNumber between (? - 1) * ? + 1 and ? * ?) " + "order by RowNumber";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (role != null) {
			cmd.setInt(paramIndex++, role);
		}
		if (locked != null) {
			cmd.setBoolean(paramIndex++, locked);
		}
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);
		cmd.setInt(paramIndex++, page);
		cmd.setInt(paramIndex++, pageSize);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int user_id = rs.getInt("user_id");
			String username = rs.getString("username");
			String full_name = rs.getString("full_name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			int roleResult = rs.getInt("role");
			boolean lockedResult = rs.getBoolean("locked");

			Account account = new Account(user_id, username, full_name, email, phone, address, roleResult,
					lockedResult);
			ds.add(account);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<Account> getNewestAccounts() throws Exception {
	    ArrayList<Account> ds = new ArrayList<>();
	    
	    Connect kn = new Connect();
	    kn.connectDB();

	    String sql = "select top 4 * from VAdminManagerAcounts order by user_id desc";

	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    ResultSet rs = cmd.executeQuery();

	    while (rs.next()) {
	        int user_id = rs.getInt("user_id");
	        String username = rs.getString("username");
	        String full_name = rs.getString("full_name");
	        String email = rs.getString("email");
	        String phone = rs.getString("phone");
	        String address = rs.getString("address");
	        int role = rs.getInt("role");
	        boolean locked = rs.getBoolean("locked");

	        Account account = new Account(user_id, username, full_name, email, phone, address, role, locked);
	        ds.add(account);
	    }

	    rs.close();
	    cmd.close();
	    kn.cn.close();

	    return ds;
	}


	public int count(String searchValue, Integer role, Boolean locked) throws Exception {
		int count = 0;
		Connect kn = new Connect();
		kn.connectDB();

		String roleCondition = (role == null) ? "1=1" : "role = ?";
		String lockedCondition = (locked == null) ? "1=1" : "locked = ?";

		String sql = "select count(*) from VAdminManagerAcounts " + "where (username like ? or full_name like ?) and ("
				+ roleCondition + " and " + lockedCondition + ")";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		int paramIndex = 1;
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		cmd.setString(paramIndex++, "%" + searchValue + "%");
		if (role != null) {
			cmd.setInt(paramIndex++, role);
		}
		if (locked != null) {
			cmd.setBoolean(paramIndex++, locked);
		}

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		rs.close();
		cmd.close();
		kn.cn.close();

		return count;
	}

	public int updateLock(int user_id, Boolean locked) throws Exception {
		Connect kn = new Connect();
		kn.connectDB();

		String sql = "update Users set locked = ? where user_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setBoolean(1, locked);
		cmd.setInt(2, user_id);

		int kq = cmd.executeUpdate();

		kn.cn.close();

		return kq;
	}

}

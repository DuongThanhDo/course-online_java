package connectModel;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public Connection cn;
	public void connectDB() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String st = "jdbc:sqlserver://******:1433;databaseName=******;user=sa;password=***";
		
		cn = DriverManager.getConnection(st);
	}
}

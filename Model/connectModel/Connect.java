package connectModel;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public Connection cn;
	public void connectDB() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String st = "jdbc:sqlserver://LAPTOP-C1AI2A8S:1433;databaseName=OCMSJava;user=sa;password=123";
		
		cn = DriverManager.getConnection(st);
	}
}

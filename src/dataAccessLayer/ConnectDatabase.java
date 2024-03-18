package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
	public ConnectDatabase() {};
	
	public Connection getJDBC() {
		final String url="jdbc:mysql://localhost:3306/ProjectProductManagement";
		final String user="root";
		final String password="Nguyentai4632@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
	private Connection connection = null;
	private String url = "jdbc:mariadb://localhost:3306";
	private String user = "root";
	private String password = "admin";
	
	public void getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(url,user,password);
				System.out.println(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that create database connection and order the literary works from the data
 *
 */
public class ConnectionDAO {
	private Connection connection = null;
	private String url = "jdbc:mariadb://localhost:3306/si400";
	private String user = "root";
	private String password = "admin";
	
	public ConnectionDAO(){
		getConnection();
		OrderLiteraryWorks();
		
	}
	
	private void getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(url,user,password);
				//System.out.println(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void OrderLiteraryWorks() {
		String sql = "Select textline from Fragmentos where idGroup=2 order by line;";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String text = rs.getString("textline");
				System.out.println(text);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

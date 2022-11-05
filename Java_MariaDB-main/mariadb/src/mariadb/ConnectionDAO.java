package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that create database connection and order the literary works from the data.
 */
public class ConnectionDAO {
	private Connection connection = null;
	private String url = "jdbc:mariadb://localhost:3306/si400";
	private String user = "root";
	private String password = "admin";
	
	/**
	 * Class constructor.
	 */
	public ConnectionDAO(){
		getConnection();
		OrderLiteraryWorks();
	}
	
	/**
	 * Class that makes connection with the database si400.
	 */
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
	
	/**
	 * Class that order the literary work from the data to his original form. 
	 */
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

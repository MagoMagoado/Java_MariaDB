package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that create database connection and order the literary works from the data.
 */
public class ConnectionDAO {
	private Connection connection = null;
	//private String url = "jdbc:mariadb://143.106.243.64:3306/SI400";
	private String url = "jdbc:mariadb://localhost:3306/SI400";
	private String user = "root";
	private String password = "root";
	
	/**
	 * Class constructor.
	 */
	public ConnectionDAO(){
		getConnection();
		//OrderLiteraryWorks();
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
	public List<String> OrderLiteraryWorks() {
		String text = "";
		List<String> listOfStrings = new ArrayList<String>();
		String sql = "Select text from Fragmentos where groupId=2 order by line;";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				text = rs.getString("text");
				listOfStrings.add(text);
			}
			//listOfStrings.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfStrings;
	}
}

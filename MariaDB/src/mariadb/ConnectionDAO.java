package mariadb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
	private String url = "jdbc:mariadb://143.106.243.64:3306/SI400";
	private String user = "si400_2022";
	private String password = "si400_2022";
	
	/**
	 * Class constructor.
	 */
	public ConnectionDAO(){
		getConnection();
		ExportTxt(OrderLiteraryWorks());
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
	
	/**
	 * Class that export the text from the data in txt.
	 * Parameter list is a List that contains the data that will be exported as txt.
	 */
	public void ExportTxt(List<String> list) {
		try {      
			BufferedWriter writer = new BufferedWriter(new FileWriter("exportFile.txt"));

			for(int i = 0; i < list.size(); i++) {
					if(i != 0) {
						writer.newLine();
					}
					writer.write(list.get(i));
			};
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

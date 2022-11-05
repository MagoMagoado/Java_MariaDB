package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    
        public void CallGetConnection() {
            ConnectionDAO dao = new ConnectionDAO();
            dao.ConnectionDAO();
        }

        public void CallLogin(){
            loginGUI login = new loginGUI();
            login.login();
        }
  
}

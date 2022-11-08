package mariadb;

public class Program {

	public static void main(String[] args) {
		//loginGUI login = new loginGUI();
		//login.execute();
		ConnectionDAO conn = new ConnectionDAO();
		conn.ExportTxt(conn.OrderLiteraryWorks());
	}
}

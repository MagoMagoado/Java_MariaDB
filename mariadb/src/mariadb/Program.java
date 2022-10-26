package mariadb;

public class Program {

	public static void main(String[] args) {
		ConexaoDAO dao = new ConexaoDAO();
		dao.getConnection();
	}

}

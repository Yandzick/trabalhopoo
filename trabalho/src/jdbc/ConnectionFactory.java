package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

	String severName = "localhost:3306";//Caminho para servidor do BD
	String mydatabase = "crud"; //Nome do banco de dados
	String url = "jdbc:mysql://" + severName + "/" + mydatabase;
	String username = "root"; //Nome do usuário de seu BD
	String password = ""; //Sua senha de acesso

	public static Connection getConnection() throws ClassNotFoundException {
		try {

			// Class.forName(DRIVE); // opcional dependendo da versao

			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
			// System.out.println(e);
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package bookmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	static Connection con = null;

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String uname = "sqluser";
		String pass = "bazinga||jk";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		} catch (SQLException e) {
			System.out.println("Database not found");
		}
		return con;
	}

}

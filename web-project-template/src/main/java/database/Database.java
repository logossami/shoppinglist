package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static final String URL = "jdbc:sqlite:/balsatree.sqlite";
	
	
	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}

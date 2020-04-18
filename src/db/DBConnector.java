package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnector {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if (conn == null) {
		try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
		}
		catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
	return conn;
}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		
		try ( FileInputStream file = new FileInputStream("db.properties") ){
			
			Properties props = new Properties();
			props.load(file);
			
			return props;
		}
		catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}
	
	public static void cloaseStatment( Statement statement ) {
		
		// Fechar o statment
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void cloaseResultSet( ResultSet resultSet ) {
			
			// Fechar o statment
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new DBException(e.getMessage());
				}
			}
	}
}

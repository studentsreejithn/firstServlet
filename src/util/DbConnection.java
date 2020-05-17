package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private Connection connection;

	public Connection getConnection() {
		if(connection!=null)		
		return connection;
		else
		{
			this.setConnection();
			return connection;
		}
	}

	public void setConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = null;
			
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/iwhy", 
						"myAdminUser", "myAdminUser");
				this.connection = connection;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection() {
		try {
			if(this.connection!=null)	
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

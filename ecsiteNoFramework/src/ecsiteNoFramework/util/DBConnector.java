package ecsiteNoFramework.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnector {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";

	private static final String URL = "jdbc:mysql://localhost/ecsite";
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";

	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(DRIVERNAME);
			con = (Connection)DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
}

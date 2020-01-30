package ecsiteNoFramework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecsiteNoFramework.util.DBConnector;
import ecsiteNoFramework.util.DateUtil;

public class UserCreateDAO {


	public int CreateUser(String loginId, String loginPass, String userName){

		Connection db = DBConnector.getConnection();
		DateUtil date = new DateUtil();
		int result = 0;

		final String SQL = "INSERT "
				+ "INTO "
				+ "login_user "
				+ "(login_id, "
				+ "login_pass, "
				+ "user_name, "
				+ "insert_date) "
				+ "VALUES(?,?,?,?)";

		try{
			PreparedStatement ps = db.prepareStatement(SQL);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);
			ps.setString(3, userName);
			ps.setString(4, date.getDate());
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}

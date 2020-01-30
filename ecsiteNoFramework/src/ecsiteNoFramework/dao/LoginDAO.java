package ecsiteNoFramework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecsiteNoFramework.dto.LoginDTO;
import ecsiteNoFramework.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUser(String loginId, String loginPass){
		String sql = "SELECT * FROM "
				+ "login_user "
				+ "WHERE "
				+ "login_id=? "
				+ "AND "
				+ "login_pass=?";
		LoginDTO dto = new LoginDTO();
		Connection db = DBConnector.getConnection();

		try{
			PreparedStatement ps = db.prepareStatement(sql);

			ps.setString(1, loginId);
			ps.setString(2, loginPass);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dto;
	}

}

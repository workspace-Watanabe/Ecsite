package ecsiteNoFramework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecsiteNoFramework.dto.BuyItemDTO;
import ecsiteNoFramework.util.DBConnector;

public class BuyItemDAO {


	public BuyItemDTO getBuyItemInfo(){
		Connection db = DBConnector.getConnection();
		BuyItemDTO dto = new BuyItemDTO();

		final String SQL = "SELECT "
				+ "id,"
				+ "item_name,"
				+ "item_price "
				+ "FROM "
				+ "item_info";

		try{
			PreparedStatement ps = db.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dto;
	}
}

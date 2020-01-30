package ecsiteNoFramework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecsiteNoFramework.dto.MyPageDTO;
import ecsiteNoFramework.util.DBConnector;

public class MyPageDAO {

	private Connection db = DBConnector.getConnection();


	public List<MyPageDTO> getMyPageUserInfo(
			String itemId,
			String userId){

		List<MyPageDTO> list = new ArrayList<>();
		final String SQL = "SELECT "
				+ "ubit.id,"
				+ "iit.item_name,"
				+ "ubit.total_price,"
				+ "ubit.total_count,"
				+ "ubit.pay,"
				+ "ubit.insert_date "
			+ "FROM "
				+ "user_buy ubit "
			+ "LEFT JOIN "
				+ "item_info iit "
			+ "ON "
				+ "ubit.item_id=iit.id "
				+ "WHERE "
				+ "ubit.item_id=? "
			+ "AND "
				+ "ubit.user_id=? "
			+ "ORDER BY "
				+ "insert_date "
			+ "DESC";

		try{
			PreparedStatement ps = db.prepareStatement(SQL);
			ps.setString(1, itemId);
			ps.setString(2, userId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				list.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 商品購入履歴を削除する
	 *
	 * @param itemId
	 * @param userId
	 * @return
	 */
	public int buyItemHistoryDelete(
			String itemId,
			String userId){

		final String SQL = "DELETE FROM user_buy "
				+ "WHERE "
				+ "item_id=? "
				+ "AND "
				+ "user_id=?";
		PreparedStatement ps;
		int result = 0;

		try{
			ps = db.prepareStatement(SQL);
			ps.setString(1, itemId);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}

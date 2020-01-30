package ecsiteNoFramework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecsiteNoFramework.util.DBConnector;
import ecsiteNoFramework.util.DateUtil;

public class BuyItemCompleteDAO {


			/**
			 * 商品を購入する
			 *
			 * @param id
			 * @param totalPrice
			 * @param count
			 * @param UserId
			 * @param pay
			 * @return
			 */
		public int buyItemInfo(
				String id,
				String totalPrice,
				String count,
				String UserId,
				String pay){
			DateUtil date = new DateUtil();
			Connection db = DBConnector.getConnection();
			final String SQL = "INSERT INTO user_buy("
					+ "item_id,"
					+ "total_price,"
					+ "total_count,"
					+ "user_id,"
					+ "pay,"
					+ "insert_date) "
					+ "VALUES(?,?,?,?,?,?)";
			int result = 0;

			try{
				PreparedStatement ps = db.prepareStatement(SQL);

				ps.setString(1, id);
				ps.setString(2, totalPrice);
				ps.setString(3, count);
				ps.setString(4, UserId);
				ps.setString(5, pay);
				ps.setString(6, date.getDate());

				result = ps.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{
					db.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return result;
		}
}

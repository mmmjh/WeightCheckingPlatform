package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import model.Jichu;

import utils.DBUtil;

public class JichuImp implements IJichu {
 
	@Override
	public void add(Jichu jichu) {
		Connection connection = (Connection) DBUtil.getConnection();
		String sql = null;
		int num = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			sql = "insert into newskill (title,keyword01,keyword02,keyword03,zhaiyao,type) value (?,?,?,?,?,?)";

			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, jichu.getTitle());
			preparedStatement.setString(2, jichu.getKeyword01());
			preparedStatement.setString(3, jichu.getKeyword02());
			preparedStatement.setString(4, jichu.getKeyword03());
			preparedStatement.setString(5, jichu.getZhaiyao());
			preparedStatement.setInt(6, jichu.getType());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public List<Jichu> search() {
		Connection connection = (Connection) DBUtil.getConnection();

		String sql = "select * from newskill ";

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Jichu> jichus = new ArrayList<Jichu>();
		Jichu jichu = null;

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

			int num = 0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				jichu = new Jichu();
				jichu.setId(resultSet.getInt("id"));
				jichu.setTitle(resultSet.getString("title"));
				jichu.setZhaiyao(resultSet.getString("zhaiyao"));
				jichu.setKeyword01(resultSet.getString("keyword01"));
				jichu.setKeyword02(resultSet.getString("keyword02"));
				jichu.setKeyword03(resultSet.getString("keyword03"));
				jichu.setType(resultSet.getInt("type"));

				jichus.add(jichu);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return jichus;
	}
	
	@Override
	public List<Jichu> search(String keyword) {
		Connection connection = (Connection) DBUtil.getConnection();

		String sql = "select * from newskill where type = ?";

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Jichu> jichus = new ArrayList<Jichu>();
		Jichu jichu = null;

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, keyword);

			int num = 0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				jichu = new Jichu();
				jichu.setId(resultSet.getInt("id"));
				jichu.setTitle(resultSet.getString("title"));
				jichu.setZhaiyao(resultSet.getString("zhaiyao"));
				jichu.setKeyword01(resultSet.getString("keyword01"));
				jichu.setKeyword02(resultSet.getString("keyword02"));
				jichu.setKeyword03(resultSet.getString("keyword03"));
				jichu.setType(resultSet.getInt("type"));

				jichus.add(jichu);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return jichus;
	}

	@Override
	public Jichu SearchByKey(int id) {
		Connection connection = (Connection) DBUtil.getConnection();

		String sql = "select * from newskill where id = ?";

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		Jichu jichu = null;

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			int num = 0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				jichu = new Jichu();
				jichu.setTitle(resultSet.getString("title"));
				jichu.setZhaiyao(resultSet.getString("zhaiyao"));
				jichu.setKeyword01(resultSet.getString("keyword01"));
				jichu.setKeyword02(resultSet.getString("keyword02"));
				jichu.setKeyword03(resultSet.getString("keyword03"));
				jichu.setType(resultSet.getInt("type"));
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return jichu;
	}
	
	 public static  void main(String []args) {
		  
	  }
}

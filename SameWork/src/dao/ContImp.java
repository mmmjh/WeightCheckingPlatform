package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.util.List;

import model.Allcontent;
import model.Jichu;
import utils.DBUtil;

public class ContImp implements Cont {
	@Override
	public void add(double num,int id) {
		Connection connection = (Connection) DBUtil.getConnection();
		//准备sql语句
		String sql = "update content1  set samenum="+num+"where id ="+id;
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			System.out.println(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}
	
@Override
public List<Allcontent> search() {
	Connection connection = (Connection) DBUtil.getConnection();

	String sql = "select * from content1";

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	List<Allcontent> cons = new ArrayList<Allcontent>();
	Allcontent con = null;

	try {
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

		int num = 0;
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			con = new Allcontent();
			con.setId(resultSet.getInt("id"));
			con.setTitle00(resultSet.getString("title00"));
			con.setTitle01(resultSet.getString("title01"));
			con.setTitle02(resultSet.getString("title02"));
			con.setContent(resultSet.getString("content"));
			con.setKeywords(resultSet.getString("keywords"));
			con.setZhaiyao(resultSet.getString("zhaiyao"));
			con.setBaidu(resultSet.getString("baidu"));
			con.setSamenum(resultSet.getDouble("samenum"));
			cons.add(con);

		}
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		DBUtil.close(connection);
	}
	return cons;
}
@Override
public List<Allcontent> search1() {
	Connection connection = (Connection) DBUtil.getConnection();

	String sql = "select * from content1 limit 0,130;";

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	List<Allcontent> cons = new ArrayList<Allcontent>();
	Allcontent con = null;

	try {
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

		int num = 0;
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			con = new Allcontent();
			con.setId(resultSet.getInt("id"));
			con.setTitle00(resultSet.getString("title00"));
			con.setTitle01(resultSet.getString("title01"));
			con.setTitle02(resultSet.getString("title02"));
			con.setContent(resultSet.getString("content"));
			con.setKeywords(resultSet.getString("keywords"));
			con.setZhaiyao(resultSet.getString("zhaiyao"));
			con.setBaidu(resultSet.getString("baidu"));
			con.setSamenum(resultSet.getDouble("samenum"));
			cons.add(con);

		}
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		DBUtil.close(connection);
	}
	return cons;
}

}
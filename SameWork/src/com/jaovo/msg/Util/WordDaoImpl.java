package com.jaovo.msg.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jaovo.msg.model.Info;
import com.jaovo.msg.model.Namenum;
import com.jaovo.msg.model.Word;




public class WordDaoImpl {
	public List<Namenum> search1() {
		Connection connection = (Connection) DBUtil.getConnection();
		
		String sql = "select * from newskill where type=1";
	
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Namenum> demos = new ArrayList<Namenum>();
		Namenum namenum=null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			
			int num=0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
					namenum=new Namenum();
					namenum.setName(resultSet.getString("keyword01"));
					namenum.setName1(resultSet.getString("keyword02"));
					namenum.setName2(resultSet.getString("keyword03"));
					
					namenum.setType(resultSet.getInt("type"));
				demos.add(namenum);				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return demos;
	}
	
	public List<Namenum> search2() {
		Connection connection = (Connection) DBUtil.getConnection();
		
		String sql = "select * from newskill where type=2";
	
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Namenum> demos = new ArrayList<Namenum>();
		Namenum namenum=null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			
			int num=0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
					namenum=new Namenum();
					namenum.setName(resultSet.getString("keyword01"));
					namenum.setName1(resultSet.getString("keyword02"));
					namenum.setName2(resultSet.getString("keyword03"));
					
					namenum.setType(resultSet.getInt("type"));
				demos.add(namenum);				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return demos;
	}
	public List<Namenum> search3() {
		Connection connection = (Connection) DBUtil.getConnection();
		
		String sql = "select * from newskill where type=3";
	
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Namenum> demos = new ArrayList<Namenum>();
		Namenum namenum=null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			
			int num=0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
					namenum=new Namenum();
					namenum.setName(resultSet.getString("keyword01"));
					namenum.setName1(resultSet.getString("keyword02"));
					namenum.setName2(resultSet.getString("keyword03"));
					
					namenum.setType(resultSet.getInt("type"));
				demos.add(namenum);				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return demos;
	}
	public List<Namenum> search4() {
		Connection connection = (Connection) DBUtil.getConnection();
		
		String sql = "select * from newskill where type=4";
	
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Namenum> demos = new ArrayList<Namenum>();
		Namenum namenum=null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			
			int num=0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
					namenum=new Namenum();
					namenum.setName(resultSet.getString("keyword01"));
					namenum.setName1(resultSet.getString("keyword02"));
					namenum.setName2(resultSet.getString("keyword03"));
					
					namenum.setType(resultSet.getInt("type"));
				demos.add(namenum);				
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return demos;
	}
}

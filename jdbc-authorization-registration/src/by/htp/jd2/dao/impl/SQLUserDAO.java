package by.htp.jd2.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.jd2.dao.DAOException;
import by.htp.jd2.dao.UserDAO;
import by.htp.jd2.entity.User;

public class SQLUserDAO implements UserDAO{

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://127.0.0.1/jd2-users-db?useSSL=false&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "***";
	
	private static final String SELECT_BY_LOGIN_PASSWORD = "SELECT name, surname FROM users WHERE login=? AND password=?";
	private static final String SELECT_BY_LOGIN = "SELECT login FROM users WHERE login=?";
	private static final String INSERT = "INSERT INTO users(login, password, name, surname, age) VALUES(?, ?, ?, ?, ?)";
	
	@Override
	public User authorization(String login, String password) throws DAOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		User user = null;
		
		try {																			
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);	
			
			ps = con.prepareStatement(SELECT_BY_LOGIN_PASSWORD);
			
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next() != false) {				
				user = new User();
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
			}
			
		}catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			if(rs != null) {																				
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}			
			if(ps != null) {
				try{
					ps.close();
				}catch(SQLException e) {
					throw new DAOException(e);
				}
			}			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {				
					throw new DAOException(e);
				}
			}
		}
		
		return user;
	}


	@Override
	public boolean registration(User user) throws DAOException {
		
		boolean result;		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		
		try {																						
			Class.forName(DB_DRIVER);														
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);   			
			
			ps = con.prepareStatement(SELECT_BY_LOGIN);
			
			ps.setString(1, user.getLogin());
			rs = ps.executeQuery();
			
			if(rs.next() == false) {						
				ps = con.prepareStatement(INSERT);																	
			
				ps.setString(1, user.getLogin());					 										
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getName());
				ps.setString(4, user.getSurname());
				ps.setString(5, String.valueOf(user.getAge()));			
				ps.executeUpdate();								
				
				result = true;	
			}else {
				result = false;
			}
			
		}catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}catch (SQLException e) {
			throw new DAOException(e);
		}finally {			
			if(rs != null) {																				
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
			if(ps != null) {																				
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {				
					throw new DAOException(e);
				}
			}
		}
		
		return result;			
	}

}


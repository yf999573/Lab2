package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  JDBCUtilSingle:JDBC helper class
 */
public final class JDBCUtilSingle {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_hitzz";
	static String username = "l0x5j042my";
	static String password = "hxyyx31mz05iwkzjzij0w22kwy51k0hj0y22wykl";
	static Connection conn = null;
	private static JDBCUtilSingle instance = null;
	
	private JDBCUtilSingle() {
	}
	
	
	public static JDBCUtilSingle getInstance(){
		if(instance == null){
			synchronized(JDBCUtilSingle.class){
				if(instance == null){
					instance = new JDBCUtilSingle();
				}
			}
		}
		return instance;
	}

	/**
	 * static code block register database driven to ensure registration only one 
	 */
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get database Connection
	 * @return Connection
	 */
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * close connection resource
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public void closeConnection(ResultSet rs, Statement st, Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(conn != null){
						conn.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}

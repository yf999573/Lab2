package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.model.Author;

public class AuthorDao {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	conn = DriverManager.getConnection(url,username,password);
	
	public List<Author> getAuthorList(){
		List<Author> list = new ArrayList<Author>();
		String sql = "select AuthorID,name,age,Country from Author order by AuthorID asc";
		conn = JDBCUtilSingle.getInstance().getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			Author stu = null;
			while(rs.next()){
				stu = new Author();
				stu.setAuthorID(rs.getInt("AuthorID"));
				stu.setAge(rs.getInt("age"));
				stu.setName(rs.getString("name"));
				stu.setCountry(rs.getString("Country"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtilSingle.getInstance().closeConnection(rs, st, conn);
		return list;
	}
	
	public void saveAuthor(Author author){
		String sql = "insert into author( AuthorID,name,age,Country ) values(?,?,?,?)";
		conn = JDBCUtilSingle.getInstance().getConnection();
		try {
			PreparedStatement  st = conn.prepareStatement(sql);
			st.setInt(1, author.getAuthorID());
			st.setString(2, author.getName());
			st.setString(3, author.getCountry());
			st.setInt(4, author.getAge());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtilSingle.getInstance().closeConnection(rs, st, conn);
	}
	
	public Author getAuthor(int id){
		Author stu = new Author();
		String sql = "select  AuthorID,name,age,Country  from author where id=?";
		conn = JDBCUtilSingle.getInstance().getConnection();
		try {
			PreparedStatement  st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				stu.setAuthorID(rs.getInt("AuthorID"));
				stu.setName(rs.getString("name"));
				stu.setCountry(rs.getString("Country"));
				stu.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtilSingle.getInstance().closeConnection(rs, st, conn);
		return stu;
	}
	
	public void updateAuthor(Author author){
		String sql = "update author set  AuthorID=?,name=?,age=?,Country=?  where id=?";
		conn = JDBCUtilSingle.getInstance().getConnection();
		try {
			PreparedStatement  st = conn.prepareStatement(sql);
			st.setInt(1, author.getAuthorID());
			st.setString(2, author.getName());
			st.setString(3, author.getCountry());
			st.setInt(4, author.getAge());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtilSingle.getInstance().closeConnection(rs, st, conn);
	}
	
	public void deleteAuthor(int id){
		String sql = "delete from  author where AuthorID=?";
		conn = JDBCUtilSingle.getInstance().getConnection();
		try {
			PreparedStatement  st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtilSingle.getInstance().closeConnection(rs, st, conn);
	}
}

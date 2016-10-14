package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import library.all;
import utill.DBHelper;

public class showbook extends ActionSupport {

	private String ISBN;
	private String Title;
	private String Publisher;
	private Date PublishDate;
	private Integer price;
	private String Name;
	private Integer Age;
	private String Country;
	ArrayList<all> list;
	private Map request;

	public showbook() {
		request = (Map) ActionContext.getContext().get("request");
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public Date getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public ArrayList<all> getList() {
		return list;
	}

	public void setList(ArrayList<all> list) {
		this.list = list;
	}

	public Map getRequest() {
		return request;
	}

	public void setRequest(Map request) {
		this.request = request;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String show() throws Exception {
		//String decodedTitle = new String(Title.getBytes("iso-8859-1"), "UTF-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<all> list = new ArrayList<all>();
		try {
			String sql = "select * from book left join author on book.AuthorID = author.AuthorID where book.Title=?;";
			conn = DBHelper.getConnection(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Title);
			rs = stmt.executeQuery();
			if (rs.next()) {
				all show_book = new all();
				show_book.setISBN(rs.getString("ISBN"));
				show_book.setTitle(rs.getString("Title"));
				show_book.setPublisher(rs.getString("Publisher"));
				show_book.setPublishDate(rs.getDate("publishDate"));
				show_book.setPrice(rs.getInt("price"));
				show_book.setName(rs.getString("Name"));
				show_book.setAge(rs.getInt("Age"));
				show_book.setCountry(rs.getString("Country"));
				list.add(show_book);
			}
			request.put("list", list);
			rs.close();
			stmt.close();
			conn.close();
			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

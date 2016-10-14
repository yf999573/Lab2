package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import utill.DBHelper;

public class deletebook extends ActionSupport {
	
	private String ISBN;
	
	private Map request;

	public Map getRequest() {
		return request;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	public String delete() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			String sql = "delete from book where book.ISBN=?;";
			conn = DBHelper.getConnection(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ISBN);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}		
	}
	
	

}

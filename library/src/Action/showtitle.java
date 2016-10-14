package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import utill.DBHelper;

public class showtitle implements Action {

	private String Title;
	private String Name;
	ArrayList<String> list;
	private Map request;

	public Map getRequest() {
		return request;
	}

	public void setRequest(Map request) {
		this.request = request;
	}

	public showtitle(){
		request = (Map)ActionContext.getContext().get("request");
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String search(){ 
        Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		list = new ArrayList<String>();
		try {
			
			String sql =  "select a.title from book as a inner join author as b on a.authorID=b.authorid where b.name=?;";
			conn = DBHelper.getConnection(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("Title"));
			}
			request.put("list", list);
			if(list == null || list.size()==0)
				return ERROR;
			else
			    return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放数据对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}

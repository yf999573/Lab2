package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBHelper {
	
    private static final String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_nanjf"; 
	private static final String username="my2w543y54";
	private static final String password="13j42kh500ihw1x03k3wwi2yhl4jx2z3ym5hx5lx";
	public static final String driver="com.mysql.jdbc.Driver";
	
	public static Connection conn = null; 
	public static PreparedStatement stmt = null;
	
	//加载数据库驱动

	public static Connection getConnection(String sql) throws Exception
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = DBHelper.getConnection("sss");
		   if(conn!=null)
		   {
			   System.out.println("数据库连接成功！");
		   }
		   else
		   {
			   System.out.println("数据库连接失败！");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}

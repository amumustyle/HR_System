package exp.db;

import java.sql.*;


public class DBHelper {	
	private static String dbUrl="jdbc:mysql://localhost:3306/renshi";
	private static String dbUser="root";
	private static String dbPassword="005544";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	public static Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return conn;		
	}
	
	public static void main(String[] args)
	{
		DBHelper.getConn();
		System.out.println(DBHelper.getConn());
	}
	
}

package exp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import exp.bean.UserBean;
import exp.db.DBHelper;


public class UserDao {
	Connection conn ;
	public UserDao(){}
	public UserDao(Connection conn) {
		this.conn = conn;
	}
	public int login(String id, String pwd) {
		try {
			UserBean userB = null;
			userB = this.fubynum(id);
			if (userB != null && userB.getPassword().equals(pwd)) {
				return 1;
			
			} else {
				return 0;

			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}
	public  UserBean fubynum(String id){		
		String a = id;
		String sql = "select * from User where username = ?";	
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		UserBean aa = new UserBean();
		
		conn = DBHelper.getConn();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,a);

			rs = pstmt.executeQuery();			
				while(rs.next()){
					aa.setUsername(rs.getString(1));
					aa.setPassword(rs.getString(2));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return aa;
	}
}

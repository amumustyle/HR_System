package exp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.bean.DepartBean;
import exp.bean.PostBean;
import exp.db.DBHelper;

	public class PostDao {
		Connection conn ;
		public PostDao(){}
		public PostDao(Connection conn) {
			this.conn = conn;
	}
	public void delpost(PostBean Postbean){
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			conn = DBHelper.getConn();
			
			try {
				String sql = "update Post set Postisdel=? where Postname = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "1");
				pstmt.setString(2, Postbean.getPostname());
				pstmt.executeUpdate();
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
		}
	public void changepost(PostBean Postbean){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		
		try {
			String sql = "update Post set Postname = ?,Posttype = ?,Postisdel = ? where Postid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Postbean.getPostname());
			pstmt.setString(2, Postbean.getPosttype());
			pstmt.setString(3, "0");
			pstmt.setString(4, Postbean.getPostid());
			pstmt.executeUpdate();
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
	}
	public void addpost(PostBean Postbean){
		
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		String sql = "insert into post values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Postbean.getPostid());
			pstmt.setString(2, Postbean.getPostname());
			pstmt.setString(3, Postbean.getPosttype());
			pstmt.setString(4, "0");
			
			pstmt.executeUpdate();
			
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
	}
	public List<PostBean> findallp(){
		List <PostBean>list = new ArrayList<PostBean>();
		PostBean Postbean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from post where postisdel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"0");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Postbean = new PostBean();
				Postbean.setPostid(rs.getString(1));
				Postbean.setPostname(rs.getString(2));
				Postbean.setPosttype(rs.getString(3));
				list.add(Postbean);
		}} catch (SQLException e) {
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
		return list;
	}
	public  PostBean fubynum(String id){		
		String a = id;
		String sql = "select * from Post where Postid = ?";	
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		PostBean aa = new PostBean();
		
		conn = DBHelper.getConn();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,a);

			rs = pstmt.executeQuery();			
				while(rs.next()){
					aa.setPostid(rs.getString(1));
					aa.setPostname(rs.getString(2));
					aa.setPosttype(rs.getString(3));
					aa.setPostisdel(rs.getString(4));
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

package exp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import exp.bean.DepartBean;
import exp.db.DBHelper;

public class DepartDao {
	Connection conn ;
	public DepartDao(){}
	public DepartDao(Connection conn) {
		this.conn = conn;
	}
	public  DepartBean fubynum(String id){		
		String a = id;
		String sql = "select * from Depart where departid = ?";	
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		DepartBean aa = new DepartBean();
		
		conn = DBHelper.getConn();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,a);

			rs = pstmt.executeQuery();			
				while(rs.next()){
					aa.setDepartid(rs.getString(1));
					aa.setDepartname(rs.getString(2));
					aa.setDeparttype(rs.getString(3));
					aa.setDeparttel(rs.getString(4));
					aa.setDepartst(rs.getString(5));
					aa.setDepartisdel(rs.getString(6));
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
	
	public List<String> findalldname(){
		List <String>list = new ArrayList<String>();
		
//		DepartBean Departbean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select departname from depart where departisdel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"0");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String departname = rs.getString(1);
				list.add(departname);
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
	
	public List<DepartBean> findalld(){
		List <DepartBean>list = new ArrayList<DepartBean>();
		DepartBean Departbean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from depart where departisdel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"0");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Departbean = new DepartBean();
				Departbean.setDepartid(rs.getString(1));
				Departbean.setDepartname(rs.getString(2));
				Departbean.setDeparttype(rs.getString(3));
				Departbean.setDeparttel(rs.getString(4));
				Departbean.setDepartst(rs.getString(5));
				list.add(Departbean);
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
	public void adddepart(DepartBean Departbean){
		
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		String sql = "insert into depart values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Departbean.getDepartid());
			pstmt.setString(2, Departbean.getDepartname());
			pstmt.setString(3, Departbean.getDeparttype());
			pstmt.setString(4, Departbean.getDeparttel());
			pstmt.setString(5, Departbean.getDepartst());
			pstmt.setString(6, "0");
			
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
	public void changedepart(DepartBean Departbean){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		
		try {
			String sql = "update Depart set Departname = ?,Departtype = ?,Departtel=?,Departst=?,Departisdel=? where Departid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Departbean.getDepartname());
			pstmt.setString(2, Departbean.getDeparttype());
			pstmt.setString(3, Departbean.getDeparttel());
			pstmt.setString(4, Departbean.getDepartst());
			pstmt.setString(5, "0");
			pstmt.setString(6, Departbean.getDepartid());
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
	public void deldepart(DepartBean Departbean){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		
		try {
			String sql = "update Depart set Departisdel=? where Departname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");
			System.out.println(Departbean.getDepartname());
			pstmt.setString(2, Departbean.getDepartname());
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
}

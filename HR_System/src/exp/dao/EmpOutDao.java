package exp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.bean.EmpInBean;
import exp.bean.EmpOutBean;
import exp.db.DBHelper;

public class EmpOutDao {
	Connection conn;

	public EmpOutDao() {
	}

	public EmpOutDao(Connection conn) {
		this.conn = conn;
	}

	public int findmoutnumbydate(String departnameout, String startdate,
			String enddate) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		int i = 0;
		try {
			String sql = "select count(*) from EmpOut where empdepart = ? and empoutdate >= ? and empoutdate <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departnameout);
			pstmt.setString(2, startdate);
			pstmt.setString(3, enddate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
		return i;
	}

	public int findminnumbydate(String departnamein, String startdate,
			String enddate) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		int i = 0;
		try {
			String sql = "select count(*) from EmpOut where empdepart = ? and empindate >= ? and empindate <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departnamein);
			pstmt.setString(2, startdate);
			pstmt.setString(3, enddate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
		return i;
	}

	public List<EmpOutBean> findalleo() {
		List<EmpOutBean> list = new ArrayList<EmpOutBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from EmpOut ";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpOutBean aa = new EmpOutBean();
				aa.setEmpid(rs.getString(1));
				aa.setEmpname(rs.getString(2));
				aa.setEmpsex(rs.getString(3));
				aa.setEmpbirth(rs.getString(4));
				aa.setEmpidcard(rs.getString(5));
				aa.setEmpdepart(rs.getString(6));
				aa.setEmppost(rs.getString(7));
				aa.setEmpindate(rs.getString(8));
				aa.setEmpinwork(rs.getString(9));
				aa.setEmptype(rs.getString(10));
				aa.setEmpfrom(rs.getString(11));
				aa.setEmpouttype(rs.getString(12));
				aa.setEmpoutdate(rs.getString(13));

				list.add(aa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public void addemp(EmpOutBean Empoutbean) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		String sql = "insert into Empout values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Empoutbean.getEmpid());
			pstmt.setString(2, Empoutbean.getEmpname());
			pstmt.setString(3, Empoutbean.getEmpsex());
			pstmt.setString(4, Empoutbean.getEmpbirth());
			pstmt.setString(5, Empoutbean.getEmpidcard());
			pstmt.setString(6, Empoutbean.getEmpdepart());
			pstmt.setString(7, Empoutbean.getEmppost());
			pstmt.setString(8, Empoutbean.getEmpindate());
			pstmt.setString(9, Empoutbean.getEmpinwork());
			pstmt.setString(10, Empoutbean.getEmptype());
			pstmt.setString(11, Empoutbean.getEmpfrom());
			pstmt.setString(12, Empoutbean.getEmpouttype());
			pstmt.setString(13, Empoutbean.getEmpoutdate());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public EmpOutBean fubynum(String id) {
		String a = id;
		String sql = "select * from EmpOut where empid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpOutBean aa = new EmpOutBean();

		conn = DBHelper.getConn();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				aa.setEmpid(rs.getString(1));
				aa.setEmpname(rs.getString(2));
				aa.setEmpsex(rs.getString(3));
				aa.setEmpbirth(rs.getString(4));
				aa.setEmpidcard(rs.getString(5));
				aa.setEmpdepart(rs.getString(6));
				aa.setEmppost(rs.getString(7));
				aa.setEmpindate(rs.getString(8));
				aa.setEmpinwork(rs.getString(9));
				aa.setEmptype(rs.getString(10));
				aa.setEmpfrom(rs.getString(11));
				aa.setEmpoutdate(rs.getString(12));
				aa.setEmpouttype(rs.getString(12));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public List<EmpOutBean> fubyouttime(String starttime, String endtime) {
		List<EmpOutBean> list = new ArrayList<EmpOutBean>();
		String sql = "select * from EmpOut where empoutdate between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBHelper.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, starttime);
			pstmt.setString(2, endtime);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpOutBean aa = new EmpOutBean();
				aa.setEmpid(rs.getString(1));
				aa.setEmpname(rs.getString(2));
				aa.setEmpsex(rs.getString(3));
				aa.setEmpbirth(rs.getString(4));
				aa.setEmpidcard(rs.getString(5));
				aa.setEmpdepart(rs.getString(6));
				aa.setEmppost(rs.getString(7));
				aa.setEmpindate(rs.getString(8));
				aa.setEmpinwork(rs.getString(9));
				aa.setEmptype(rs.getString(10));
				aa.setEmpfrom(rs.getString(11));
				aa.setEmpoutdate(rs.getString(12));
				aa.setEmpouttype(rs.getString(13));
				list.add(aa);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
}

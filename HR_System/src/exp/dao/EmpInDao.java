package exp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.bean.DepartBean;
import exp.bean.EmpInBean;
import exp.db.DBHelper;

public class EmpInDao {
	Connection conn;

	public EmpInDao() {
	}

	public EmpInDao(Connection conn) {
		this.conn = conn;
	}

	public int findminnumbydate(String departnamein, String startdate,
			String enddate) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		int i = 0;
		try {
			String sql = "select count(*) from EmpIn where empdepart = ? and empindate >= ? and empindate <= ?";
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

	public int findmenumbydate(String departnamee, String enddate) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		int i = 0;
		try {
			String sql = "select count(*) from EmpIn where empdepart = ? and empindate <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departnamee);
			pstmt.setString(2, enddate);
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

	public int findmsnumbydate(String departnames, String startdate) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		int i = 0;
		try {
			// String sql =
			// "select count(*) from EmpIn where empdepart = ? and empindate < ?";
			String sql = "select count(*) from EmpIn where empdepart = ? and empindate < ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departnames);
			pstmt.setString(2, startdate);
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

	public void delemp(EmpInBean Empinbean) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		try {

			String sql = "delete from EmpIn where empid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Empinbean.getEmpid());
			pstmt.executeUpdate();
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
	}

	public void addemp(EmpInBean Empinbean) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		conn = DBHelper.getConn();
		String sql = "insert into Empin values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Empinbean.getEmpid());
			pstmt.setString(2, Empinbean.getEmpname());
			pstmt.setString(3, Empinbean.getEmpsex());
			pstmt.setString(4, Empinbean.getEmpbirth());
			pstmt.setString(5, Empinbean.getEmpidcard());
			pstmt.setString(6, Empinbean.getEmpdepart());
			pstmt.setString(7, Empinbean.getEmppost());
			pstmt.setString(8, Empinbean.getEmpindate());
			pstmt.setString(9, Empinbean.getEmpinwork());
			pstmt.setString(10, Empinbean.getEmptype());
			pstmt.setString(11, Empinbean.getEmpfrom());
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

	public List<EmpInBean> findallei() {
		List<EmpInBean> list = new ArrayList<EmpInBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from EmpIn ";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpInBean aa = new EmpInBean();
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

	public List<EmpInBean> fubypostname(String postname) {

		List<EmpInBean> list = new ArrayList<EmpInBean>();
		String a = postname;
		String sql = "select * from EmpIn where emppost = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBHelper.getConn();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpInBean aa = new EmpInBean();
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

	public List<EmpInBean> fubydepartname(String departname) {

		List<EmpInBean> list = new ArrayList<EmpInBean>();
		String a = departname;
		String sql = "select * from EmpIn where empdepart = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBHelper.getConn();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpInBean aa = new EmpInBean();
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

	public EmpInBean fubynum(String id) {
		String a = id;
		String sql = "select * from EmpIn where empid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpInBean aa = new EmpInBean();

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

	public List<EmpInBean> fubyintime(String starttime, String endtime) {

		List<EmpInBean> list = new ArrayList<EmpInBean>();
		String sql = "select * from EmpIn where empindate between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBHelper.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, starttime);
			pstmt.setString(2, endtime);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpInBean aa = new EmpInBean();
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

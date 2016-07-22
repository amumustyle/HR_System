package exp.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import exp.bean.DepartBean;
import exp.bean.HrmonthBean;

public class HrmonthDao {

	Connection conn ;
	public HrmonthDao(){}
	public HrmonthDao(Connection conn) {
		this.conn = conn;
	}
	
	public  List<HrmonthBean> hrmonth(String hrdate){
		List <HrmonthBean>list = new ArrayList<HrmonthBean>();
		int k;
		DepartDao departdao = new DepartDao();
		EmpInDao empindao = new EmpInDao();
		EmpOutDao empoutdao = new EmpOutDao();
		List i = departdao.findalldname();
		String datestart = hrdate + "-01";
		String dateend = hrdate + "-31";
		System.out.println(datestart);
		for(k=0;k<i.size();k++){
			int ms = empindao.findmsnumbydate((i.get(k)).toString(), datestart);
			int me = empindao.findmenumbydate((i.get(k)).toString(), dateend);
			int mii = empindao.findminnumbydate((i.get(k)).toString(), datestart, dateend);
			int mio = empoutdao.findminnumbydate((i.get(k)).toString(), datestart, dateend);
			int mi = mii+mio;
			int mo = empoutdao.findmoutnumbydate((i.get(k)).toString(), datestart, dateend);
			System.out.println("部门"+(i.get(k)).toString());
			System.out.println("部门月初人数"+ms);
			System.out.println("部门月末人数"+me);
			System.out.println("部门本月入职人数"+mi);
			System.out.println("部门本月离职人数"+mo);
			HrmonthBean hrmonthbean = new HrmonthBean();
			hrmonthbean.setDepartname((i.get(k)).toString());
			hrmonthbean.setStartnum(ms);
			hrmonthbean.setEndnum(me);
			hrmonthbean.setInnum(mi);
			hrmonthbean.setOutnum(mo);
			list.add(hrmonthbean);
		}
		return list;
	}
	
	
//	public static void main(String[] args) {
//		HrmonthDao hrmonthdao = new HrmonthDao();	
//		HrmonthDao.hrmonth("123");
//	}
}

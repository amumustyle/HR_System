package exp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import exp.bean.EmpInBean;
import exp.bean.DepartBean;
import exp.bean.EmpOutBean;
import exp.bean.HrmonthBean;
import exp.bean.PostBean;
import exp.dao.DepartDao;
import exp.dao.EmpInDao;
import exp.dao.EmpOutDao;
import exp.dao.HrmonthDao;
import exp.dao.PostDao;
import exp.dao.UserDao;


public class Action extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Action() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		System.out.println(method);
		
//		if("tologin".equals(method)){
//		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();		
//	
//		//out.print("<script>window.location.href='/login.jsp'</script>");
//		response.sendRedirect(request.getContextPath()+"/login.jsp");
//	}
		if("toaddpost".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			response.sendRedirect(request.getContextPath()+"/files/addStation.jsp");
		}
		if("torefpost".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			response.sendRedirect(request.getContextPath()+"/files/refStation.jsp");
		}
		
		if("toadddepart".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			response.sendRedirect(request.getContextPath()+"/files/addDepart.jsp");
		}
		if("torefdepart".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			response.sendRedirect(request.getContextPath()+"/files/refDepart.jsp");
		}
		if("deldepartsingle".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			//String deldepartsingle = request.getParameter("departname");
			String deldepartsingle = new String(request.getParameter("departname").getBytes("ISO-8859-1"),"UTF-8");
			
			System.out.println(deldepartsingle);
			request.setAttribute("deldepartsingle",deldepartsingle);
			RequestDispatcher rd = request.getRequestDispatcher("/files/delDepart.jsp");
			rd.forward(request, response);
		}
		if("delpostsingle".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String delpostsingle = new String(request.getParameter("postname").getBytes("ISO-8859-1"),"UTF-8");
			
			request.setAttribute("delpostsingle",delpostsingle);
			RequestDispatcher rd = request.getRequestDispatcher("/files/delStation.jsp");
			rd.forward(request, response);
		}
		if("changedepartsingle".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String changedepartsingle = request.getParameter("departid");

			request.setAttribute("changedepartsingle",changedepartsingle);
			RequestDispatcher rd = request.getRequestDispatcher("/files/changeDepart.jsp");
			rd.forward(request, response);
		}
		
		if("changepostsingle".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String changepostsingle = request.getParameter("postid");

			request.setAttribute("changepostsingle",changepostsingle);
			RequestDispatcher rd = request.getRequestDispatcher("/files/changeStation.jsp");
			rd.forward(request, response);
		}
		
		if("alloutemp".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();			
			
			EmpOutDao Empoutdao = new EmpOutDao();
			
			try {
				List i = Empoutdao.findalleo(); //执行查询所有代码并用i接收
				if(i.size()>0){			
					request.setAttribute("findalleo",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/alloutemp.jsp");//跳转到显示所有界面
					rd.forward(request, response);
					}
				else{
					out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
				}
			} catch (Exception e) {
				// TODO: handle exception
				out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
			}
			}
		
		if("allemp".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();			
			
			EmpInDao Empindao = new EmpInDao();
			
			try {
				List i = Empindao.findallei(); //执行查询所有代码并用i接收
				if(i.size()>0){			
					request.setAttribute("findallei",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/Staff.jsp");//跳转到显示所有界面
					rd.forward(request, response);
					}
				else{
					out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
				}
			} catch (Exception e) {
				// TODO: handle exception
				out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
			}
			}
		
		if("allpost".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();			
			PostDao postd = new PostDao();
			
			try {
				List i = postd.findallp(); //执行查询所有代码并用i接收
				if(i.size()>0){			
					request.setAttribute("findallp",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/Station.jsp");//跳转到显示所有界面
					rd.forward(request, response);
					}
				else{
					out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
				}
			} catch (Exception e) {
				// TODO: handle exception
				out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
			}
			}
		
		if("alldepart".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();			
			DepartDao departd = new DepartDao();
			
			try {
				List i = departd.findalld(); //执行查询所有代码并用i接收
				if(i.size()>0){			
					request.setAttribute("findalld",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/Depart.jsp");//跳转到显示所有界面
					rd.forward(request, response);
					}
				else{
					out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
				}
			} catch (Exception e) {
				// TODO: handle exception
				out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
			}
			}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		System.out.println(method);
		
		if("hryuebao".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String hrdate = request.getParameter("month1");
			
			HrmonthBean hrmonthbean = new HrmonthBean();
			HrmonthDao hrmonthdao = new HrmonthDao();
			
			try {
				List i = hrmonthdao.hrmonth(hrdate); //执行查询所有代码并用i接收
				if(i.size()>0){			
					request.setAttribute("hrmonth",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/monthshow.jsp");//跳转到显示所有界面
					rd.forward(request, response);
					}
				else{
					out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
				}
			} catch (Exception e) {
				// TODO: handle exception
				out.println("<script>alert('未查询到您要查找数据');</script>");//当没有查询到信息时提示错误
			}
		}
		
		
		if("leaveemp".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String leavenum= request.getParameter("leavenum");
			String empoutdate = request.getParameter("empoutdate");
			String empouttype = request.getParameter("empouttype");
			
			
			EmpOutBean Empoutbean = new EmpOutBean();
			EmpInBean Empinbean = new EmpInBean();
			Empinbean.setEmpid(leavenum);
			
			EmpInDao Empindao = new EmpInDao();
			EmpOutDao Empoutdao = new EmpOutDao();
			
			try {
				Empinbean = Empindao.fubynum(leavenum);
				
				Empoutbean.setEmpid(Empinbean.getEmpid());
				Empoutbean.setEmpname(Empinbean.getEmpname());
				Empoutbean.setEmpsex(Empinbean.getEmpsex());
				Empoutbean.setEmpbirth(Empinbean.getEmpbirth());
				Empoutbean.setEmpidcard(Empinbean.getEmpidcard());
				Empoutbean.setEmpdepart(Empinbean.getEmpdepart());
				Empoutbean.setEmppost(Empinbean.getEmppost());
				Empoutbean.setEmpindate(Empinbean.getEmpindate());
				Empoutbean.setEmpinwork(Empinbean.getEmpinwork());
				Empoutbean.setEmptype(Empinbean.getEmptype());
				Empoutbean.setEmpfrom(Empinbean.getEmpfrom());
				Empoutbean.setEmpoutdate(empoutdate);
				Empoutbean.setEmpouttype(empouttype);
				//先在入职表中删除
				Empindao.delemp(Empinbean);
				//将员工插入到离职表
				Empoutdao.addemp(Empoutbean);
				
				//out.println("<script>alert('离职成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allemp");
				//response.sendRedirect(request.getContextPath()+"/Index.jsp");
				//request.getRequestDispatcher("/Index.jsp").forward(request, response);
			} catch (Exception e) {
				//out.println("<script>alert('离职失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allemp");
			}
			
			
		}
		
		if("addemp".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();	
			
			String addnum= request.getParameter("addnum");
			String addname = request.getParameter("addname");
			String addsex = request.getParameter("addsex");
			String addbirth = request.getParameter("addbirth");
			String addidcard = request.getParameter("addidcard");
			String adddepart = request.getParameter("adddepart");
			String addpost = request.getParameter("addpost");
			String addindate = request.getParameter("addindate");
			String addinwork = request.getParameter("addinwork");
			String addtype = request.getParameter("addtype");
			String addfrom = request.getParameter("addfrom");
			
			EmpInBean Empinbean = new EmpInBean();
			Empinbean.setEmpid(addnum);
			Empinbean.setEmpname(addname);
			Empinbean.setEmpsex(addsex);
			Empinbean.setEmpbirth(addbirth);
			Empinbean.setEmpidcard(addidcard);
			Empinbean.setEmpdepart(adddepart);
			Empinbean.setEmppost(addpost);
			Empinbean.setEmpindate(addindate);
			Empinbean.setEmpinwork(addinwork);
			Empinbean.setEmptype(addtype);
			Empinbean.setEmpfrom(addfrom);
			
			EmpInDao Empindao = new EmpInDao();
			try {
				Empindao.addemp(Empinbean);
				//out.println("<script>alert('添加成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allemp");
				//response.sendRedirect(request.getContextPath()+"/Index.jsp");
				//request.getRequestDispatcher("/Index.jsp").forward(request, response);
			} catch (Exception e) {
				//out.println("<script>alert('添加失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allemp");
			}
			
		}
		
		
		if("allpoststaff".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String allpoststaff = request.getParameter("allpoststaff");
			
			EmpInDao EmpIndao = new EmpInDao();
			
			try {
				List i = EmpIndao.fubypostname(allpoststaff); //执行查询所有代码并用i接收
				if(i.size()>0){	
					request.setAttribute("allpoststaffshow",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/allpoststaff.jsp");
					rd.forward(request, response);
					}
				else{
					//out.println("<script>alert('未查询到您要查找数据');location.href='/HR_System/Index.jsp';</script>");//当没有查询到信息时提示错误
					response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
				}
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('未查询到您要查找数据');location.href='/HR_System/Index.jsp';</script>");//当没有查询到信息时提示错误
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
			}
		}
		
		if("alldepartstaff".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String alldepartstaff = request.getParameter("alldepartstaff");
			
			EmpInDao EmpIndao = new EmpInDao();
			
			try {
				List i = EmpIndao.fubydepartname(alldepartstaff); //执行查询所有代码并用i接收
				if(i.size()>0){	
					request.setAttribute("alldepartstaffshow",i);//将获取到的数据添加到findalld中
					RequestDispatcher rd = request.getRequestDispatcher("/files/alldepartstaff.jsp");//跳转到显示所有界面
					rd.forward(request, response);
					}
				else{
					//out.println("<script>alert('未查询到您要查找数据');location.href='/HR_System/Index.jsp';</script>");//当没有查询到信息时提示错误
					response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
				}
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('未查询到您要查找数据');location.href='/HR_System/Index.jsp';</script>");//当没有查询到信息时提示错误
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
			}
		}
		
		if("delpost".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String delpostname = request.getParameter("delpostname");
			
			PostBean Postbean = new PostBean();
			Postbean.setPostname(delpostname);
			
			EmpInBean EmpInbean = new EmpInBean();
			EmpInbean.setEmppost(delpostname);
			
			PostDao Postdao = new PostDao();
			EmpInDao EmpIndao = new EmpInDao();
			
			
			try {
				List i = EmpIndao.fubypostname(delpostname);
				if(i.size()>0){
					//若大于0，则代表该部门存在员工，则不能删除
					response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
				}
				else{
					Postdao.delpost(Postbean);
				//out.println("<script>alert('删除成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
				}
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('删除失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
			}
		}
		
		if("deldepart".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			String deldepartname = request.getParameter("deldepartname");
			System.out.println(deldepartname);
			DepartBean Departbean = new DepartBean();
			Departbean.setDepartname(deldepartname);
			
			EmpInBean EmpInbean = new EmpInBean();
			EmpInbean.setEmpdepart(deldepartname);
			
			DepartDao Departdao = new DepartDao();
			EmpInDao EmpIndao = new EmpInDao();
			
			
			try {
				List i = EmpIndao.fubydepartname(deldepartname);
				if(i.size()>0){
					//若大于0，则代表该部门存在员工，则不能删除
					response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
				}
				else{
					Departdao.deldepart(Departbean);
				//out.println("<script>alert('删除成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
				}
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('删除失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
			}
		}
		

		
		if("toindex".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();		
		
			response.sendRedirect(request.getContextPath()+"/Index.jsp");
		}
		if("login".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();			
			
			String nameString = request.getParameter("userName");
			String pwString = request.getParameter("password");
			
			UserDao userd = new UserDao();
			if (userd.login(nameString, pwString) == 1){
//					RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
//					rd.forward(request, response);	
				response.sendRedirect(request.getContextPath()+"/Index.jsp");
				}
			else{					
//					out.println("<script>alert('不存在该账户或密码错误');</script>");
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}
			}
		
		if("adddepart".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();	
			
			String addnum= request.getParameter("addnum");
			String addname = request.getParameter("addname");
			String addsort = request.getParameter("addsort");
			String addphone = request.getParameter("addphone");
			String addtime = request.getParameter("addtime");
			
//			System.out.println(addnum);
//			System.out.println(addname);
//			System.out.println(addsort);
//			System.out.println(addphone);
//			System.out.println(addtime);
			
			DepartBean Departbean = new DepartBean();
			Departbean.setDepartid(addnum);
			Departbean.setDepartname(addname);			
			Departbean.setDeparttype(addsort);
			Departbean.setDeparttel(addphone);
			Departbean.setDepartst(addtime);
			
			DepartDao Departdao = new DepartDao();
			try {
				Departdao.adddepart(Departbean);
				//out.println("<script>alert('添加成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
				//response.sendRedirect(request.getContextPath()+"/Index.jsp");
				//request.getRequestDispatcher("/Index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('添加失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
			}
			
		}
		if("changedepart".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();	
			
			String addnum = request.getParameter("addnum");
			String addname = request.getParameter("addname");
			String addsort = request.getParameter("addsort");
			String addphone = request.getParameter("addphone");
			String addtime = request.getParameter("addtime");
			
			System.out.println(addnum);
			System.out.println(addname);
			System.out.println(addsort);
			System.out.println(addphone);
			System.out.println(addtime);
			
			DepartBean Departbean = new DepartBean();
			Departbean.setDepartid(addnum);
			Departbean.setDepartname(addname);			
			Departbean.setDeparttype(addsort);
			Departbean.setDeparttel(addphone);
			Departbean.setDepartst(addtime);
			
			DepartDao Departdao = new DepartDao();
			try {
				Departdao.changedepart(Departbean);
				//out.println("<script>alert('修改成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('修改失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=alldepart");
			}
			
		}
		if("changepost".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();	
			
//			String addnum = new String(request.getParameter("addnum").getBytes("ISO-8859-1"),"UTF-8");
//			String addname = new String(request.getParameter("addname").getBytes("ISO-8859-1"),"UTF-8");
//			String addsort = new String(request.getParameter("addsort").getBytes("ISO-8859-1"),"UTF-8");
			
			String addnum = request.getParameter("addnum");
			String addname = request.getParameter("addname");
			String addsort = request.getParameter("addsort");
			
			PostBean Postbean = new PostBean();
			Postbean.setPostid(addnum);
			Postbean.setPostname(addname);			
			Postbean.setPosttype(addsort);
			
			PostDao Postdao = new PostDao();
			try {
				Postdao.changepost(Postbean);
				//out.println("<script>alert('添加成功');location.href='/Depart.jsp';</script>");
				//response.sendRedirect(request.getContextPath()+"/files/Post.jsp");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
				
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('添加失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
			}
			
		}
		if("addpost".equals(method)){
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();	
			
//			String addnum = new String(request.getParameter("addnum").getBytes("ISO-8859-1"),"UTF-8");
//			String addname = new String(request.getParameter("addname").getBytes("ISO-8859-1"),"UTF-8");
//			String addsort = new String(request.getParameter("addsort").getBytes("ISO-8859-1"),"UTF-8");
			
			String addnum = request.getParameter("addnum");
			String addname = request.getParameter("addname");
			String addsort = request.getParameter("addsort");
			

			System.out.println(addnum);
			System.out.println(addname);
			System.out.println(addsort);
			
			PostBean Postbean = new PostBean();
			Postbean.setPostid(addnum);
			Postbean.setPostname(addname);			
			Postbean.setPosttype(addsort);
			
			PostDao Postdao = new PostDao();
			try {
				Postdao.addpost(Postbean);
				//out.println("<script>alert('添加成功');location.href='/Depart.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
				//response.sendRedirect(request.getContextPath()+"/Index.jsp");
				//request.getRequestDispatcher("/Index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				//out.println("<script>alert('添加失败，请重新输入');location.href='/Student/AddStudent.jsp';</script>");
				response.sendRedirect(request.getContextPath()+"/servlet/Action?method=allpost");
			}
			
		}
		if ("allentmagazi".equals(method)) {
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
//			PrintWriter out = response.getWriter();
			String starttime = request.getParameter("starttime")+"-01";
			System.err.println(starttime);
			String endtime = request.getParameter("endtime")+"-31";
			System.err.println(endtime);
			EmpInDao EmpIndao = new EmpInDao();
			try {
				System.out.println(1);
				List i = EmpIndao.fubyintime(starttime, endtime); 
				if (i.size() > 0) {
					request.setAttribute("instaffshow", i);
					RequestDispatcher rd = request
							.getRequestDispatcher("/files/allentmagazi.jsp");
					rd.forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/servlet/Action?method=allemp");
				}
			} catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect(request.getContextPath()
						+ "/servlet/Action?method=allemp");
			}
		}
		
		if ("allleavmagazi".equals(method)) {
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
//			PrintWriter out = response.getWriter();
			String starttime = request.getParameter("starttime")+"-01";
			System.err.println(starttime);
			String endtime = request.getParameter("endtime")+"-31";
			System.err.println(endtime);
			EmpOutDao EmpOutdao = new EmpOutDao();
			try {
				System.out.println("----yuzhi---"+01);
				List i = EmpOutdao.fubyouttime(starttime, endtime); 
				System.out.println("----yuzhi---"+2);
				System.out.println("----yuzhi---"+i.size());
				if (i.size() > 0) {
					request.setAttribute("outstaffshow", i);
					RequestDispatcher rd = request
							.getRequestDispatcher("/files/allleavmagazi.jsp");
					rd.forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/servlet/Action?method=allemp");
				}
			} catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect(request.getContextPath()
						+ "/servlet/Action?method=allemp");
			}
		}

		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>人事管理系统</title>
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/font-awesome.css" />
	<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function(){
    	$(".div2").click(function(){
    		$(this).next("div").slideToggle("slow").siblings(".div3:visible").slideUp("slow");
    	});
    });
    </script>
    <style type="text/css">
    body{ margin:0;font-family:微软雅黑;}
	.left{ width:200px; height:100%; border-right:1px solid #CCCCCC; color:#000000; font-size:14px; text-align:center;background-color: #eafffd;}
	.div1{text-align:center; width:200px; padding-top:10px;}
	.div2{background-color: #53c7a0;height:40px; line-height:40px;cursor: pointer; font-size:13px; position:relative;border-bottom:#ccc 1px dotted;}
	.div3{display: none;cursor:pointer; font-size:13px;}
	.div3 ul{margin:0;padding:0;}
	.div3 li{ height:30px; line-height:30px; list-style:none; border-bottom:#ccc 1px dotted; text-align:center;}
    .div3 li:hover{background-color: #53c7a0;}
    .left_top{font-size: 60px;}
    .left_top img{width: 60px;height: 60px;}
    </style>
</head>
<body>
	<div class="left">
		<div class="div1">
		
			<div>
			    <p class="left_top"><a href=""><i class="fa fa-user fa-fw" aria-hidden="true"></i></a><!-- <img src="../img/ll.png"> --></p>
			    <p>超凡</p>
			    <a href="javascript:parent.window.location.href='../login.jsp';">退出<i class="fa fa-share fa-fw" aria-hidden="true"></i></a>				
			</div>

			<div class="div2"><a href="<%=basePath%>servlet/Action?method=alldepart" target="mainFrame"><i class="fa fa-home fa-fw" aria-hidden="true"></i>部门管理</a></div>
			<div class="div3">
			</div>

			<div class="div2"><a href="<%=basePath%>servlet/Action?method=allpost" target="mainFrame"><i class="fa fa-home fa-fw" aria-hidden="true"></i>岗位管理</a></div>
			<div class="div3">
				<!--<ul>
				<li><a href="addStation.jsp" target="mainFrame" id="add-class"><i class="fa fa-plus fa-fw" aria-hidden="true"></i>新建岗位</a></li>
          		    <li><a href="changeStation.jsp" target="mainFrame" id="add-class"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i>修改岗位</a></li>
                    <li><a href="delStation.jsp" target="mainFrame" id="add-class"><i class="fa fa-trash fa-fw" aria-hidden="true"></i>删除岗位</a></li>
                    <li><a href="refStation.jsp" target="mainFrame" id="add-class"><i class="fa fa-search fa-fw" aria-hidden="true"></i>查询岗位员工</a></li>
				</ul> -->
			</div>

			<div class="div2"><a href="<%=basePath%>servlet/Action?method=allemp" target="mainFrame" id="add-class"><i class="fa fa-users fa-fw" aria-hidden="true"></i>员工管理</a></div>
			<div class="div3">
				<ul>
					<li><a href="addStaff.jsp" target="mainFrame" id="add-class"><i class="fa fa-user-plus fa-fw" aria-hidden="true"></i>员工入职管理</a></li>
					<li><a href="leavStaff.jsp" target="mainFrame" id="add-class"><i class="fa fa-user-times fa-fw" aria-hidden="true"></i>员工离职管理</a></li>
					<li><a href="<%=basePath%>servlet/Action?method=alloutemp" target="mainFrame" id="add-class"><i class="fa fa-user-times fa-fw" aria-hidden="true"></i>所有离职员工</a></li>
				</ul>
			</div>

			<div class="div2"><i class="fa fa-newspaper-o fa-fw" aria-hidden="true"></i>报表管理</div>
			<div class="div3">
				<ul>
					<li><a href="entmagazi.jsp" target="mainFrame" id="add-class"><i class="fa fa-map-o fa-fw" aria-hidden="true"></i>入职员工报表</a></li>
					<li><a href="leavmagazi.jsp" target="mainFrame" id="add-class"><i class="fa fa-map-o fa-fw" aria-hidden="true"></i>离职员工报表</a></li>
					<li><a href="monmagazi.jsp" target="mainFrame" id="add-class"><i class="fa fa-map-o fa-fw" aria-hidden="true"></i>人事月报</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
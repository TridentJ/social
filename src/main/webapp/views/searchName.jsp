<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社工库查询--按姓名查询</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css"/> 
<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/compiled/theme_styles.css"/>
<link rel="stylesheet" href="css/google.api.css" type="text/css"/>
</head>
<body>
<div id="theme-wrapper">
	<%@ include file="header.jsp" %>
	<!-- 页面内容 -->
	<div id="page-wrapper" class="container">
		<div class="row">
			<!-- 左侧导航栏 -->
			<div id="nav-col">
				<%@ include file="nav.jsp" %>
			</div>
			<!-- 右侧内容 -->
			<div id="content-wrapper">
				<div class="row">
				<div class="col-lg-12">
					<ol class="breadcrumb">
					<li><a href="searchName.htm">按姓名查询</a></li>
					<li class="active"><span>详情</span></li>
					</ol>
				</div>
				</div>
				<div class="row">
				<div class="col-md-12">
					<div class="main-box">
						<form>
							<div class="col-md-5 col-md-offset-2">
								<input type="text" class="form-control" id="name" placeholder="输入姓名" value="${search}">
							</div>
							<div class="col-md-3">
								<button type="button" id="search_button" class="btn btn-success" onclick="searchByName(0)"><i class="fa fa-search"></i>&nbsp;精确查询</button>
								<button type="button" id="search_button_fuzzy" class="btn btn-danger" onclick="searchByName(1)" disabled><i class="fa fa-users"></i>&nbsp;模糊查询</button>
							</div>
						</form>
					</div>
				</div>
				</div>
				<br/>
				<br/>
				<div class="row">
				<div class="col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2">
					<div class="alert alert-warning hidden" id="alert_div">
						<a href="#" class="close" data-dismiss="alert">
							&times;
						</a>
						查询<strong id="alert_strong" class="red"></strong>失败！原因：<label id="alert_label"></label>
					</div>
				</div>
				</div>
				<div class="row">
				<div class="col-md-12 col-lg-12">
				<div class="main-box clearfix hidden" id="mb">
					<div class="main-box-header">
						<h2 class="pull-left red"><strong>查询结果</strong></h2>
					</div>
					<div class="main-box-body clearfix" id="div_table">
						
					</div>
				</div>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/scripts.js"></script>
<script src="js/social/searchName.js"></script>
<script type="text/javascript">
	function setActive(){
		$("#id_database").addClass("open active");
		$("#search_name").addClass("active");
	};
	setActive();
	
	document.onkeydown = function(e){
		if(!e){
			e = window.event;
		}
		if(event.keyCode == 13){
			document.getElementById("search_button").click();
			return false;
		}
	}
</script>

</body>
</html>
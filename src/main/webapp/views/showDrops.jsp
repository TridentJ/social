<%@page import="org.apache.log4j.pattern.IntegerPatternConverter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css"/> 
<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/compiled/theme_styles.css"/>
<link rel="stylesheet" href="css/google.api.css" type="text/css"/>
<link rel="stylesheet" href="css/img.css" type="text/css"/>
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
				<div class="col-md-12 col-lg-12">
					<div class="panel panel-success hidden" id="panel_div">
						<div class="panel-heading">
							<h1 class="panel-title title" id="drops_title"></h1>
							<input type="hidden" id="drops_id" value="${id}">
							作者：<span id="drops_author"></span>
						</div>
						<div class="panel-body">
							<div id="drops_content">
								
							</div>
						</div>
					</div>
				</div>
				</div>
				<br/>
				<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="alert alert-warning hidden" id="alert_div">
						<a href="#" class="close" data-dismiss="alert">
							&times;
						</a>
						<strong class="red">读取知识库失败！</strong><label id="alert_label"></label>
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
<script src="js/raphael-min.js"></script>

<script type="text/javascript">
	function setActive(){
		$("#id_drops").addClass("open active");
		$("#wy_drops").addClass("active")
	};
	setActive();
	
	function getDropsById(){
		dropsId = $("#drops_id").val();
		
		$.ajax({
			type:'POST',
			url:'getDropsById.htm',
			data:{
				'id':dropsId
			},
			success:function(res){
				if(res.code != 0){
					$("#alert_div").removeClass("hidden");
					$("#alert_label").html(res.msg);
				}else{
					drops = res.content;
					$("#drops_title").html(drops.title);
					$("#drops_author").html(drops.author);
					//$("#drops_content").html(drops.content);
					document.getElementById("drops_content").innerHTML = drops.content;
					$("#panel_div").removeClass("hidden");
					
				}
			}
		});
	}
	getDropsById();
</script>

</body>
</html>
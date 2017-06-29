<%@page import="org.apache.log4j.pattern.IntegerPatternConverter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>乌云知识库</title>
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
				<div class="col-md-12 col-lg-12">
					<div class="panel-group accordion" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
							<label>查询条件</label>
							</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse">
							<div class="panel-body">
								<form>
									<div class="row">
										<div class="col-md-6 col-lg-6">
											<label for="drops_title">标题</label>
											<input type="text" id="drops_title" class="form-control"  placeholder="标题"/>
										</div>
										<div class="col-md-6 col-lg-6">
											<label for="drops_author">作者</label>
											<input type="text" id="drops_author" class="form-control" placeholder="作者"/>
										</div>
									</div>
									<div>
										<br/>
										<div class="col-md-8 col-lg-8">
											<button type="button" id="note_button" class="btn btn-success" onclick="searchDrops(1)" ><i class="fa fa-search"> </i>&nbsp;条件查询</button>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<button type="button" id="note_button_cls" class="btn btn-danger" onclick="getAllDrops(1)"><i class="fa fa-eraser"> </i>&nbsp;清除查询</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					</div>
				</div>
				</div>
				
				<div class="row">
				<div class="col-md-6 col-lg-6 col-md-offset-3 col-lg-offset-3">
					<div class="alert alert-warning hidden" id="alert_div">
						<a href="#" class="close" data-dismiss="alert">
							&times;
						</a>
						<strong class="red">读取知识库失败！</strong><label id="alert_label"></label>
					</div>
				</div>
				</div>
				
				
				<div class="row">
				<div class="col-md-12 col-lg-12">
				<div class="main-box hidden" id="div_result">
					<ul id="search_results" class="widget-products">
						
					</ul>
					<ul class="pagination">
						
					</ul>
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
	
	function getAllDrops(pageNum){
		var pageSize = 15;
		$("#drops_title").val("");
		$("#drops_author").val("");
		$.ajax({
			type:'POST',
			url:'getAllDrops.htm',
			data:{
				'pageNum':pageNum,
				'pageSize':pageSize
			},
			success:function(data){
				if(data.code != 0 ){
					$("#alert_div").removeClass("hidden");
					$("#alert_label").html(data.msg);
				}else{
					$("#search_results").html("")
					$("#pagination").html("");
					res = data.content;
					jQuery.each(
						res,function(key,value){
							/*
							$("#search_results").append("<div class=\"col-md-12\"><h2 class=\"title\"><a href=\"showDrops.htm?id=" + value.id + "\">" + value.title + "</a></h2>" + 
									"<div class=\"clearfix\">" + 
									"<div class=\"meta-info\">作者：<span>" + value.author + "</span> 时间：<span>" + value.createTime + "</span>" +
									"<div class=\"link-title\"></div>" +
									"</div></div></div><br/>"
							);
							*/
							$("#search_results").append('<li><a href="showDrops.htm?id=' + value.id + '"><span><h2>'+
									'<span class="title">' + value.title + '</h2></span><span id="author"><i class="fa fa-user"></i>作者：' + value.author + '</span>' + 
									'&nbsp;&nbsp;&nbsp;&nbsp;<span id="read"><i class="fa fa-eye"></i>阅读量：' + value.num + '</span></span></a></li>');
						}		
					);
					if(pageNum == 1){
						$("#a_left").addClass="disable";
						$(".pagination").html("<li><a href=\"#\" class=\"disabled\">&laquo;</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:getAllDrops(1)\">1</a></li>" + 
							"<li><a href=\"javascript:getAllDrops(2)\">2</a></li><li><a href=\"javascript:getAllDrops(3)\">3</a></li>" + 
							"<li><a href=\"javascript:getAllDrops(4)\">4</a></li>" + "<li><a href=\"javascript:getAllDrops(5)\">5</a></li>" + 
							"<li><a href=\"javascript:getAllDrops(2)\">&raquo;</a></li>"
						);
					}else if(pageNum == 2){
						$(".pagination").html("<li><a href=\"javascript:getAllDrops(1)\">&laquo;</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(1)\">1</a></li>" + 
								"<li class=\"active\"><a href=\"javascript:getAllDrops(2)\">2</a></li>" +
								"<li><a href=\"javascript:getAllDrops(3)\">3</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(4)\">4</a></li>" + "<li><a href=\"getAllDrops(5)\">5</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(3)\">&raquo;</a></li>"
							);
					}else{
						$(".pagination").html("<li><a href=\"javascript:getAllDrops(" + (pageNum-2) + ")\">&laquo;</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(" + (pageNum-2) + ")\">" + (pageNum-2) + "</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(" + (pageNum-1) + ")\">" + (pageNum-1) + "</a></li>" + 
								"<li class=\"active\"><a href=\"javascript:getAllDrops(" + pageNum + ")\">" + pageNum + "</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(" + (pageNum+1) + ")\">" + (pageNum+1) + "</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(" + (pageNum+2) + ")\">" + (pageNum+2) + "</a></li>" + 
								"<li><a href=\"javascript:getAllDrops(" + (pageNum+1) + ")\">&raquo;</a></li>"
							);
					}
				
				}
				$("#div_result").removeClass("hidden");
			}
		});
	}
	getAllDrops(1);
	
	
	function searchDrops(pageNum){
		var title = $("#drops_title").val();
		var author = $("#drops_author").val();
		var pageSize = 15;
		$.ajax({
			type:'POST',
			url:'searchDrops.htm',
			data:{
				'title':title,
				'author':author,
				'pageNum':pageNum,
				'pageSize':pageSize
			},
			success:function(data){
				if(data.code != 0 ){
					$("#alert_div").removeClass("hidden");
					$("#alert_label").html(data.msg);
				}else{
					$("#search_results").html("")
					$("#pagination").html("");
					res = data.content;
					jQuery.each(
						res,function(key,value){
							$("#search_results").append('<li><a href="showDrops.htm?id=' + value.id + '"><span><h2>'+
									'<span class="title">' + value.title + '</h2></span><span id="author"><i class="fa fa-user"></i>作者：' + value.author + '</span>' + 
									'&nbsp;&nbsp;&nbsp;&nbsp;<span id="read"><i class="fa fa-eye"></i>阅读量：' + value.num + '</span></span></a></li>');
						}		
					);
					if(pageNum == 1){
						$("#a_left").addClass="disable";
						$(".pagination").html("<li><a href=\"#\" class=\"disabled\">&laquo;</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:searchDrops(1)\">1</a></li>" + 
							"<li><a href=\"javascript:searchDrops(2)\">2</a></li><li><a href=\"javascript:searchDrops(3)\">3</a></li>" + 
							"<li><a href=\"javascript:searchDrops(4)\">4</a></li>" + "<li><a href=\"javascript:searchDrops(5)\">5</a></li>" + 
							"<li><a href=\"#\">&raquo;</a></li>"
						);
					}else if(pageNum == 2){
						$(".pagination").html("<li><a href=\"javascript:searchDrops(1)\">&laquo;</a></li>" + 
								"<li><a href=\"javascript:searchDrops(1)\">1</a></li>" + 
								"<li class=\"active\"><a href=\"javascript:searchDrops(2)\">2</a></li>" +
								"<li><a href=\"javascript:searchDrops(3)\">3</a></li>" + 
								"<li><a href=\"javascript:searchDrops(4)\">4</a></li>" + "<li><a href=\"searchDrops(5)\">5</a></li>" + 
								"<li><a href=\"javascript:searchDrops(3)\">&raquo;</a></li>"
							);
					}else{
						$(".pagination").html("<li><a href=\"javascript:searchDrops(" + (pageNum-2) + ")\">&laquo;</a></li>" + 
								"<li><a href=\"javascript:searchDrops(" + (pageNum-2) + ")\">" + (pageNum-2) + "</a></li>" + 
								"<li><a href=\"javascript:searchDrops(" + (pageNum-1) + ")\">" + (pageNum-1) + "</a></li>" + 
								"<li class=\"active\"><a href=\"javascript:searchDrops(" + pageNum + ")\">" + pageNum + "</a></li>" + 
								"<li><a href=\"javascript:searchDrops(" + (pageNum+1) + ")\">" + (pageNum+1) + "</a></li>" + 
								"<li><a href=\"javascript:searchDrops(" + (pageNum+2) + ")\">" + (pageNum+2) + "</a></li>" + 
								"<li><a href=\"javascript:searchDrops(" + (pageNum+1) + ")\">&raquo;</a></li>"
							);
					}
					
				}
				$("#div_result").removeClass("hidden");
			}
		});
	}
	
</script>

</body>
</html>
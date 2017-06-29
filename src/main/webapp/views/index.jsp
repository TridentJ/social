<%@page import="org.apache.log4j.pattern.IntegerPatternConverter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css"/> 
<link rel="stylesheet" type="text/css" href="css/libs/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/compiled/theme_styles.css"/>
<link rel="stylesheet" href="css/google.api.css" type="text/css"/>
<link rel="stylesheet" href="css/libs/morris.css" type="text/css"/>
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
					<div class="row">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="main-box infographic-box">
							<i class="fa fa-database red-bg"></i>
							<span class="headline">记录条数</span>
							<span class="value">
							${socialRecord.recordNum}
							</span>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="main-box infographic-box">
							<i class="fa fa-sort-numeric-asc emerald-bg"></i>
							<span class="headline">查询次数</span>
							<span class="value">
							${socialRecord.selectNum}
							</span>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="main-box infographic-box">
							<i class="fa fa-flag green-bg"></i>
							<span class="headline">命中率</span>
							<span class="value">
							<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
							<fmt:formatNumber type="num" value="${(socialRecord.hitNum/socialRecord.selectNum)*100}" pattern="0.00" maxFractionDigits="2"/>
							&#37;
							</span>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="main-box infographic-box">
							<i class="fa fa-eye yellow-bg"></i>
							<span class="headline">知识库浏览量</span>
							<span class="value">
							${socialRecord.dropsNum}
							</span>
							</div>
						</div>
					</div>
					<div class="row">
					<div class="col-md-12 col-lg-12">
						<div class="main-box">
							<div class="graph-box emerald-bg">
							<h2>社工库查询量</h2>
							<div class="graph" id="social-line" style="max-height: 335px;"></div>
							</div>
							
						</div>
					</div>
					</div>
					<div class="row">
					<div class="col-md-12 col-lg-12">
					<div class="main-box">
						<div class="main-box-header">
							<h2 class="pull-left red"><strong>最近查询记录</strong></h2>
						</div>
						<div class="main-box-body clearfix">
							<table class="table">
								<thead>
									<tr>
									<th class="text-center"><span>ID</span></th>
									<th class="text-center"><span>搜索内容</span></th>
									<th class="text-center"><span>搜索时间</span></th>
									<th class="text-center"><span>类型</span></th>
									<th class="text-center"><span>命中</span></th>
									</tr>
								</thead>
								<tbody>
									<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
									<c:forEach items="${history}" var="record">
										<tr>
											<td class="text-center">${record.id}</td>
											<td class="text-center"><a href="searchDetail.htm?content=${record.content}&type=${record.type}">${record.content }</a></td>
											<td class="text-center">${record.time}</td>
											<td class="text-center">
											<c:choose>
												<c:when test="${record.type == 1}">
												邮箱
												</c:when>
												<c:when test="${record.type == 2}">
												手机
												</c:when>
												<c:when test="${record.type == 3}">
												身份证
												</c:when>
												<c:when test="${record.type == 4}">
												用户名
												</c:when>
											</c:choose>
											</td>
											<c:choose>
												<c:when test="${record.hit == 1}">
													<td class="text-center"><span class="label label-success">是</span></td>
												</c:when>
												<c:when test="${record.hit == 0}">
													<td class="text-center"><span class="label label-danger">否</span></td>
												</c:when>
												<c:otherwise>
													<td class="text-center"><span class="label label-warning">未知</span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					</div>
					</div>
					<div class="row">
					<div class="col-md-12 col-lg-12">
						<div class="main-box">
							<div class="graph-box emerald-bg">
							<h2>知识库阅读量</h2>
							<div class="graph" id="drops-line" style="max-height: 335px;"></div>
							</div>
							
						</div>
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-12 col-lg-12">
					<div class="main-box">
						<div class="main-box-header">
							<h2 class="pull-left red"><strong>热门文章TOP10</strong></h2>
						</div>
						<div class="main-box-body clearfix">
							<table class="table">
								<thead>
									<tr>
									<th class="text-center"><span>ID</span></th>
									<th class="text-center"><span>标题</span></th>
									<th class="text-center"><span>作者</span></th>
									<th class="text-center"><span>阅读量</span></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${dropsHistory}" var="record">
										<tr>
											<td class="text-center">${record.id}</td>
											<td class="text-center"><a href="showDrops.htm?id=${record.id}">${record.title }</a></td>
											<td class="text-center">${record.author}</td>
											<td class="text-center">${record.num}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
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
<script src="js/raphael-min.js"></script>
<script src="js/morris.min.js"></script>

<script type="text/javascript">
	function setActive(){
		$("#id_index").addClass("open active");
	};
	setActive();
	
	function getSocialCount(){
		$.ajax({
			type:'POST',
			url:'getSocialCount.htm',
			data:{
				
			},
			success:function(res){
				if(res.code == 0){
					sData = res.content;
					graphLine = Morris.Line({
						element: 'social-line',
						data:sData,
						lineColors: ['#ff44ff'],
						xkey: 'date',
						ykeys: ['num'],
						labels: ['查询量'],
						pointSize: 3,
						parseTime:false,
						hideHover: 'auto',
						gridTextColor: '#ffffff',
						gridLineColor: 'rgba(255, 255, 255, 0.3)',
						resize: true
					});	
				}else{
					alert(res.msg);
				}
			}
		});
		
	}
	getSocialCount();
	
	function getWyCount(){
		$.ajax({
			type:'POST',
			url:'getWyCount.htm',
			data:{
				
			},
			success:function(res){
				if(res.code == 0){
					sData = res.content;
					graphLine2 = Morris.Line({
						element: 'drops-line',
						data: sData,
						lineColors: ['#ff2d2d'],
						xkey: 'date',
						ykeys: ['num'],
						labels: ['阅读量'],
						pointSize: 3,
						parseTime:false,
						hideHover: 'auto',
						gridTextColor: '#ffffff',
						gridLineColor: 'rgba(255, 255, 255, 0.3)',
						resize: true
					});
				}else{
					alert(res.msg);
				}
			}
		});
	}
	getWyCount();
	
	
</script>

</body>
</html>
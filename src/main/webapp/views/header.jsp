<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="navbar" id="header-navbar">
	<div class="container">
	<a href="index.htm" id="logo" class="navbar-brand">
		<img src="img/1.png" alt="" class="normal-logo logo-white"/>
		<span class="content">社工库平台</span>
	</a>
	<div class="clearfix">
	<button class="navbar-toggle" data-target=".navbar-ex1-collapse" data-toggle="collapse" type="button">
	<span class="sr-only">Toggle navigation</span>
	<span class="fa fa-bars"></span>
	</button>
	<div class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
		<ul class="nav navbar-nav pull-left">
			<li>
			<a class="btn" id="make-small-nav">
			<i class="fa fa-bars"></i>
			</a>
			</li>
		</ul>
	</div>
	<div class="nav-no-collapse pull-right" id="header-nav">
	<ul class="nav navbar-nav pull-right">
		<li class="mobile-search">
			<a class="btn">
			<i class="fa fa-search"></i>
			</a>
			<div class="drowdown-search">
			<form role="search">
			<div class="form-group">
			<input type="text" class="form-control" placeholder="Search...">
			<i class="fa fa-search nav-search-icon"></i>
			</div>
			</form>
			</div>
		</li>
		 
		<li class="dropdown hidden-xs">
			<a class="btn dropdown-toggle" data-toggle="dropdown">
			<i class="fa fa-envelope-o"></i>
			<span class="count">2</span>
			</a>
			<ul class="dropdown-menu notifications-list">
			<li class="pointer">
			<div class="pointer-inner">
			<div class="arrow"></div>
			</div>
			</li>
			<li class="item-header">你有2条新消息</li>
			
			
			<li class="item">
			<a href="#">
			<i class="fa fa-envelope"></i>
			<span class="content">来自XXX的新消息</span>
			<span class="time"><i class="fa fa-clock-o"></i>13 min.</span>
			</a>
			</li>
			<li class="item">
			<a href="#">
			<i class="fa fa-envelope"></i>
			<span class="content">机器就要爆炸了</span>
			<span class="time"><i class="fa fa-clock-o"></i>36 min.</span>
			</a>
			</li>
			
			<li class="item-footer">
			<a href="#">
			<span class="content">查看所有消息</span>
			</a>
			</li>
			</ul>
		</li>
		<li class="dropdown hidden-xs">
			<a class="btn dropdown-toggle" data-toggle="dropdown">
			<i class="fa fa-exchange"></i>
			</a>
			<ul id="skin-colors" class="dropdown-menu notifications-list">
				<li class="pointer">
					<div class="pointer-inner">
						<div class="arrow"></div>
					</div>
				</li>
				<li class="item-header">选择主题</li>
				<li class="item">
					<a onclick="changeSkin('default')"   href="javascript:;" style="background-color: #34495e;">
						<span>Default</span>
						<span></span>
					</a>
				</li>
				<li class="item">
					<a onclick="changeSkin('theme-white')" style="background-color: #2ecc71;" href="javascript:;">
						White/Green
					</a>
				</li>
				<li class="item">
					<a onclick="changeSkin('theme-blue-gradient')" href="javascript:;">
						Gradient
					</a>
				</li>
				<li class="item">
					<a onclick="changeSkin('theme-turquoise')" style="background-color: #1abc9c;" href="javascript:;">
						Green Sea
					</a>
				</li>
				<li class="item">
					<a onclick="changeSkin('theme-amethyst')" style="background-color: #9b59b6;" href="javascript:;">
						Amethyst
					</a>
				</li>
				<li class="item">
					<a onclick="changeSkin('theme-blue')" style="background-color: #2980b9;" href="javascript:;">
						Blue
					</a>
				</li>
				<li class="item">
					<a onclick="changeSkin('theme-red')" style="background-color: #e74c3c;" href="javascript:;">
						Red
					</a>
				</li>
				<li class="item">
					<a style="background-color: #3498db;" onclick="changeSkin('theme-whbl')"  href="javascript:;">
					White/Blue
					</a>
				</li>
			</ul>
		</li>
		<li class="dropdown profile-dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			<img src="img/miao.png" alt=""/>
			<span class="hidden-xs"><%=session.getAttribute("username") %></span> <b class="caret"></b>
			</a>
			<ul class="dropdown-menu">
			<li><a href="#"><i class="fa fa-cog"></i>设置</a></li>
			<li><a href="#"><i class="fa fa-envelope-o"></i>消息</a></li>
			<li><a href="logout"><i class="fa fa-power-off"></i>登出</a></li>
			</ul>
		</li>
		<li class="hidden-xxs">
			<a class="btn" href="logout">
			<i class="fa fa-power-off"></i>
			</a>
		</li>
	</ul>
	</div>
	</div>
	</div>
</header>
<script type="text/javascript">
	function changeSkin(theme){
		document.body.className=theme;
	}
	document.body.className='theme-whbl';
</script>
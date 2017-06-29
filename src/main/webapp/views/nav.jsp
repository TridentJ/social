<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="col-left" class="col-left-nano">
<div id="col-left-inner" class="col-left-nano-content">
<div id="user-left-box" class="clearfix hidden-sm hidden-xs">
<img alt="" src="img/miao.png"/>
<div class="user-box">
<span class="name">
<%=session.getAttribute("username") %>
</span>
<span class="status">
<i class="fa fa-circle"></i> 在线
</span>
</div>
</div>
<div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar-nav">
<ul class="nav nav-pills nav-stacked">
	<li id="id_index">
		<a href="index.htm">
		<i class="fa fa-home"></i>
		<span>首页</span>
		</a>
	</li>
	
	<li id="id_database">
		<a href="#" class="dropdown-toggle">
		<i class="fa fa-database"></i>
		<span>社工库管理</span>
		<i class="fa fa-chevron-circle-right drop-icon"></i>
		</a>
		<ul class="submenu">
			<li id="search_mail">
				<a href="searchMail.htm">
				邮箱查询
				</a>
			</li>
			<li id="search_phone">
				<a href="searchPhone.htm">
				手机号查询
				</a>
			</li>
			<li id="search_id">
				<a href="searchId.htm">
				身份证查询
				</a>
			</li>
			<li id="search_name">
				<a href="searchName.htm">
				姓名查询
				</a>
			</li>
		</ul>
	</li>
	<li id="id_drops">
		<a href="#" class="dropdown-toggle">
		<i class="fa fa-briefcase"></i>
		<span>知识库</span>
		<i class="fa fa-chevron-circle-right drop-icon"></i>
		</a>
		<ul class="submenu">
			<li id="wy_drops">
				<a href="wyDrops.htm">
				乌云知识库
				</a>
			</li>
			<li id="other_drops">
				<a href="#">
				其他知识库
				</a>
			</li>
			
		</ul>
	</li>
</ul>
</div>
</div>
</section>
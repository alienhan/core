<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<style>
#base_accordion {
	padding: 0px;
	margin: 0px;
	width: 100%;
	height: 600px;
	font-size: 15px;
}

#base_menu {
	margin: 0px;
	padding: 0px;
	width: 99%;
	min-height: 150px;
	font-size: 15px;
}

#base_menu li {
	margin-top: 5px;
	padding: 0,3px,0,3px;
}

#base_menu li span {
	margin-left: 35px;
	font-size: 15px;
}
</style>

<script>
	$(function() {
		$("#base_accordion").accordion({
			collapsible : true
		});
		
		$(".base_menu_menu").menu();
		$(".base_menu_user").menu();
		$(".base_menu_others").menu();
		
	});
</script>


<div id="base_accordion">
	<h4>菜单管理</h4>
	<ul id="base_menu" class="base_menu_menu">
		<li><span>菜单管理</span></li>
		<li><span>菜单权限管理</span></li>
	</ul>
	<h4>用户管理</h4>
	<ul id="base_menu" class="base_menu_user">
		<li><span>用户添加</span></li>
		<li><span>用户查询</span></li>
		<li><span>用户删除</span></li>
	</ul>
	<h4>系统管理</h4>
	<ul id="base_menu" class="base_menu_others">
		<li><span>系统添加</span></li>
		<li><span>系统查询</span></li>
		<li><span>系统删除</span></li>
	</ul>

</div>
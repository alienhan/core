<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>

* {
	font-family: Verdana, Geneva, sans-serif;
}

#base_accordion {
	margin: 0px;
	padding: 0px;
	font-size: 15px;
	color: #626262;
	overflow-x: hidden;
}

#base_menu {
	margin: 0px;
	padding: 0px;
	width: 99%;
	min-height: 150px;
	font-size: 15px;
	overflow: hidden;
}

.base_nav {
	margin: 0px;
	padding: 0px;
	overflow: visible;
}

.base_nav dl {
	margin: 0px;
	padding: 0px;
	border-bottom: 1px solid #CCCCCC;
}

.base_nav dl dt {
	margin: 0px;
	padding: 10px 0px 0px 30px;
	height: 30px;
	cursor: pointer;
	background-size: 100%;
	background: url(/core/static/image/menu/menu_dt.jpg) repeat;
}

.base_nav dl dd {
	margin: 0px;
	padding: 5px 0px 5px 30px;
	height: 20px;
	cursor: pointer;
}
</style>

<script type="text/javascript">
	$(function() {
		$(".base_nav dd").hide();
		$(".base_nav dt").click(function() {
			$(this).parent().find('dd').removeClass("menu_chioce");
			$(".menu_chioce").slideUp();
			$(this).parent().find('dd').slideToggle();
			//$(this).parent().find('dd').addClass("menu_chioce");
		});
	});
</script>

<div id="base_accordion">

	<div id="base_nav" class="base_nav">
		<dl>
			<dt>
				菜单管理<img src="/core/static/image/select_xl01.png">
			</dt>
			<dd>菜单管理</dd>
			<dd>菜单权限管理</dd>
			<dd>
				<span><a href="/core/module/list_module">菜单模型管理</a></span>
			</dd>
		</dl>

		<dl>
			<dt>用户管理</dt>
			<dd>
				<span><a href="/core/userType/list_userType">用户类型管理</a></span>
			</dd>
			<dd>用户查询</dd>
			<dd>用户删除</dd>
		</dl>
	</div>
</div>
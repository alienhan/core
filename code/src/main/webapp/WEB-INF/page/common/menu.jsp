<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
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
	padding: 13px 0px 0px 30px;
	height: 30px;
	cursor: pointer;
	background-color: #F9F9FA;
	background: -webkit-linear-gradient(#FDFDFD, #F0F0F1);/* Safari 5.1 - 6.0 */
	background: -o-linear-gradient(#FDFDFD, #F0F0F1);/* Opera 11.1 - 12.0 */
	background: -moz-linear-gradient(#FDFDFD, #F0F0F1);/* Firefox 3.6 - 15 */
	background: linear-gradient(#FDFDFD, #F0F0F1); /* 标准的语法 */
	box-shadow: 1px 1px 3px #CCCCCC;
	position: relative;
}

.base_nav dl dt img {
	position: absolute;
	right: 10px;
	top: 18px;
}

.base_nav dl dd {
	margin: 0px;
	height: 40px;
	cursor: pointer;
	background-color: #FAFAFA;
	position: relative;
}

.base_nav dl dd span {
	position: absolute;
	left: 30px;
	top: 11px;
}

.base_nav dl dd img {
	position: absolute;
	left: 7px;
	top: 12px;
}

.base_nav dl dd div {
	height: 40px;
	width: 3px;
}
</style>

<script type="text/javascript">
$(function() {
	
	//隐藏下拉菜单
	$(".base_nav dd").hide();

	//菜单默认背景
	$(".base_nav dt").find('img').attr("src",
			"${ basePath}static/image/menu/menu_select.jpg");
	$(".base_nav dd").find('img').attr("src",
			"${ basePath}static/image/menu/menu_dd.jpg");
	
	
	//跟踪路径显示选择页面位置
	$(".base_nav dd span a").each( function() {
		var href =  window.location.href.toString();
		if(href.indexOf("?") != -1){
			href = href.substring(0, href.indexOf("?"));
		}
		
		if($(this).attr("href") == href){
			$(this).parent().parent().parent().find('dt').find('img').attr("src", "${ basePath}static/image/menu/menu_select1.jpg");
			$(this).parent().parent().parent().find('dd').show();
			
			$(this).parent().parent().find("img").attr("src",
			"${ basePath}static/image/menu/menu_dd1.jpg");
			$(this).parent().parent().css({
				"background-color" : "#D2D2DD"
			});

			$(this).parent().parent().find("div").css({
				"background-color" : "#8989A6"
			});
			
		} 
		
	});

	//显示下拉菜单
	$(".base_nav dt").click( function() {
		if ($(this).find('img').attr("src") == "${ basePath}static/image/menu/menu_select1.jpg") {
			$(this).find('img').attr("src",
							"${ basePath}static/image/menu/menu_select.jpg");
		} else {
			$(this).find('img').attr("src",
							"${ basePath}static/image/menu/menu_select1.jpg");
		}
		$(this).parent().find('dd').slideToggle();
	});

	//鼠标悬停改变背景颜色
	$(".base_nav dd").mouseover( function() {
		
		//初始化所有的背景颜色
		$(".base_nav dd").find("img").attr("src",
		"${ basePath}static/image/menu/menu_dd.jpg");
		$(".base_nav dd").css({
			"background-color" : "#FAFAFA"
		});
		$(".base_nav dd").find("div").css({
			"background-color" : "#FAFAFA"
		});
		
		//改变颜色
		$(this).find("img").attr("src",
				"${ basePath}static/image/menu/menu_dd1.jpg");
		$(this).css({
			"background-color" : "#D2D2DD"
		});

		$(this).find("div").css({
			"background-color" : "#8989A6"
		});

	});

	//鼠标离开改变背景颜色
	$(".base_nav dd").mouseleave( function() {
		$(this).find("img").attr("src",
				"${ basePath}static/image/menu/menu_dd.jpg");
		$(this).css({
			"background-color" : "#FAFAFA"
		});
		$(this).find("div").css({
			"background-color" : "#FAFAFA"
		});
	});
});

//菜单跳转
function menu(to) {
	window.location = to;
}
</script>

<div id="base_accordion">

	<div id="base_nav" class="base_nav">
		<dl>
			<dt>
				<span>菜单管理</span><img />
			</dt>
			<dd>
				<div></div><img />
				<span>菜单内容管理</span>
			</dd>
			<dd>
				<div></div><img /> 
				<span>菜单权限管理</span>
			</dd>
			<dd>
				<div></div><img /> 
				<span><a href="${ basePath}module/list_module" >菜单模型管理</a></span>
			</dd>
		</dl>

		<dl>
			<dt>
				<span>用户管理</span><img />
			</dt>
			<dd>
				<div></div><img />
				<span><a href="${ basePath}userType/list_userType">用户类型管理</a></span>
			</dd>
			<dd>
				<div></div><img /> 
				<span><a href="${ basePath}user/list_user">用户内容管理</a></span>
			</dd>
			<dd>
				<div></div><img />
				<span>用户删除</span>
			</dd>
		</dl>
	</div>
</div>
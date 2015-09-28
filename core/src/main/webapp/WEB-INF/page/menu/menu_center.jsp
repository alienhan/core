<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style type="text/css">
</style>

<div class="bmh menu_manager_header">
	<div class="bmt menu_manager_theme">菜单管理</div>
	<div></div>
</div>
<div class="muc">
	<div class="btd">
		<div class="bth menu_table_header">
			<button type="button" class="bta menu_add">添&nbsp;&nbsp;加</button>
		</div>
		<table class="bt menu_table">
			<tr>
				<th>菜单名字</th>
				<th>菜单地址</th>
				<th>菜单函数</th>
				<th>菜单位置</th>
			</tr>
			<tr>
				<td>菜单管理</td>
				<td>menu/menu_manage</td>
				<td>func</td>
				<td>position</td>
			</tr>
			<tr>
				<td>用户管理</td>
				<td>user/user_manage</td>
				<td>func_user</td>
				<td>position_user</td>
			</tr>
			<c:forEach begin="1" end="8">
				<tr>
					<td>用户管理</td>
					<td>user/user_manage</td>
					<td>func_user</td>
					<td>position_user</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btf menu_table_footer">
			<a href="#" class="base_table_pre">上一页</a>
			<a href="#" class="base_table_next">下一页</a>
			<span>共:xx页</span>
		</div>
	</div>

</div>
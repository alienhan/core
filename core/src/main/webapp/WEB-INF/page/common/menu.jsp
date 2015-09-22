<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>

<div id="accordion">
	<h3>菜单管理</h3>
	<div></div>
	<h3>用户管理</h3>
	<div>
		<p>user</p>
	</div>
	<h3>其他</h3>
	<div>
		<ul>
			<li>List item one</li>
			<li>List item two</li>
			<li>List item three</li>
		</ul>
	</div>
</div>
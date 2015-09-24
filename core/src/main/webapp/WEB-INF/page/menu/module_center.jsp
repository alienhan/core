<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="bmh module_manager_header">
	<div class="bmt module_manager_theme">菜单模型管理</div>
	<div></div>
</div>
<div class="module_manager_content">
	<div class="base_table_parent">
		<div class="base_table_header module_table_header">
			<button type="button" class="base_table_add module_add">添&nbsp;&nbsp;加</button>
			<button type="button" class="base_table_delete module_delete">删&nbsp;&nbsp;除</button>
		</div>
		<table class="base_table module_table">
			<tr>
				<th>菜单模型id</th>
				<th>菜单模型名字</th>
				<th>菜单模型标签</th>
			</tr>
			<c:forEach var="module" items="${conditionParam.list}">
				<tr>
					<td>${module.moduleId }</td>
					<td>${module.moduleName}</td>
					<td>${module.moduleTag}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="base_table_footer module_table_footer">
			<a
				href="/core/module/list_module?pageNo=${conditionParam.page.pageNo-1}"
				class="">上一页</a> <a
				href="/core/module/list_module?pageNo=${conditionParam.page.pageNo+1}"
				class="">下一页</a> <span>总记录数：${conditionParam.page.count}</span>
		</div>

	</div>

</div>
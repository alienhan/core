<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	//添加页面显示
	$(document).ready(function() {

		$(".bta").click(function() {
			$(".module_add_div").dialog("open");
		});
	});

	//添加
	function saveModule() {
		var url = "/core/module/save_module";
		var moduleName = $(".moduleName").val();
		var moduleTag = $(".moduleTag").val();
		var data = {
			"moduleName" : moduleName,
			"moduleTag" : moduleTag
		};
		ajaxSupport(url, data, function(result) {
			alert("result: " + result.msg);
			window.location.reload();
		});
	}

	//删除页面显示
	function showDelete(moduleId) {
		$(".module_delete_div .moduleId").val(moduleId);
		$(".module_delete_div").dialog("open");
	}

	//删除
	function deleteModule(moduelId) {
		var url = "/core/module/delete_module";
		var moduleId = $(".module_delete_div .moduleId").val();
		var data = {
			"moduleId" : moduleId
		};
		ajaxSupport(url, data, function(result) {
			alert("result: " + result.msg);
			window.location.reload();
		});
	}

	//更新页面显示
	function showUpdate(moduleId, moduleName, moduleTag) {
		$(".module_update_div .moduleId").val(moduleId);
		$(".module_update_div .moduleName").val(moduleName);
		$(".module_update_div .moduleTag").val(moduleTag);
		$(".module_update_div").dialog("open");

	};

	//更新
	function updateModule() {
		var url = "/core/module/update_module";
		var moduleId = $(".module_update_div .moduleId").val();
		var moduleName = $(".module_update_div .moduleName").val();
		var moduleTag = $(".module_update_div .moduleTag").val();

		var data = {
			"moduleId" : moduleId,
			"moduleName" : moduleName,
			"moduleTag" : moduleTag
		};
		ajaxSupport(url, data, function(result) {
			alert("result: " + result.msg);
			window.location.reload();
		});
	}

	//查询
	function getModule(moduleId) {
		var url = "/core/module/get_module";
		var data = {
			"moduleId" : moduleId
		};
		ajaxSupport(url, data, function(result) {
			$(".module_get_div .moduleName").html(result.module.moduleName);
			$(".module_get_div .moduleTag").html(result.module.moduleTag);
			$(".module_get_div").dialog("open");
		});
	}
</script>


<div class="bch module_manager_header">
	<div class="bct module_manager_theme">菜单模型管理</div>
	<div></div>
</div>
<div class="bc moc">
	<div class="btd">
		<div class="bth module_table_header">
			<button type="button" class="bta module_add">添&nbsp;&nbsp;加</button>
		</div>
		<table class="bt module_table">
			<tr>
				<th>菜单模型id</th>
				<th>菜单模型名字</th>
				<th>菜单模型标签</th>
				<th>操作</th>
			</tr>
			<c:forEach var="module" items="${conditionParam.list}">
				<tr>
					<td>${module.moduleId }</td>
					<td>${module.moduleName}</td>
					<td>${module.moduleTag}</td>
					<td><a class="get" href="javascript:" onclick="getModule('${module.moduleId }')">详细</a>
						<a class="update" href="javascript:"
						onclick="showUpdate('${module.moduleId }', '${module.moduleName}', '${module.moduleTag}')">更新</a>
						<a class="delete" href="javascript:"
						onclick="showDelete('${module.moduleId }')">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="btf module_table_footer">
			<a
				href="/core/module/list_module?pageNo=${conditionParam.page.pageNo-1}"
				class="">上一页</a> <a
				href="/core/module/list_module?pageNo=${conditionParam.page.pageNo+1}"
				class="">下一页</a> <span>总记录数：${conditionParam.page.count}</span>
		</div>

	</div>

</div>

<!-- add -->
<div class="btad module_add_div">
	<input type="text" id="moduleName" class="moduleName" name="moduleName" />
	<input type="text" id="moduleName" class="moduleTag" name="moduleTag" />
	<input type="submit" value="添加" onclick="saveModule()" />
</div>

<!-- delete -->
<div class="btdd module_delete_div">
	<p>确定删除？</p>
	<input type="hidden" id="moduleId" class="moduleId" name="moduleId" />
	<input type="submit" value="删除" onclick="deleteModule()" />
</div>

<!-- update -->
<div class="btud module_update_div">
	<input type="hidden" id="moduleId" class="moduleId" name="moduleId" />
	<input type="text" id="moduleName" class="moduleName" name="moduleName" />
	<input type="text" id="moduleName" class="moduleTag" name="moduleTag" />
	<input type="submit" value="更新" onclick="updateModule()" />
</div>

<!-- get -->
<div class="btgd module_get_div">
	<div class="moduleName"></div>
	<div class="moduleTag"></div>
</div>





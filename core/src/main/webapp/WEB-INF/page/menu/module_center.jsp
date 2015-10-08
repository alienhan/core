<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	//添加页面显示
	function showSave() {
		$(".btad").dialog({
			autoOpen : true,
			buttons : {
				"添加" : save,
				"关闭" : function() {
					dialog.dialog("close");
				}
			}
		});
	}

	//添加
	function save() {
		var url = "/core/module/save_module";
		var moduleName = $(".btad .moduleName").val();
		var moduleTag = $(".btad .moduleTag").val();
		var data = {
			"moduleName" : moduleName,
			"moduleTag" : moduleTag
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//删除页面显示
	function showDelete(moduleId) {
		$(".btdd .moduleId").val(moduleId);
		$(".btdd").dialog("open");
	}

	//删除
	function deleteBase() {
		var url = "/core/module/delete_module";
		var moduleId = $(".btdd .moduleId").val();
		var data = {
			"moduleId" : moduleId
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//更新页面显示
	function showUpdate(moduleId) {
		var url = "/core/module/get_module";
		var data = {
			"moduleId" : moduleId
		};
		ajaxSupport(url, data, function(result) {
			$(".btud .moduleId").val(result.module.moduleId);
			$(".btud .moduleName").val(result.module.moduleName);
			$(".btud .moduleTag").val(result.module.moduleTag);
			$(".btud").dialog("open");

		});

	};

	//更新
	function update() {
		var url = "/core/module/update_module";
		var moduleId = $(".btud .moduleId").val();
		var moduleName = $(".btud .moduleName").val();
		var moduleTag = $(".btud .moduleTag").val();

		var data = {
			"moduleId" : moduleId,
			"moduleName" : moduleName,
			"moduleTag" : moduleTag
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//查询
	function get(moduleId) {
		var url = "/core/module/get_module";
		var data = {
			"moduleId" : moduleId
		};
		ajaxSupport(url, data, function(result) {
			$(".btgd .moduleName").html(result.module.moduleName);
			$(".btgd .moduleTag").html(result.module.moduleTag);
			$(".btgd").dialog("open");
		});
	}
</script>


<div class="bch moh">
	<div class="bct mot">菜单模型管理</div>
	<div></div>
</div>
<div class="bc moc">
	<div class="btd">
		<div class="bth moth">
			<button type="button" class="bta moa" onclick="showSave()">添&nbsp;&nbsp;加</button>
		</div>
		<table class="bt mot">
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
					<td><a class="get" href="javascript:"
						onclick="get('${module.moduleId }')">详细</a> <a class="update"
						href="javascript:" onclick="showUpdate('${module.moduleId }')">更新</a>
						<a class="delete" href="javascript:"
						onclick="showDelete('${module.moduleId }')">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="btf motf">
			<a
				href="/core/module/list_module?pageNo=${conditionParam.page.pageNo-1}"
				class="">上一页</a> <a
				href="/core/module/list_module?pageNo=${conditionParam.page.pageNo+1}"
				class="">下一页</a> <span>总记录数：${conditionParam.page.count}</span>
		</div>

	</div>

</div>

<!-- add -->
<div class="btad moad">
	<input type="text" id="moduleName" class="moduleName" name="moduleName" />
	<input type="text" id="moduleName" class="moduleTag" name="moduleTag" />
	<input type="submit" value="添加" onclick="save()" />
</div>

<!-- delete -->
<div class="btdd modd">
	<p>确定删除？</p>
	<input type="hidden" id="moduleId" class="moduleId" name="moduleId" />
	<input type="submit" value="删除" onclick="deleteBase()" />
</div>

<!-- update -->
<div class="btud moud">
	<input type="hidden" id="moduleId" class="moduleId" name="moduleId" />
	<input type="text" id="moduleName" class="moduleName" name="moduleName" />
	<input type="text" id="moduleName" class="moduleTag" name="moduleTag" />
	<input type="submit" value="更新" onclick="updateModule()" />
</div>

<!-- get -->
<div class="btgd mogd">
	<div class="moduleName"></div>
	<div class="moduleTag"></div>
</div>





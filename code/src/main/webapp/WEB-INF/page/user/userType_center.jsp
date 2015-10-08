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
			modal : true,
			buttons : {
				"添 加" : save,
				"关 闭" : function() {
					$(this).dialog("close");
				}
			}
		});
	}

	//添加
	function save() {
		var url = "/code/userType/save_userType";
		var typeName = $(".btad .typeName").val();
		var typeTag = $(".btad .typeTag").val();
		var data = {
			"typeName" : typeName,
			"typeTag" : typeTag
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//删除页面显示
	function showDelete(typeId) {
		$(".btdd .typeId").val(typeId);
		$(".btdd").dialog({
			autoOpen : true,
			modal : true,
			buttons : {
				"删 除" : deleteBase,
				"关 闭" : function() {
					$(this).dialog("close");
				}
			}
		});
	}

	//删除
	function deleteBase() {
		var url = "/code/userType/delete_userType";
		var typeId = $(".btdd .typeId").val();
		var data = {
			"typeId" : typeId
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//更新页面显示
	function showUpdate(typeId) {
		var url = "/code/userType/get_userType";
		var data = {
			"typeId" : typeId
		};
		ajaxSupport(url, data, function(result) {
			$(".btud .typeId").val(result.userType.typeId);
			$(".btud .typeName").val(result.userType.typeName);
			$(".btud .typeTag").val(result.userType.typeTag);

			$(".btud").dialog({
				autoOpen : true,
				modal : true,
				buttons : {
					"更 新" : update,
					"关 闭" : function() {
						$(this).dialog("close");
					}
				}
			});
		});

	};

	//更新
	function update() {
		var url = "/code/userType/update_userType";
		var typeId = $(".btud .typeId").val();
		var typeName = $(".btud .typeName").val();
		var typeTag = $(".btud .typeTag").val();

		var data = {
			"typeId" : typeId,
			"typeName" : typeName,
			"typeTag" : typeTag
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//获取
	function get(typeId) {
		var url = "/code/userType/get_userType";
		var data = {
			"typeId" : typeId
		};
		ajaxSupport(url, data, function(result) {
			$(".btgd .typeName").html(result.userType.typeName);
			$(".btgd .typeTag").html(result.userType.typeTag);
			$(".btgd").dialog("open");
		});
	}

	//查询自动提示
	function search_reminder() {
		//alert("dd");
	}

	//查询
	function search_submit() {

	}
</script>

<!-- base content header -->
<div class="bch utch">
	<div class="bct utt">用户类型管理</div>
</div>

<!-- base content -->
<div class="bc utc">
	<div class="btd">
		<div class="bth utth">
			<div class="bthad">
				<input type="button" class="bta uta" onclick="showSave()" value="添&nbsp;&nbsp;加"/>
			</div>
			<div class="search">
				<form>
					<input type="text" onfocus="search_reminder()" /> <input
						type="submit" class="search_submit" onclick="search_submit"
						value="查&nbsp;&nbsp;询" />
				</form>
			</div>
		</div>
		<table class="ui-widget ui-widget-content bt utt">
			<tr class="ui-widget-header tr_th">
				<th>用户类型id</th>
				<th>用户类型名字</th>
				<th>用户类型标签</th>
				<th>操&nbsp;&nbsp;作</th>
			</tr>
			<c:forEach var="userType" items="${condition.list}">
				<tr>
					<td>${userType.typeId }</td>
					<td>${userType.typeName}</td>
					<td>${userType.typeTag}</td>
					<td><a class="get" href="javascript:"
						onclick="get('${userType.typeId }')">详细 </a> <a class="update"
						href="javascript:" onclick="showUpdate('${userType.typeId }')">更新 </a>
						<a class="delete" href="javascript:"
						onclick="showDelete('${userType.typeId }')">删除 </a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="btf uttf">
			<a
				href="/code/userType/list_userType?pageNo=${condition.page.pageNo-1}"
				class="">上一页</a> <a
				href="/code/userType/list_userType?pageNo=${condition.page.pageNo+1}"
				class="">下一页</a> <span>总记录数：${condition.page.count}</span>
		</div>

	</div>

</div>

<!-- 弹出页面 -->
<!-- add -->
<!-- base table add div -->
<div class="btad utad" title="添加">
	<table>
		<tr>
			<td><label for="typeName">用户类型名字:</label></td>
			<td><input type="text" id="typeName" class="typeName"
				name="typeName" /></td>
		</tr>
		<tr>
			<td><label for="typeTag">用户类型标签:</label></td>
			<td><input type="text" id="typeTag" class="typeTag"
				name="typeTag" /></td>
		</tr>
	</table>
</div>

<!-- delete -->
<div class="btdd utdd" title="删除">
	<table>
		<tr>
			<td><p>确定删除？</p></td>
		</tr>
		<tr>
			<td><input type="hidden" id="typeId" class="typeId"
				name="typeId" /></td>
		</tr>
	</table>
</div>

<!-- update -->
<div class="btud utud" title="更新">
	<input type="hidden" id="typeId" class="typeId" name="typeId" />
	<table>
		<tr>
			<td><label for="typeName"><span>用户类型名字:</span></label></td>
			<td><input type="text" id="typeName" class="typeName"
				name="typeName" /></td>
		</tr>
		<tr>
			<td><label for="typeTag"><span>用户类型标签:</span></label></td>
			<td><input type="text" id="typeTag" class="typeTag"
				name="typeTag" /></td>
		</tr>
	</table>
</div>

<!-- get -->
<div class="btgd utgd" title="显示详细">
	<table>
		<tr>
			<td><span>用户类型名字:</span></td>
			<td><div class="typeName"></div></td>
		</tr>
		<tr>
			<td><span>用户类型标签:</span></td>
			<td><div class="typeTag"></div></td>
		</tr>
	</table>
</div>

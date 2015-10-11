<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- base content header -->
<div class="bch utch">
	<div class="bct utt">用户类型管理</div>
	<div class="bct2">
		<span>用户管理&nbsp;&nbsp;/&nbsp;&nbsp;用户类型管理</span>
	</div>
</div>

<!-- base content -->
<div class="bc utc">
	<div class="btd">
		<div class="bth utth">
			<div class="bthad">
				<input type="button" class="bta uta" onclick="showSave();" value="添&nbsp;&nbsp;加"/>
			</div>
			<div class="search">
				<form action="${ basePath}userType/list_userType" method="post">
					<input type="text" class="search_reminder" name="search" value="${condition.search }" 
						   onkeyup="search_reminder()" autocomplete="off"/>
					<input type="submit" class="search_submit" value="查&nbsp;&nbsp;询" />
				</form>
			</div>
		</div>
		<table class="ui-widget ui-widget-content bt utt">
			<tr class="ui-widget-header tr_th">
				<th>用户类型id</th>
				<th>用户类型名字</th>
				<th>用户类型标签</th>
				<th style="width: 120px">操&nbsp;&nbsp;作</th>
			</tr>
			<c:forEach var="userType" items="${condition.list}">
				<tr>
					<td>${userType.typeId }</td>
					<td>${userType.typeName}</td>
					<td>${userType.typeTag}</td>
					<td>
						<a class="get" href="javascript:"
						onclick="get('${userType.typeId }');">详细 &nbsp;</a>
						<a class="update"
						href="javascript:" onclick="showUpdate('${userType.typeId }');">更新 &nbsp; </a>
						<a class="delete" href="javascript:"
						onclick="showDelete('${userType.typeId }');">删除 </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="btf uttf">
			<c:if var="lowNo" test="${condition.page.pageNo == 1}">
				<a href="#" class="">上一页</a>
			</c:if>
			<c:if test="${!lowNo }">
				<a href="${ basePath}userType/list_userType?pageNo=${condition.page.pageNo-1}&search=${condition.search}"
			   		class="">上一页</a>
			</c:if>
			<a class="pra1" href=""></a>
			<a class="pra2" href=""></a>
			<a class="pra3" href=""></a>
			<a class="pra4" href=""></a>
			<a class="pra5" href=""></a>
			<c:if var="topNo" test="${condition.page.pageNo == condition.page.pageCount}">
				<a href="#" class="">下一页</a>
			</c:if>
			<c:if test="${!topNo}">
				<a href="${ basePath}userType/list_userType?pageNo=${condition.page.pageNo+1}&search=${condition.search}"
			   		class="">下一页</a>
			</c:if>
			<span>第${condition.page.pageNo}页</span>
		    <span>页数:&nbsp;${condition.page.pageCount}</span>
		</div>

	</div>

</div>

<!-- 弹出页面 -->
<div class="base_pop">
	<!-- add update get -->
	<div class="btpd">
		<input type="hidden" id="typeId" class="typeId" name="typeId" autocomplete="off">
		<table>
			<tr>
				<td><label for="typeName">用户类型名字:</label></td>
				<td><input type="text" id="typeName" class="typeName"
					name="typeName" autocomplete="off" /></td>
			</tr>
			<tr>
				<td><label for="typeTag">用户类型标签:</label></td>
				<td><input type="text" id="typeTag" class="typeTag"
					name="typeTag" autocomplete="off"/></td>
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
</div>

<script type="text/javascript">

//添加页面显示
function showSave() {
	$(".btpd .typeName").removeAttr("disabled");
	$(".btpd .typeTag").removeAttr("disabled");
	
	$(".btpd .typeId").val("");
	$(".btpd .typeName").val("");
	$(".btpd .typeTag").val("");
	
	$(".btpd").dialog({autoOpen: false});
	$(".btpd").dialog({
		title: "添加",
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
	var url = "${ basePath}userType/save_userType";
	var typeName = $(".btpd .typeName").val();
	var typeTag = $(".btpd .typeTag").val();
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
	var url = "${ basePath}userType/delete_userType";
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
	$(".btpd .typeName").removeAttr("disabled");
	$(".btpd .typeTag").removeAttr("disabled");
	
	var url = "${ basePath}userType/get_userType";
	var data = {
		"typeId" : typeId
	};
	ajaxSupport(url, data, function(result) {
		$(".btpd .typeId").val(result.userType.typeId);
		$(".btpd .typeName").val(result.userType.typeName);
		$(".btpd .typeTag").val(result.userType.typeTag);

		$(".btpd").dialog({autoOpen: false});
		$(".btpd").dialog({
			title: "更新",
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
	var url = "${ basePath}userType/update_userType";
	var typeId = $(".btpd .typeId").val();
	var typeName = $(".btpd .typeName").val();
	var typeTag = $(".btpd .typeTag").val();

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
	$(".btpd .typeName").attr("disabled", "disabled");
	$(".btpd .typeTag").attr("disabled", "disabled");
	
	var url = "${ basePath}userType/get_userType";
	var data = {
		"typeId" : typeId
	};
	ajaxSupport(url, data, function(result) {
		$(".btpd .typeName").val(result.userType.typeName);
		$(".btpd .typeTag").val(result.userType.typeTag);
		
		$(".btpd").dialog({autoOpen: false});
		$(".btpd").dialog({
			title: "详细信息",
			autoOpen: true
		});
	});
}

//查询提示
function search_reminder(){
	var url = "${basePath}userType/search_reminder";
	var search = $(".search_reminder").val();
	var data = {
		"search" : search
	};
	
	var searchSource = [];
	ajaxSupport(url,data,function(result){
		var resultSource = result.search;
        searchSource = resultSource.toString().split(",");
	});
	alert(searchSource);
	//查找自动添加
   	$(".search_reminder").autocomplete({
   		source: searchSource
   	});
	
}

$(document).ready(function() {
	//分页显示
	var pageNo = "${condition.page.pageNo}";
	var pageCount = "${condition.page.pageCount}";
	var pra1 = null;
	var pra2 = null;
	var pra3 = null;
	var pra4 = null;
	var pra5 = null;

	//处理显示页数的个数
	if(pageCount <= 5) {
		//最小页数
		if(pageCount == 1){
			pra1 = 1;
		}else if(pageCount == 2){
			pra1 = 1;
			pra2 = 2;
		}else if(pageCount == 3){
			pra1 = 1;
			pra2 = 2;
			pra3 = 3;
		}else if(pageCount == 4){
			pra1 = 1;
			pra2 = 2;
			pra3 = 3;
			pra4 = 4;
		}else if(pageCount == 5){
			pra1 = 1;
			pra2 = 2;
			pra3 = 3;
			pra4 = 4;
			pra5 = 5;
		}
	}else if(pageNo > pageCount - 2) {
		//最大页数
		pra1 = pageCount -4;
		pra2 = pageCount - 3;
		pra3 = pageCount - 2;
		pra4 = pageCount - 1;
		pra5 = pageCount;
	}else {
		if(pageNo <= 3){
			pra1 = 1;
			pra2 = 2;
			pra3 = 3;
			pra4 = 4;
			pra5 = 5;
		}else {
			pra1 = pageNo - 2;
			pra2 = pageNo - 1;
			pra3 = pageNo;
			pra4 = parseInt(pageNo) + 1;
			pra5 = parseInt(pageNo) + 2;
		}
	} 
	
	//元素不可见时，不占用位置空间
	if(pra1 == null){
		$(".pra1").css({"display": "none"});
	}
	if(pra2 == null){
	}
	if(pra3 == null){
		$(".pra3").css({"display": "none"});
	}
	if(pra4 == null){
		$(".pra4").css({"display": "none"});
	}
	if(pra5 == null){
		$(".pra5").css({"display": "none"});
	}
	
	//写入href，显示文字
	$(".pra1").html(pra1);
	$(".pra1").attr("href", "${ basePath}userType/list_userType?pageNo=" + pra1 + "&search=${condition.search}");
	$(".pra2").html(pra2);
	$(".pra2").attr("href", "${ basePath}userType/list_userType?pageNo=" + pra2 + "&search=${condition.search}");
	$(".pra3").html(pra3);
	$(".pra3").attr("href", "${ basePath}userType/list_userType?pageNo=" + pra3 + "&search=${condition.search}");
	$(".pra4").html(pra4);
	$(".pra4").attr("href", "${ basePath}userType/list_userType?pageNo=" + pra4 + "&search=${condition.search}");
	$(".pra5").html(pra5);
	$(".pra5").attr("href", "${ basePath}userType/list_userType?pageNo=" + pra5 + "&search=${condition.search}");

});

</script>


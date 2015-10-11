<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- base content header -->
<div class="bch">
	<div class="bct">用户管理</div>
	<div class="bct2">
		<span>用户管理&nbsp;&nbsp;/&nbsp;&nbsp;用户管理</span>
	</div>
</div>

<!-- base content -->
<div class="bc">
	<div class="btd">
		<div class="bth">
			<div class="bthad">
				<input type="button" class="bta" onclick="showSave();" value="添&nbsp;&nbsp;加"/>
			</div>
			<div class="search">
				<form action="${ basePath}user/list_user" method="post">
					<input type="text" class="search_reminder" name="search" onkeyup="search_reminder()" value="${condition.search }" />
					<input type="submit" class="search_submit" value="查&nbsp;&nbsp;询" />
				</form>
			</div>
		</div>
		<table class="ui-widget ui-widget-content bt">
			<tr class="ui-widget-header tr_th">
				<th>用户名字</th>
				<th>用户昵称</th>
				<th>用户Email</th>
				<th>用户电话</th>
				<th>用户有效性</th>
				<th style="width: 120px">操&nbsp;&nbsp;作</th>
			</tr>
			<c:forEach var="user" items="${condition.list}">
				<tr>
					<td>${user.userName}</td>
					<td>${user.userNickName}</td>
					<td>${user.userEmail}</td>
					<td>${user.userTel}</td>
					<td>
						<c:if var="userValidFalse" test="${user.userValid != 'false'}">有效</c:if>
						<c:if test="${!userValidFalse }">无效</c:if>
					</td>
					<td>
						<a class="get" href="javascript:"
						   onclick="get('${user.userId }');">详细 &nbsp;</a>
						<a class="update" href="javascript:" 
						   onclick="showUpdate('${user.userId }');">更新 &nbsp; </a>
						<a class="delete" href="javascript:"
						   onclick="showDelete('${user.userId }');">删除 </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- 分页 -->
		<div class="btf">
			<c:if var="lowNo" test="${condition.page.pageNo == 1}">
				<a href="#" class="">上一页</a>
			</c:if>
			<c:if test="${!lowNo }">
				<a href="${ basePath}user/list_user?pageNo=${condition.page.pageNo-1}&search=${condition.search}"
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
				<a href="${ basePath}user/list_user?pageNo=${condition.page.pageNo+1}&search=${condition.search}"
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
		<input type="hidden" id="userId" class="userId" name="userId" autocomplete="off">
		<table>
			<tr>
				<td><label for="userName">用户名字:</label></td>
				<td><input type="text" id="userName" class="userName"
					name="userName" autocomplete="off" /></td>
			</tr>
			<tr>
				<td><label for="userNickName">用户昵称：</label></td>
				<td><input type="text" id="userNickName" class="userNickName" 
						   name="userNickName" autocomplete="off"/></td>
			</tr>
			<tr>
				<td><label for="userPwd">用户密码:</label></td>
				<td><input type="text" id="userPwd" class="userPwd"
					name="userPwd" autocomplete="off"/></td>
			</tr>
			<tr>
				<td><label for="userInitPwd">用户初始密码：</label></td>
				<td>
					<input type="text" id="userInitPwd" class="userInitPwd" 
						   name="userInitPwd" autocomplete="off"/>
				</td>
			</tr>
			<tr>
				<td><label for="userEmail">用户Email:</label></td>
				<td><input type="text" id="userEmail" class="userEmail"
					name="userEmail" autocomplete="off" /></td>
			</tr>
			<tr>
				<td><label for="userTel">用户电话:</label></td>
				<td><input type="text" id="userTel" class="userTel"
					name="userTel" autocomplete="off" /></td>
			</tr>
			<tr>
				<td>用户是否有效</td>
				<td><label for="userValid">有效</label>
					<input type="radio" id="userValid1" class="userValid"
						   name="userValid" value="true" autocomplete="off" />
					<label for="userValid">无效</label>
					<input type="radio" id="userValid2" class="userValid"
						   name="userValid" value="false" autocomplete="off" />
				</td>
			</tr>
		</table>
	</div>
	<!-- delete -->
	<div class="btdd" title="删除">
		<table>
			<tr>
				<td><p>确定删除？</p></td>
			</tr>
			<tr>
				<td><input type="hidden" id="userId" class="userId"
					name="userId" /></td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">

//添加页面显示
function showSave() {
	//清空详情残留
	$(".btpd .userName").removeAttr("disabled");
	$(".btpd .userNickName").removeAttr("disabled");
	$(".btpd .userPwd").removeAttr("disabled");
	$(".btpd .userInitPwd").removeAttr("disabled");
	$(".btpd .userEmail").removeAttr("disabled");
	$(".btpd .userTel").removeAttr("disabled");
	$(".btpd .userValid").removeAttr("disabled");
	//清空更新残留	
	$(".btpd .userId").val("");
	$(".btpd .userName").val("");
	$(".btpd .userNickName").val("");
	$(".btpd .userPwd").val("");
	$(".btpd .userInitPwd").val("");
	$(".btpd .userEmail").val("");
	$(".btpd .userTel").val("");
	$(".btpd #userValid1").attr("checked","checked");
	
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
	var url = "${ basePath}user/save_user";
	var userName = $(".btpd .userName").val();
	var userNickName = $(".btpd .userNickName").val();
	var userPwd = $(".btpd .userPwd").val();
	var userInitPwd = $(".btpd .userInitPwd").val();
	var userEmail = $(".btpd .userEmail").val();
	var userTel = $(".btpd .userTel").val();
	var userValid = $(".btpd :checked[name='userValid']").val();
	var data = {
		"userName" : userName,
		"userNickName" : userNickName,
		"userPwd" : userPwd,
		"userInitPwd" : userInitPwd,
		"userEmail" : userEmail,
		"userTel" : userTel,
		"userValid" : userValid
	};
	ajaxSupport(url, data, function(result) {
		window.location.reload();
	});
}

//删除页面显示
function showDelete(userId) {
	$(".btdd .userId").val(userId);
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
	var url = "${ basePath}user/delete_user";
	var userId = $(".btdd .userId").val();
	var data = {
		"userId" : userId
	};
	ajaxSupport(url, data, function(result) {
		window.location.reload();
	});
}

//更新页面显示
function showUpdate(userId) {
	//清空详情残留
	$(".btpd .userName").removeAttr("disabled");
	$(".btpd .userNickName").removeAttr("disabled");
	$(".btpd .userPwd").removeAttr("disabled");
	$(".btpd .userInitPwd").removeAttr("disabled");
	$(".btpd .userEmail").removeAttr("disabled");
	$(".btpd .userTel").removeAttr("disabled");
	$(".btpd .userValid").removeAttr("disabled");
	
	var url = "${ basePath}user/get_user";
	var data = {
		"userId" : userId
	};
	ajaxSupport(url, data, function(result) {
		$(".btpd .userId").val(result.user.userId);
		$(".btpd .userName").val(result.user.userName);
		$(".btpd .userNickName").val(result.user.userNickName);
		$(".btpd .userPwd").val(result.user.userPwd);
		$(".btpd .userInitPwd").val(result.user.userInitPwd);
		$(".btpd .userEmail").val(result.user.userEmail);
		$(".btpd .userTel").val(result.user.userTel);
		if(result.user.userValid == "true"){
			$(".btpd #userValid1").attr("checked","checked");
		}else{
			$(".btpd #userValid2").attr("checked","checked");
		}
		
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
	var url = "${ basePath}user/update_user";
	var userId = $(".btpd .userId").val();
	var userName = $(".btpd .userName").val();
	var userNickName = $(".btpd .userNickName").val();
	var userPwd = $(".btpd .userPwd").val();
	var userInitPwd = $(".btpd .userInitPwd").val();
	var userEmail = $(".btpd .userEmail").val();
	var userTel = $(".btpd .userTel").val();
	var userValid = $(".btpd :checked[name='userValid']").val();

	var data = {
			"userId" : userId,
			"userName" : userName,
			"userNickName" : userNickName,
			"userPwd" : userPwd,
			"userInitPwd" : userInitPwd,
			"userEmail" : userEmail,
			"userTel" : userTel,
			"userValid" : userValid
	};
	ajaxSupport(url, data, function(result) {
		window.location.reload();
	});
}

//获取
function get(userId) {
	//设置只读
	$(".btpd .userName").attr("disabled", "disabled");
	$(".btpd .userNickName").attr("disabled", "disabled");
	$(".btpd .userPwd").attr("disabled", "disabled");
	$(".btpd .userInitPwd").attr("disabled", "disabled");
	$(".btpd .userEmail").attr("disabled", "disabled");
	$(".btpd .userTel").attr("disabled", "disabled");
	$(".btpd .userValid").attr("disabled", "disabled");
	
	var url = "${ basePath}user/get_user";
	var data = {
		"userId" : userId
	};
	ajaxSupport(url, data, function(result) {
		$(".btpd .userId").val(result.user.userId);
		$(".btpd .userName").val(result.user.userName);
		$(".btpd .userNickName").val(result.user.userNickName);
		$(".btpd .userPwd").val(result.user.userPwd);
		$(".btpd .userInitPwd").val(result.user.userInitPwd);
		$(".btpd .userEmail").val(result.user.userEmail);
		$(".btpd .userTel").val(result.user.userTel);
		if(result.user.userValid == "true"){
			$(".btpd #userValid1").attr("checked","checked");
		}else{
			$(".btpd #userValid2").attr("checked","checked");
		}
		
		$(".btpd").dialog({autoOpen: false});
		$(".btpd").dialog({
			title: "详细信息",
			autoOpen: true
		});
	});
}

//查询提示
function search_reminder(){
	var url = "${basePath}user/search_reminder";
	var search = $(".search_reminder").val();
	var data = {
		"search" : search
	};
	
	ajaxSupport(url,data,function(result){
		var resultSource = result.search;
		var searchSource = [];
        searchSource = resultSource.toString().split(",");
       	//查找自动添加
       	$(".search_reminder").autocomplete({
       		source: searchSource
       	}); 
		
	});
}

//分页显示
$(document).ready(function() {
	var pageNo = "${condition.page.pageNo}";
	var pageCount = "${condition.page.pageCount}";
	var pra1 = null;
	var pra2 = null;
	var pra3 = null;
	var pra4 = null;
	var pra5 = null;

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
		$(".pra2").css({"display": "none"});
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
	$(".pra1").attr("href", "${ basePath}user/list_user?pageNo=" + pra1 + "&search=${condition.search}");
	$(".pra2").html(pra2);
	$(".pra2").attr("href", "${ basePath}user/list_user?pageNo=" + pra2 + "&search=${condition.search}");
	$(".pra3").html(pra3);
	$(".pra3").attr("href", "${ basePath}user/list_user?pageNo=" + pra3 + "&search=${condition.search}");
	$(".pra4").html(pra4);
	$(".pra4").attr("href", "${ basePath}user/list_user?pageNo=" + pra4 + "&search=${condition.search}");
	$(".pra5").html(pra5);
	$(".pra5").attr("href", "${ basePath}user/list_user?pageNo=" + pra5 + "&search=${condition.search}");
});

</script>


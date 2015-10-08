<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	//添加页面显示
	function showSave() {
		$(".btad").dialog("open");
	}

	//添加
	function save() {
		var url = "/code/user/save_user";
		var userName = $(".btad .userName").val();
		var userTag = $(".btad .userTag").val();
		var data = {
			"userName" : userName,
			"userTag" : userTag
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//删除页面显示
	function showDelete(userId) {
		$(".btdd .userId").val(userId);
		$(".btdd").dialog("open");
	}

	//删除
	function deleteBase() {
		var url = "/code/user/delete_user";
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
		var url = "/code/user/get_user";
		var data = {
			"userId" : userId
		};
		ajaxSupport(url, data, function(result) {
			$(".btud .userId").val(result.user.userId);
			$(".btud .userName").val(result.user.userName);
			$(".btud .userTag").val(result.user.userTag);
			$(".btud").dialog("open");
		});

	};

	//更新
	function update() {
		var url = "/code/user/update_user";
		var userId = $(".btud .userId").val();
		var userName = $(".btud .userName").val();
		var userTag = $(".btud .userTag").val();

		var data = {
			"userId" : userId,
			"userName" : userName,
			"userTag" : userTag
		};
		ajaxSupport(url, data, function(result) {
			window.location.reload();
		});
	}

	//查询
	function get(userId) {
		var url = "/code/user/get_user";
		var data = {
			"userId" : userId
		};
		ajaxSupport(url, data, function(result) {
			$(".btgd .userName").html(result.user.userName);
			$(".btgd .userTag").html(result.user.userTag);
			$(".btgd").dialog("open");
		});
	}
</script>


<div class="bch utch">
	<div class="bct utt">用户管理</div>
	<div></div>
</div>
<div class="bc utc">
	<div class="btd">
		<div class="bth utth">
			<button type="button" class="bta uta" onclick="showSave()">添&nbsp;&nbsp;加</button>
		</div>
		<table class="bt utt">
			<tr class="tr_th">
				<th>用户id</th>
				<th>用户名字</th>
				<th>用户标签</th>
				<th>操作</th>
			</tr>
			<c:forEach var="user" items="${condition.list}">
				<tr>
					<td>${user.userId }</td>
					<td>${user.userName}</td>
					<td>${user.userTag}</td>
					<td><a class="get" href="javascript:"
						onclick="get('${user.userId }')">详细</a> <a class="update"
						href="javascript:" onclick="showUpdate('${user.userId }')">更新</a>
						<a class="delete" href="javascript:"
						onclick="showDelete('${user.userId }')">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="btf uttf">
			<a href="/code/user/list_user?pageNo=${condition.page.pageNo-1}"
				class="">上一页</a> <a
				href="/code/user/list_user?pageNo=${condition.page.pageNo+1}"
				class="">下一页</a> <span>总记录数：${condition.page.count}</span>
		</div>

	</div>

</div>

<!-- add -->
<div class="btad utad">
	<table>
		<tr>
			<td>用户名字:</td>
			<td><input type="text" id="userName" class="userName"
				name="userName" /></td>
		</tr>
		<tr>
			<td>用户密码:</td>
			<td><input type="text" id="userPwd" class="userPwd"
				name="userPwd" /></td>
		</tr>
		<tr>
			<td>用户昵称:</td>
			<td><input type="text" id="userNickName" class="userNickName"
				name="userNickName" /></td>
		</tr>
		<tr>
			<td>电子邮箱:</td>
			<td><input type="text" id="userEmail" class="userEmail"
				name="userEmail" /></td>
		</tr>
		<tr>
			<td>联系电话:</td>
			<td><input type="text" id="userTel" class="userTel"
				name="userTel" /></td>
		</tr>
		<tr>
			<td>用户类型:</td>
			<td><input type="text" id="userType" class="userType"
				name="userType" /></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="添加" onclick="save()" /></td>
		</tr>
	</table>
</div>

<!-- delete -->
<div class="btdd utdd">
	<table>
		<tr>
			<td><p>确定删除？</p></td>
		</tr>
		<tr>
			<td><input type="hidden" id="userId" class="userId"
				name="userId" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="删除" onclick="deleteBase()" /></td>
		</tr>
	</table>
</div>

<!-- update -->
<div class="btud utud">
	<input type="hidden" id="userId" class="userId" name="userId" />
	<table>
		<tr>
			<td><span>用户名字:</span></td>
			<td><input type="text" id="userName" class="userName"
				name="userName" /></td>
		</tr>
		<tr>
			<td><span>用户标签:</span></td>
			<td><input type="text" id="userTag" class="userTag"
				name="userTag" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="更新" onclick="update()" /></td>
		</tr>
	</table>
</div>

<!-- get -->
<div class="btgd utgd">
	<table>
		<tr>
			<td><span>用户名字:</span></td>
			<td><div class="userName"></div></td>
		</tr>
		<tr>
			<td><span>用户标签:</span></td>
			<td><div class="userTag"></div></td>
		</tr>
	</table>
</div>

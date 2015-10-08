$(document).ready(function() {

	$(".bta, .btu, .search_submit").button(function(event) {
		event.preventDefault();
	});

	$(".base_table_pre, .base_table_next").button(function(event) {
		event.preventDefault();
	});

	// 隐藏添加，更新页面
	$(".btad, .btud, .btdd, .btgd").dialog({
		autoOpen : false,
		height : 300,
		width : 450,
		modal : true,
		show : {
			effect : "blind",
			duration : 1000
		},
		hide : {
			effect : "explode",
			duration : 1000
		},
		buttons : {
			'关 闭' : function() {
				$(this).dialog("close");
			}
		}
	});
	
	/* table 设置---------------------------------- */
	// 奇偶行颜色不同
	$(".bt tbody tr:odd").addClass("bt_odd");
	$(".bt tbody tr:even").addClass("bt_even");

	// 鼠标悬停行变色
	$(".bt tr:gt(0)").hover(function() {
		$(this).addClass("bt_hover");
	}, function() {
		$(this).removeClass("bt_hover");
	});

});

/**
 * ajax 提交
 * 
 * @param url
 * @param data
 * @returns
 */
var ajaxSupport = function(url, data, callback) {
	$.ajax({
		contentType : 'application/json',
		data : $.toJSON(data),
		type : "POST",
		dataType : "json",
		url : url,
		success : function(data) {
			callback(data);
		},
		error : function(data) {
			callback(data);
		}
	});

};

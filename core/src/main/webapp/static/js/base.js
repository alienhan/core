$(document).ready(function() {
	$("#base_accordion").accordion({
		collapsible : true,
		fillSpace:true
	});
	
	$(".base_menu_menu").menu();
	$(".base_menu_user").menu();
	$(".base_menu_others").menu();
	
	$(".base_table_add, .base_table_delete").button().click(function(event) {
		event.preventDefault();
	});
	
	$(".base_table_pre, .base_table_next").button().click(function(event) {
		event.preventDefault();
	});
	
});
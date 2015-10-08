<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<tiles:insertAttribute name="head" />
</head>
<body>
	<div class="base_header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div class="base_main">
		<div class="base_menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="base_content">
			<tiles:insertAttribute name="content" />
		</div>
	</div>

	<div class="base_footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
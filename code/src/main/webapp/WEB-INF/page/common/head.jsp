<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script type="text/javascript" src="/code/static/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/code/static/js/jquery.json.js"></script>
<script type="text/javascript" src="/code/static/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="/code/static/js/base.js"></script>


<link type="text/css" rel="stylesheet"
	href="/code/static/jquery-ui/jquery-ui.css" />
<link type="text/css" rel="stylesheet"
	href="/code/static/css/base/base.css" />


<!-- 根路径 -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="basePath" value="<%= basePath%>" scope="session"/>


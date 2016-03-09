<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true"/></title>
		<meta charset="utf-8">
	</head>
    <body>
    	<div id="banner">
			<tiles:insertAttribute name="header" />
		</div>
		<div></div>
		<tiles:insertAttribute name="menu" />
		<div></div>
		<div id="page">
			<tiles:insertAttribute name="content" />
		</div>
		<div></div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>
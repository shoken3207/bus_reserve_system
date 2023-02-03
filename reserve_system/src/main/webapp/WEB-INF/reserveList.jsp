<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReserveBean, model.BusBean" %>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map" %>
<%
	List<ReserveBean> reserves = (List<ReserveBean>) session.getAttribute("reserves");
	Map<Integer, BusBean> map = (Hashmap<Integer, BusBean>) session.getAttribute("map");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
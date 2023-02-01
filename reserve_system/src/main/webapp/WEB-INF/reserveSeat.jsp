<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%
	String[] reserved = new String[]{"2a", "2b", "4c", "5c", "6d", "7a"};
	String[] alpha = new String[]{"a", "b", "c", "d"};
    int maxPassenger = 40;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reserveSeat.css">
<title>Insert title here</title>
</head>
<body>
    <div class="main">
        <div class="bus">
            <% for (int i = 0; i < maxPassenger / 4; i++) { %>
                <div class="row">
                    <%
                    	for (int j = 0; j < 4; j++) {
                    		String seatNo = i + alpha[j];
                    		boolean isReserved = Arrays.asList(reserved).contains(seatNo);
                    %>
                        <div class="box <%= isReserved ? "reserved": "none" %>">
                            <%= alpha[j] %>
                        </div>
                    <% } %>
                    </div>
            <% } %>
        </div>
    </div>
</body>
<script src="js/reserveSeat.js"></script>
</html>
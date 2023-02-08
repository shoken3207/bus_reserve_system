<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BusBean, java.util.Arrays" %>
<%
	BusBean bus = (BusBean) session.getAttribute("bus");
	String[] reserved = (String[]) session.getAttribute("reservedSeats");
	boolean isEdit = ((String) request.getAttribute("isEdit")).equals("isEdit");
	System.out.println(isEdit);
	String[] alpha = new String[]{"a", "b", "c", "d"};
	int maxPassenger = bus.getMaxPassenger();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reserveSeat.css">
<link rel="icon" href="img/ico.png">
<title>Insert title here</title>
</head>
<body>
    <header>
        <div class="text">↑進行方向</div>
    </header>
    <div class="main">
        <div class="bus">
            <% for (int i = 0; i <= maxPassenger / 4; i++) { %>
                <div class="row">
                    <%
                    	for (int j = 0; j < 4; j++) {
                    		String seatNo = i + alpha[j];
                    		boolean isReserved = Arrays.asList(reserved).contains(seatNo);
                    %>
                        <div class="box <%= isReserved ? "reserved": "none" %>">
                            <%= seatNo %>
                        </div>
                    <% } %>
                </div>
            <% } %>
        </div>
    </div>
    <div class="info">
        <div id="seats"></div><br>
        <button onclick="reset()">リセット</button>
        <form action="ReserveSeatConfirmServlet" method="POST" name="seatForm">
            <input type="hidden" name="selectedSeats">
            <input type="submit" id="submit" value="確定">
        </form>
    </div>
</body>
<script src="js/reserveSeat.js"></script>
</html>
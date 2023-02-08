<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BusBean, java.util.Arrays" %>
<%
	BusBean bus = (BusBean) session.getAttribute("bus");
	String[] reserved = (String[]) session.getAttribute("reservedSeats");
	String[] alpha = new String[]{"a", "b", "c", "d"};
	int maxPassenger = bus.getMaxPassenger();
	
	String edit = (String) request.getParameter("isEdit");
	boolean isEdit = false;
	if (edit != null) {
		isEdit = edit.equals("true");
	}
	String reserveSeat = (String) request.getParameter("reservedSeats");
	String[] reservedSeats = null;
	if (isEdit) {
		reservedSeats = reserveSeat.split(",");
	}

	String actionPath = isEdit ? "EditSeatConfirmServlet": "ReserveSeatConfirmServlet";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reserveSeat.css">
<link rel="icon" href="img/ico.png">
<title>座席選択</title>
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
                    		boolean isSelected = false;
                    		if (isEdit) {
                    			isSelected = Arrays.asList(reservedSeats).contains(seatNo);
                    		}
                    		boolean isReserved = !isSelected && Arrays.asList(reserved).contains(seatNo);
                    %>
                        <div class="box <%= isSelected ? "selected" : isReserved ? "reserved" : "none" %>">
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
        <form action="<%= actionPath %>" method="POST" name="seatForm">
        	<input type="hidden" name="isEdit" value="<%= isEdit %>">
            <input type="hidden" name="selectedSeats">
            <input type="submit" id="submit" value="確定">
        </form>
    </div>
</body>

<script>
	let counter = <%= reservedSeats != null ? reservedSeats.length: 0 %>;
	let selectedList = counter == 0 ? []: '<%= reserveSeat %>'.split(",");
</script>
<script src="js/reserveSeat.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.BusBean, dao.BusDao" %>
<%
	List<BusBean> busList = (List<BusBean>) request.getAttribute("busList");

	String[] startList = (String[]) request.getAttribute("startList");

	String[] endList = (String[]) request.getAttribute("endList");
	
	BusDao busDao = new BusDao();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reserve.css" />
</head>
<body>
	<div class="container">
      <form method="post" action="SearchBusServlet" class="reserveForm">
        <input type="date" name="date" class="selectDate input" />
        <select name="start" id="" class="selectStart select">
        	<option value="">スタート地点を選択</option>
        	<%
        		for(String start : startList) {
        	%>
        		<option value=<%=start %>><%=start %></option>
        	<%
        		}
        	%>
        </select>
        <select name="end" id="" class="selectEnd select">
        	<option value="">到着地点を選択</option>
        	<%
        		for(String end : endList) {
        	%>
        		<option value=<%=end %>><%=end %></option>
        	<%
        		}
        	%>
        </select>
        <input type="submit" class="searchBtn">この条件で探す</input>
      </form>
       <div class="busList">
       		<%
       			for(BusBean busItem : busList) {       		
       		%>
       			<div class="busItem">
       				<input type="hidden" value=<%=busItem.getBusId() %> />
       				<h3>日付: <%=busItem.getDeparture() %></h3>
       				<h4 class="route"><%= busItem.getStart() + " ～ " + busItem.getEnd() %></h4>
       				<p>料金: <%=busItem.getPrice() %></p>
       				<h2>残り乗車人数<%= busDao.getRemainingSeats(busItem.getBusId())%></h2>
       				<a href="/reserve_system/ReserveSeatServlet" class="transitionBtn" href="#">予約</a>
       			</div>
       		<%
       			}
       		%>
       </div>
    </div>
    <script src="js/reserve.js"></script>
</body>
</html>
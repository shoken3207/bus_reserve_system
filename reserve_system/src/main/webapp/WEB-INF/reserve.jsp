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
<title>バス情報検索</title>
<link rel="stylesheet" href="css/reserve.css" />
<link rel="icon" href="img/ico.png">
</head>
<body>
	<div class="container">
      <form method="post" action="SearchBusServlet" class="reserveForm">
      	<div class="inputArea">
      		<label class="label" form="date">日付入力</label>
        	<input type="date" id="date" name="date" class="selectDate input" />
      	</div>
      	<div class="inputArea">
      		<label class="label" form="start">出発地点入力</label>
        	<select name="start" id="start" class="selectStart select">
        	<option value="">スタート地点を選択</option>
        	<%
        		for(String start : startList) {
        	%>
        		<option value=<%=start %>><%=start %></option>
        	<%
        		}
        	%>
        </select>
      	</div>
      	
      	<div class="inputArea">
      		<label class="label" form="end">到着地点入力</label>
        	<select name="end" id="end" class="selectEnd select">
        	<option value="">到着地点を選択</option>
        	<%
        		for(String end : endList) {
        	%>
        		<option value=<%=end %>><%=end %></option>
        	<%
        		}
        	%>
        </select>
      	</div>
        
        
        <input type="submit" class="searchBtn" value="この条件で探す" />
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
       				<a class="transitionBtn" href="/reserve_system/ReserveSeatServlet?busId=<%=busItem.getBusId() %>" class="transitionBtn">予約</a>
       			</div>
       		<%
       			}
       		%>
       </div>
    </div>
    <script src="js/reserve.js"></script>
</body>
</html>
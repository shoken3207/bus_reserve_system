<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ReserveBean, model.BusBean, model.BusBean"%>
<%@ page import="java.util.List, java.util.HashMap"%>
<%
	List<ReserveBean> reserves = (List<ReserveBean>) request.getAttribute("reserves");
	HashMap map = (HashMap) request.getAttribute("map");
%>
<!DOCTYPE html>
<html lang="ja">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/reserveList.css">
	<link rel="icon" href="img/ico.png">
	<title>予約一覧</title>
</head>
<body>
	<div class="title">
		<h2>予約一覧</h2>
	</div>
	<% if (reserves.size() > 0) { %>
		<div class="main">
			<table border="1">
				<tr>
					<th>予約番号</th>
					<th>出発場所</th>
					<th>到着場所</th>
					<th>出発日</th>
					<th>人数</th>
					<th>金額</th>
					<th>編集</th>
					<th>削除</th>
				</tr>
				<%
					int i = 1;
					for (ReserveBean reserve : reserves) {
						BusBean bus = (BusBean) map.get(reserve.getBusId());
				%>
					<tr>
						<td><%= i %></td>
						<td><%= bus.getStart() %></td>
						<td><%= bus.getEnd() %></td>
						<td><%= bus.getDeparture() %></td>
						<td><%= reserve.getSeats() %></td>
						<td><%= String.format("%,d", bus.getPrice() * reserve.getSeats()) %></td>
						<td><a href="ReserveEditServlet?reserveId=<%= reserve.getReserveId() %>">編集</a></td>
						<td><a href="ReserveDeleteServlet?reserveId=<%= reserve.getReserveId() %>" class="remove">削除</td>
					</tr>
				<% 
						i++;
					}
				%>
			</table>
		</div>
	<% } else { %>
		<p class="notfound">現在予約情報がありません。</p>
	<% } %>
	<div class="mypagecontainer">
		<a href="mypage" class="mypage">マイページへ</a>
	</div>
</body>
</html>
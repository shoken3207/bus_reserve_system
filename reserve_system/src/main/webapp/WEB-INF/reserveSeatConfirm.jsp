<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BusBean, model.UserBean"%>
<%
	String reserveSeat = (String) session.getAttribute("reserveSeat");
	BusBean bus = (BusBean) session.getAttribute("bus");
	UserBean user = (UserBean) application.getAttribute("user");
	int passenger = (int) session.getAttribute("passenger");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reserveSeatConfirm.css">
<title>Insert title here</title>
</head>
<body>
    <div class="body">
        <div class="container">
            <div class="confirmText">
                <p>以下の内容で予約を行いますか？</p>
            </div>
            <div class="main">
                <table>
                    <tr class="row">
                        <td class="col">
                            <p>お名前</p>
                        </td>
                        <td class="col val">
                            <p><%= user.getName() %></p>
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="col">
                            <p>出発場所</p>
                        </td>
                        <td class="col val">
                            <p><%= bus.getStart() %></p>
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="col">
                            <p>到着場所</p>
                        </td>
                        <td class="col val">
                            <p><%= bus.getEnd() %></p>
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="col">
                            <p>出発日</p>
                        </td>
                        <td class="col val">
                            <p><%= bus.getDeparture() %></p>
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="col">
                            <p>人数</p>
                        </td>
                        <td class="col val">
                            <p><%= passenger %>名様</p>
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="col">
                            <p>料金</p>
                        </td>
                        <td class="col val">
                            <p><%= bus.getPrice() * passenger %>円</p>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="buttons">
                <a href="javascript:void(0)" class="button cancel" onclick="history.back()">キャンセル</a>
                <a href="ReserveSeatCompleteServlet?busId=<%= bus.getBusId() %>&reserveSeat=<%= reserveSeat %>" class="button confirm">確定</a>
            </div>
        </div>
    </div>
</body>
</html>
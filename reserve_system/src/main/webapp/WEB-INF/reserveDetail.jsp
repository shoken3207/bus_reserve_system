<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BusBean, model.UserBean, model.ReserveBean"%>
<%
	BusBean bus = (BusBean) request.getAttribute("bus");
	UserBean user = (UserBean) session.getAttribute("user");
	ReserveBean reserve = (ReserveBean) request.getAttribute("reserve");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reserveSeatConfirm.css">
<title>予約確認</title>
</head>
<body>
    <div class="body">
        <div class="container">
            <div class="confirmText">
                <p>予約確認</p>
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
                            <p><%= reserve.getSeats() %>名様</p>
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="col">
                            <p>料金</p>
                        </td>
                        <td class="col val">
                            <p><%= bus.getPrice() * reserve.getSeats() %>円</p>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="buttons">
                
            </div>
        </div>
    </div>
</body>
</html>
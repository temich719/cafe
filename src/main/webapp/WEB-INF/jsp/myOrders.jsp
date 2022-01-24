<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Мои заказы</title>
        <link rel="stylesheet" href="css/index.css">
    </head>

    <body style="background-image: url('../img/bu2.jpg');">
        <span class="topMenuBackground"></span>
        <div>
            <img src="img/logo2.png" alt="logo" class="logo">
        </div>

        <div class="findForm">
            <form action="" method="get">
                <input type="hidden" name="command" value="FIND_ORDERS_BY_PHONE_NUMBER_COMMAND">
                <input type="text" name="findLine" placeholder="🔍Введите номер телефона" style="width: 400px;">
                <button type="submit">
                    Найти
                </button>
            </form>
        </div>

        <div id="mainDivOrders">
            <h1 style="margin-left: 37.5%;margin-top: 3%;font-family:Denistina;font-size: 50px;">Мои заказы</h1>


            <table style="border-top: 1px solid black;border-bottom: 1px solid;">
                <tr style="border-bottom: 1px solid black;">
                    <th>
                        Описание
                    </th>
                    <th>
                        Цена
                    </th>
                    <th>
                        Статус
                    </th>
                </tr>
                <tr>
                    <th style="font-size: 10px;width: 50%;">
                        Состав: дрожжи, вода, собачее ухо и прочее.Самый крутой в мире хлеб такого больше никогда не попробуете лучше в мире нет клянусь рукойСостав: дрожжи, вода, собачее ухо и прочее.Самый крутой в мире хлеб такого больше никогда не попробуете лучше в мире нет клянусь рукойСостав: дрожжи, вода, собачее ухо и прочее.Самый крутой в мире хлеб такого больше никогда не попробуете лучше в мире нет клянусь рукойСостав: дрожжи, вода, собачее ухо и прочее.Самый крутой в мире хлеб такого больше никогда не попробуете лучше в мире нет клянусь рукойСостав: дрожжи, вода, собачее ухо и прочее.Самый крутой в мире хлеб такого больше никогда не попробуете лучше в мире нет клянусь рукойСостав: дрожжи, вода, собачее ухо и прочее.Самый крутой в мире хлеб такого больше никогда не попробуете лучше в мире нет клянусь рукой
                    </th>
                    <th>
                        150 руб.
                    </th>
                    <th>
                        В процессе
                    </th>
                </tr>
            </table>

            <div style="margin-top: 27%;width: 100%;">
                <div style="float: left;margin-left: -35%;margin-right: 2%;margin-bottom: 0%;">
                    <img src="img/bot.jpg" alt="image" width="1600px" height="400px">
                </div>
            </div>

            <div style="position: absolute;background-color: white;width: 50%;height: 400px;margin-bottom: 1%;margin-left: 26%;">
                <img src="img/logo2.png" alt="logo" width="354px" height="274px" class="botLogo">
                <br><br>
                <span style="font-family:Arial, Helvetica, sans-serif;font-size: 25px;margin-left: 26%;color: rgb(27, 66, 146);">+375 29 456 78 93</span>
                <br>
                <span style="font-family:Arial, Helvetica, sans-serif;font-size: 25px;margin-left: 26%;color: rgb(27, 66, 146);">+375 29 983 18 05</span>
                <br>
                <span style="font-family:Arial, Helvetica, sans-serif;font-size: 25px;margin-left: 13%;color: rgb(27, 66, 146);">Могилёв, ул.Якубовского, 59</span>
                <br>
                <span style="font-family:Arial, Helvetica, sans-serif;font-size: 25px;margin-left: 28%;color: rgb(27, 66, 146);">вс-ср 12:00-24:00</span>
                <br>
                <span style="font-family:Arial, Helvetica, sans-serif;font-size: 25px;margin-left: 28%;color: rgb(27, 66, 146);">чт-сб 12:00-2:00</span>
            </div>

        </div>
    </body>
</html>
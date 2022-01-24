<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Корзина</title>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body style="background-image: url('../img/bu2.jpg');">
        <span class="topMenuBackground"></span>
        <div>
            <img src="img/logo2.png" alt="logo" class="logo">
        </div>

        <div id="mainDivOrders">
            <h1 style="margin-left: 41%;margin-top: 3%;font-family:Denistina;font-size: 50px;">Корзина</h1>

            <table>
                <tr>
                    <th style="width: 27%;">
                        <img src="img/bread2-removebg-preview.png" alt="dish" width="134.5" height="107" style="margin-left: 10%;">
                    </th>
                    <th style="width: 27%;">
                        Название блюда
                    </th>
                    <th style="width: 27%;">
                        Цена
                    </th>
                    <th style="width: 27%;">
                        <form action="" method="post">
                            <input type="hidden" name="command" value="DELETE_FROM_BASKET_COMMAND">
                            <button type="submit" class="choice">
                                Удалить из корзины
                            </button>
                        </form>
                    </th>
                </tr>
                <tr>
                    <th style="width: 27%;">
                        <img src="img/bread2-removebg-preview.png" alt="dish" width="134.5" height="107" style="margin-left: 10%;">
                    </th>
                    <th style="width: 27%;">
                        Название блюда
                    </th>
                    <th style="width: 27%;">
                        Цена
                    </th>
                    <th style="width: 27%;">
                        <form action="" method="post">
                            <input type="hidden" name="command" value="DELETE_FROM_BASKET_COMMAND">
                            <button type="submit" class="choice">
                                Удалить из корзины
                            </button>
                        </form>
                    </th>
                </tr>
                <tr>
                    <th style="width: 27%;">
                        <img src="img/bread2-removebg-preview.png" alt="dish" width="134.5" height="107" style="margin-left: 10%;">
                    </th>
                    <th style="width: 27%;">
                        Название блюда
                    </th>
                    <th style="width: 27%;">
                        Цена
                    </th>
                    <th style="width: 27%;">
                        <form action="" method="post">
                            <input type="hidden" name="command" value="DELETE_FROM_BASKET_COMMAND">
                            <button type="submit" class="choice">
                                Удалить из корзины
                            </button>
                        </form>
                    </th>
                </tr>
            </table>

            <div>
                <form action="" method="get">
                    <input type="hidden" name="command" value="GO_TO_CREATE_ORDER_PAGE">
                    <button type="submit" class="choice" style="margin-left: 36%;margin-top: 5%;">
                        Оформить заказ
                    </button>
                </form>
            </div>

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
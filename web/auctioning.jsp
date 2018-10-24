<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/7
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".sale-buttom").click(function () {
                if ($("#sale").val()>$("#max").text()){
                    $("#form1").submit()
                }else {
                    alert("出价必须大于最大竞拍价")
                }
            });
        });
        $(function () {
            alert($("#max").text());
        });
    </script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="items sg-font lf">
        <ul class="rows">
            <li>名称：</li>
            <li class="borderno">${sessionScope.product.productname}</li>
        </ul>
        <ul class="rows">
            <li>描述：</li>
            <li class="borderno">${sessionScope.product.pdescribe}</li>
        </ul>
        <ul class="rows">
            <li>开始时间：</li>
            <li class="borderno">${sessionScope.product.starttime}</li>
        </ul>
        <ul class="rows">
            <li>结束时间：</li>
            <li class="borderno">${sessionScope.product.endtime}</li>
        </ul>
        <ul class="rows border-no">
            <li>起拍价：</li>
            <li class="borderno">${sessionScope.product.startprice}</li>
        </ul>
    </div>
    <div class="rg borders"><img src="images/ad20.jpg" width="270" height="185" alt="" /></div>
    <div class="cl"></div>
    <div class="top10 salebd">
        <p>
        <form id="form1" action="addRec" method="post">
            <label for="sale">出价：</label>
            <input type="text"  class="inputwd" id="sale" name="auctionPrice" value=""/>
            <input name="auction" type="button" value="竞 拍" class="sale-buttom" />
        </form>
        </p>
        <p class="f14 red">不能低于最高竞拍价</p>
    </div>
    <div class="top10">
        <input name="" type="submit" value="刷 新" class="spbg buttombg f14" />
        <input name="" type="submit" value="返回列表" class="spbg buttombg f14" />
    </div>
    <div class="offer">
        <h3>出价记录</h3>
        <div class="items sg-font">
            <ul class="rows even strong">
                <li>竞拍时间</li>
                <li>竞拍价格</li>
                <li class="borderno">竞拍人</li>
            </ul>
            <c:forEach items="${requestScope.recordList}" var="record">
                <ul class="rows">
                    <li>${record.auctiontime}</li>
                    <li>${record.auctionprice}</li>
                    <li class="borderno">${record.username}</li>
                </ul>
            </c:forEach>
        </div>
    </div>
    <!-- main end--><span id="max"style="display: none">${requestScope.maxprice}</span>
</div>

</body>
</html>

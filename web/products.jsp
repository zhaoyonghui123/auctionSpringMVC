<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/7
  Time: 15:40
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
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="forms">
        <label for="name">名称</label>
        <input name="" type="text" class="nwinput" id="name"/>
        <label for="names">描述</label>
        <input name="" type="text" id="names" class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="" type="text" id="time" class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="" type="text" id="end-time" class="nwinput" />
        <label for="price">起拍价</label>
        <input name="" type="text" id="price" class="nwinput" />
        <input name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
    </div>

    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>
<c:forEach items="${applicationScope.pageBean.data}" var="productList">
    <ul class="rows">
        <li><a href="国书" title="">${productList.productname}</a></li>
        <li class="list-wd">${productList.pdescribe}</li>
        <li>${productList.starttime}</li>
        <li>${productList.endtime}</li>
        <li>${productList.startprice}</li>
        <li class="borderno red"><a href="auction?productId=${productList.productid}">竞拍</a></li>
    </ul>
</c:forEach>

    <div class="page">
<c:if test="${applicationScope.pageBean.pageIndex!=1}">
        <a href="productList?pageIndex=1" title="">首页</a>
        <a href="productList?pageIndex=${applicationScope.pageBean.prePageIndex}" title="">上一页</a>
</c:if>

        <c:forEach begin="1" end="${applicationScope.pageBean.totalPage}" step="1" varStatus="vs">

            <c:choose>
                <c:when test="${applicationScope.pageBean.pageIndex != vs.index}">
                    <a href="productList?pageIndex=${vs.index}">${vs.index}</a>
                </c:when>
                <c:otherwise>
                    ${vs.index}
                </c:otherwise>
            </c:choose>

        </c:forEach>
<c:if test="${applicationScope.pageBean.pageIndex!=applicationScope.pageBean.totalPage}">
        <a href="productList?pageIndex=${applicationScope.pageBean.totalPage}" title="">下一页</a>
        <a href="productList?pageIndex=${applicationScope.pageBean.nextPageIndex}" title="">尾页</a>
</c:if>
    </div>

</div>
</div>
</body>
</html>

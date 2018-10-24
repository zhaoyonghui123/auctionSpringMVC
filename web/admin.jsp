<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/9
  Time: 12:38
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
        $("#query").click(function () {
            if ($("#name").val()!=null){
                $("#queryLike").submit();
            }else{
                alert("输入不合法");
            }
        });
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
    <form id="queryLike" action="query" method="post">
    <div class="forms">
        <label for="name">名称</label>
        <input name="name" type="text" class="nwinput" id="name"/>
        <label for="names">描述</label>
        <input name="describe" type="text" id="names" class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="startTime" type="text" id="time" class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="endTime" type="text" id="end-time" class="nwinput" />
        <label for="price">起拍价</label>
        <input name="startPrice" type="text" id="price" class="nwinput" />
        <input id="query" name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
        <a href="addProduct.jsp"> <input id="sub" type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb"/></a>
    </div>
    </form>
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
                <li id="pid" style="display: none" >${productList.productid}</li>
                <li class="borderno red">
                    <a href="addProduct.jsp?id=${productList.productid}" title="竞拍" onclick="dele();">修改</a>|
                    <a  href="dele?id=${productList.productid}" title="竞拍" onclick="abc();">删除</a>
                </li>
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
                        <a  href="productList?pageIndex=${vs.index}">${vs.index}</a>
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

    <script>
        function abc(){

            if(confirm("你真的确认要删除吗？请确认")){

                return true;
            }
            else{
                return false;
            }

        };
        function dele(){
            if(confirm("你真的确认要修改吗？请确认")){
                return true;
            }
            else{
                return false;
            }
        }
    </script>
    <!-- main end-->
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/6
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){

               $.post("ajax1","key=value",function(result) {
                    alert(result);
                });

            /*    $.post("ajax2","key=value",function(result) {
                    alert(result.userid +"  "+result.username);
                },"json");*/
            });
        });
    </script>
</head>
<body>
<input type="button" id="btn"/>
</body>
</html>

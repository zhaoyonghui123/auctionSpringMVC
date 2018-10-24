<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/10
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="test?key=value1&key=value2">hello</a>
<br/>
<form action="test" method="post">
    <input type="text" name="id"/>
    <input type="text" name="name"/>
   1 <input type="text" name="strList[0].userid"/>
     <input type="text" name="strList[0].username"/>
    2 <input type="text" name="strList[1].userid"/>
    <input type="text" name="strList[1].username"/>
    <input type="submit" value="add"/>
</form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/6
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>无标题文档</title>
  <link href="css/common.css" rel="stylesheet" type="text/css" />
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <script type="text/javascript">

    $(function () {
        $("input[name='rigister']").click(function () {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var phone = $("#phone").val();
            var cards=$("#cards").val();
            var reg1 = /^\w{6,11}$/;
            var resultUser = reg1.test(userName);
            var resultPass = reg1.test(password);
            if (phone == ""|| cards == ""|| !resultPass || !resultUser
            || $("#rem_u").attr("checked")==null){
                alert("输入不合法");
            }else{
                $("#form1").submit();
            }
        })
    });

    </script>
</head>
<body>
<%
  String error = request.getParameter("error");
  if (error!=null){
      out.println(error);
  }
%>
<form action="rigister" method="post" id="form1">
<div class="wrap">
  <!-- main begin-->
      <div class="zclf login logns">
        <h1  class="blue">用户注册</h1>
          <dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input id="userName" name="userName" type="text" class="inputh lf" value="" />
             <div class="lf red laba">用户名要求不低于6个字符</div>
            </dd>
            <dd>
              <label> <small>*</small>密码</label>
              <input id="password" name="password" type="text" class="inputh lf" value="" />
              <div class="lf red laba">密码要求不低于6个字符</div>
            </dd>
            <dd>
              <label> <small>*</small>身份证号</label>
              <input  id="cards" name="cards" type="text" class="inputh lf" value="" />
              <div class="lf red laba">身份证号必填</div>
            </dd>
            <dd>
              <label> <small>*</small>电话</label>
              <input  id="phone" name="phone" type="text" class="inputh lf" value="" />
              <div class="lf red laba">电话号码必填</div>
            </dd>
            <dd>
              <label> <small>*</small>住址</label>
              <input type="text" class="inputh lf" value="" />
            </dd>
            <dd>
              <label> <small>*</small>邮政编码</label>
              <input type="text" class="inputh lf" value="" />
            </dd>
            <dd class="hegas">
              <label> <small>*</small>验证码</label>
              <input type="text" class="inputh inputs lf" value="" />
               <span class="wordp lf"><img src="images/img2.jpg" width="96" height="27" alt="" /></span>
               <span class="blues lf"><a href="" title="">看不清</a></span>
            </dd>
            <dd class="hegas">
              <label>&nbsp;</label>
               <input name=""  type="checkbox" id="rem_u"   />
              <label for="rem_u" class="labels">我同意<span class="blues">《服务条款》</span></label>
            </dd>
            <dd class="hegas">
              <label>&nbsp;</label>
              <input id="rigister" name="rigister" type="button" value="立即注册" />
            </dd>
          </dl>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</form>
</body>
</html>

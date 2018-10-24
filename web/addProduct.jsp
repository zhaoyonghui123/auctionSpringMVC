<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/9
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


    $("input[name='add']").click(function () {

        var name = $("#name").val();
        var price = $("#price").val();
        var time = $("#time").val();
        var floor = $("#floor").val();
        var endTime = $("#endTime").val();
        var describe = $("#describe").val();
        var reg = /^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$/;//time正则
        var reg1 = /^[0-9]*$/;
        reg.test(price);
        if (name == "" || !reg1.test(price) || !reg.test(endTime)
            ||!reg.test(time)||!reg1.test(floor) || describe == ""){
            alert("输入不合法");
        }else{
            $("#form1").submit();
        }

    })
        })

    </script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form id="form1" action="addProduct" method="post">
        <dl>
            <dd >
                <label>名称：</label>
                <input id="name" name="name" type="text" class="inputh lf" value="" />
                <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
                <label>起拍价：</label>
                <input id="price" name="price" type="text" class="inputh lf" value="" />
                <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
                <label>底价：</label>
                <input id="floor" name="floor" type="text" class="inputh lf" value="" />
                <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
                <label>开始时间：</label>
                <input  id="time" name="time" type="text" class="inputh lf" value="" />
                <div class="lf red laba">格式：2010-05-05 12:30:00</div>
            </dd>
            <dd>
                <label>结束时间：</label>
                <input id="endTime" type="text" name="endTime" class="inputh lf" value="" />
                <div class="lf red laba">格式：2010-05-06 16:30:00</div>
            </dd>
            <dd class="dds">
                <label>拍卖品图片：</label>
                <div class="lf salebd"><a href="#"><img src="images/ad20.jpg" width="100" height="100" /></a></div>
                <input id="img" name="img" type="file" class="offset10 lf" />

            </dd>
            <dd class="dds">
                <label>描述：</label>
                <textarea id="describe" name="describe" cols="" rows="" class="textarea"></textarea>
            </dd>
            <dd class="hegas">
                <input name="add" type="button" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input name="" type="submit" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf" />
            </dd>
        </dl>
        </form>
    </div>
    <!-- main end-->
    <!-- footer begin-->

</div>
<!--footer end-->

</div>
</body>
</html>

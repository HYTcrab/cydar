<%--
  Created by IntelliJ IDEA.
  User: HYTcr
  Date: 2018/8/4
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/wangEditor.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/profile.css">
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="main w clearfix">
        <c:forEach items="${imageList}" var="image">
            <img src="${image}">
        </c:forEach>
    </div>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
</body>
</html>

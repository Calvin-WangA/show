<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="../jquery/jquery-ui.css"/>
<script src="../jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../jquery/jquery-ui.js" language="javascript"></script>
<script type="text/javascript">
    $(function(){
    	alert('success');
    	$("#dialogId").dialog({
			autoOpen : true,
			width : 300,
			height : 200,
			modal : true,
			buttons : {
				"南行" : function() {
					$(this).dialog("close");
				},
				"北行" : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>
</head>

<body>
	<div id="dialogId" title="登录">
		<p>南行-----------北行</p>
	</div>
	<a href="userController/user.action?id=1">获取用户信息</a>
	<br>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kindeditor在线编辑器</title>

<style>
form {
	margin: 0;
}
textarea {
	display: block;
}
</style>
<link rel="stylesheet"
	href="../jquery/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="../jquery/jquery-1.12.0.min.js"></script>
<script charset="utf-8" src="../jquery/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="../jquery/kindeditor/lang/zh-CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			allowFileManager : true,
			afterCreate : function() { 
			    this.sync(); 
			}, 
			afterBlur:function(){ 
			    this.sync(); 
			}   
		});
	});
	
	function getContent()
	{
	    editor.sync(); 
	    alert($("#content h1").val());
	}
</script>
</head>
<body>
    <center>
		<div align="center">
			<h3>公告编辑</h3>
			
			<form action="busProclamationAction.action" method="post" enctype="multi/dataformat">
			   
				<textarea name="content" id="content"
					style="width: 800px; height: 400px; visibility: hidden;">
			    KindEditor
		        </textarea><br> 
		        <div align="left">
		                                     公告截止时间：<input type="text" name="endDate" align="left"/><br> 
		                                     附件：<input type="file" name="attachFile" /><br> 
		           <input type="button" value="提交" onClick="getContent()"/><br>
		        </div>
		                          
			</form>
		</div>
	</center>
</body>
</html>
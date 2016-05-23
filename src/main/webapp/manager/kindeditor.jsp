<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kindeditor在线编辑器</title>
<title>公告在线编辑</title>

<style>
* {
	margin: 0;
}

body {
	background-image: url("../images/edit.jpg");
	width: 100%;
	height: 100%;
}

#total {
	width: 60%; position：relative;
	margin-top: 20px;
}

#buttonArea {position：absolute;
	
}

input {
	margin-top: 8px;
}
</style>
<link rel="stylesheet"
	href="../jquery/kindeditor/themes/default/default.css" />
<script charset="utf-8"
	src="../include/jquery/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="../include/jquery/kindeditor/lang/zh-CN.js"></script>
<script>
	$(document).ready(function() {

		$.ajaxSetup({
			async : false
		});
		var editor;
		KindEditor.ready(function(K) {

			editor = K.create('textarea[name="content"]', {
				allowFileManager : true,
				/* filterMode: false,//是否开启过滤模式 */
				afterCreate : function() {
					this.sync();
				},
				afterBlur : function() {
					this.sync();
				},
				afterChange : function() { //编辑器内容发生变化后，将编辑器的内容设置到原来的textarea控件里
					this.sync();
				}
			});
		});

		$('#title').blur(function() {
			var title = $.trim($('#title').val());
			if (title.length < 1) {
				alert("标题不能为空");
			}
		});

		$('#validityDate').blur(function() {
			var regex = /^[0-9]*$/
			var validityDate = $.trim($('#validityDate').val());
			if (!regex.test(validityDate)) {
				alert("请输入数字类型！");
			}
		});

		$('#content').blur(function() {
			var content = $.trim($('#content').val());
			if (content.length < 1) {
				alert("请输入公告内容!");
			}
		});

	});
	function setQuery(query) {
		var title = $.trim($('#title').val());
		if (title.length < 1) {
			alert("标题不能为空");
			return false;
		}

		var regex = /^[0-9]*$/
		var validityDate = $.trim($('#validityDate').val());
		if (!regex.test(validityDate)) {
			alert("请输入数字类型！");
			return false;
		}

		var content = $.trim($('#content').val());
		if (content.length < 1) {
			alert("请输入公告内容!");
			return fase;
		}

		$('#query').val(query);
		
		document.uploadProclamationAction.submit();
	}
	
	function backResearch()
	{
		window.location.href="../bus/initBusProcalmationAction.action";
	}
</script>
</head>
<body>
    <center>
		<div align="center">
			<h3>公告编辑</h3>
			
			<form action="busProclamationAction.action" method="post" enctype="multi/dataformat">
			   
				<textarea name="content" id="content"
					style="width: 100%; height: 300px; visibility: hidden;">
					<s:property value="#request.content" escape="true" />
		        </textarea>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线文本编辑器</title>

<script type="text/javascript" src="../jquery/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
    CKEDITOR.replace('area2')
</script>
</head>
<body>
	<div id="sample">
		<textarea name="area2" style="width: 100%;">
       Some Initial Content was in this textarea
        </textarea>
		
	</div>
</body>
</html>
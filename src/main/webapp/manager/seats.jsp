<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/drag_drop.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../css/jquery.Jcrop.css" type="text/css" />
	
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../js/seats.js" type="text/javascript"></script>
<script src="../js/jquery.Jcrop.js"></script>
<script src="../js/jquery.color.js"></script>
<script type="text/javascript">
  jQuery(function($){

    var api;

    $('#dragContainer').Jcrop({
      // start off with jcrop-light class
      bgOpacity: 1.0,
      bgColor: 'white',
      addClass: 'jcrop-light'
    },function(){
      api = this;
      api.setOptions({ bgFade: true });
      api.ui.selection.addClass('jcrop-selection');
    });

  });
</script>

</head>
<body>
	<center>
		<div id="dragContainer" class="dragManager">
		   <table>
		       <tr>
		           <td><label class="dragItem">item1</label></td>
		           <td><label class="dragItem">item2</label></td>
		           <td><label class="dragItem">item3</label></td>
		           <td><label class="dragItem">item4</label></td>
		       </tr>
		       <tr>
		           <td><label class="dragItem">item5</label></td>
		           <td><label class="dragItem">item6</label></td>
		           <td><label class="dragItem">item7</label></td>
		           <td><label class="dragItem">item8</label></td>
		       </tr>
		       <tr>
		           <td><label class="dragItem">item9</label></td>
		           <td><label class="dragItem">item10</label></td>
		           <td><label class="dragItem">item11</label></td>
		           <td><label class="dragItem">item12</label></td>
		       </tr>
		       <tr>
		           <td><label class="dragItem">item13</label></td>
		           <td><label class="dragItem">item14</label></td>
		           <td><label class="dragItem">item15</label></td>
		           <td><label class="dragItem">item16</label></td>
		       </tr>
		   </table>
		</div>
		<div>
		    <input type="button" value="提交" id="submit" />
		    <input type="reset" value="重置" id="reset"/>
		</div>
		
	</center>
</body>
</html>
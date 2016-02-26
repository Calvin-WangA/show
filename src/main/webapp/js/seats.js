$(document).ready(function() {

	var gx = 0;
	var gy = 0;
	$('#dragContainer').mousedown(function(e) {
		gx = e.pageX;
		gy = e.pageY;
	})

	//当多选放开鼠标时执行该操作
	$('#dragContainer').mouseup(function(e) {
		var tx = e.pageX;
		var ty = e.pageY;
		// 当大于一个元素时，则进行该div内的元素遍历，并且给被框的标签置状态
		// 下面这些条件要根据标签的大小做相应的调整
		if ((ty - gy > 40) || (tx - gx > 60)) {
			// 遍历获得元素，并且置相应的状态
			$("#dragContainer label").each(function(index, element) {
				var Y = $(this).offset().top;
				var X = $(this).offset().left;
				var style = $(this).attr('class');
				if ((X <= tx && Y <= ty) || (X > tx && (ty - Y > 30))) {
					if ('Color' == style) {
						$(this).attr("class", "dragItem");
					} else {
						$(this).attr("class", "Color");
					}
				}
			});
		}
	})
	
	// 单独点击的时候也是可以选中的
	$('label').click(function() {
		var style = $(this).attr('class');
		if ('Color' == style) {
			$(this).attr("class", "dragItem");
		} else {
			$(this).attr("class", "Color");
		}
	})
	
	// 提交
	$('#submit').click(function() {
		var seats = "|";
		$("#dragContainer label").each(function(index, element) {
			var color = $(this).attr("class")
			// 如果color表示的是被选中的，则获取到相应的数据
			if ('Color' == color) {
				seats += $(this).text() + "|";
			}
		});
		// 调用ajax将参数传到后台
		$.post("seat/setSeat.action", 
				{'seats' : seats},
				function(returnedData) {// 该方法进行提交返回处理
                   alert("success");
		});
	})
	
	//重置座位
	$('#reset').click(function(){
		$("#dragContainer label").each(function(index, element) {
			$(this).attr("class","dragItem");
		});
	})
})
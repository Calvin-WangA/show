/**
 * Created by CalvinWang on 2016/11/20.
 */
var table;
$(document).ready(function() {
    table = $('#example').DataTable({
        dom: 'Bfrtip', //自定义个组件样式
        /* select: true, *///选择行的意思
         buttons: [
            {
                extend: 'collection',
                text: '导出',
                buttons: [
                    'copy',
                    'csv',
                    'print'
                ],
            }
        ],
        "oLanguage": {
            "sSearch": "搜索",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "oPaginate" : {
                "sFirst" : "首页",
                "sPrevious" : "上一页",
                "sNext" : "下一页",
                "sLast" : "尾页",
            },
            "sZeroRecords": "没有检索到数据",
            "sProcessing": "<img src=\'#\' /loading.gif’ />",
        },
        "iDisplayLength": 12, //每页显示数据量，该参数有效则bStateSave为false，否则从cookie中读取，就会无效。
        "bInfo": false,  //页脚信息
        "bAutoWidth": true,//自动宽度
        "bFilter": false, //过滤功能
        "bLengthChange": false, //改变每页显示数据数量
        "bPaginate": true, //翻页功能
        "bStateSave": false, //保存上次翻页的信息
        "pagingType": "full_numbers",//simple - 只有上一页、下一页两个按钮
        //simple_numbers - 除了上一页、下一页两个按钮还有页数按钮，Datatables默认是这个
        //full - 有四个按钮首页、上一页、下一页、末页
        //full_numbers - 除首页、上一页、下一页、末页四个按钮还有页数按钮

    });

    //设置双击编辑单元项数据
    $('td').dblclick(function(event) {
        var value = $(this).text();
        var html = "<input type='text' value='"
            + value + "' style=" + "'width:"
            + $(this).width() + "px;height:"
            + $(this).height() + "px'/>";

        $(this).empty();
        $(this).append(html);
        //取消父级传下来的触发事件
        $(this).find("input").click(function(event) {
            var e = window.event || event;
            if (e.stopPropagation) {
                e.stopPropagation();
            } else {
                e.cancelBubble = true;
            }
        });
    });

    //单击还原
    $('td').click(function(event) {
        $('tr td').each(function() {
            if ($(this).has("input").length > 0) {
                var iput = $(this).find("input");
                var value = iput.val();
                $(this).empty();
                $(this).text(value);
            }
        });
    });
    //放在后面，否则会导致追加的click事件失效
    var tableTools = new $.fn.dataTable.TableTools( table, {
     "buttons": [
     "copy",
     "csv",
     "xls",
     "pdf",
     { "type": "print", "buttonText": "Print me!" }
     ]
     });

     $( tableTools.fnContainer() ).insertAfter('div.info');
});
//获取编辑后的信息
function getTableContent() {

    var nTrs = table.rows().nodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
    alert(nTrs.length);
    for (var i = 0; i < nTrs.length; i++) {

        console.log('[获取数据]' + table.data(nTrs[i]));//fnGetData获取一行的数据

    }

}
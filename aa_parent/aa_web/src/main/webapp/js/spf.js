$(function(){
	//加载表格数据
	$('#grid').datagrid({
		queryParams:{},
		columns:[[
		    {field:'name',title:'月份',width:100},
		    {field:'y',title:'客流量',width:100}
		]],
		singleSelect: true,
		onLoadSuccess:function(data){
			//alert(JSON.stringify(data));
			//显示图
			//showChart(data.rows);
			showChart();
		}
		
	});

	$('#city').combobox({    
	    idField:'id',    
	    textField:'city',
	    valueField:'city',
	    url:'report_getGroupOne?group=city',    
	   
	}); 
	//点击查询按钮
	$('#btnSearch').bind('click',function(){
		//把表单数据转换成json对象
		var formdata = $('#searchForm').serializeJSON();
		
		$('#grid').datagrid('load',formdata);
		$('#grid').datagrid({
			url:'report_pflow',
			queryParams:formdata
		});
	});
	
	
});

function showChart(){
	var months = new Array();
	var j=null;
	for(var i = 1; i <= 12; i++){
		if(j==null){
			j=i
		}
		else{
			j=j+"-"+i;
		}
		if(i%2==0){
			months.push(j + "月");
			j=null;
		}
		
	}
	
	$('#trendChart').highcharts({
        title: {
            text:$('#city').combobox('getValue') + "地区客流量分析",
            x: -20 //center
        },
        subtitle: {
            text: '来源: 蚂蜂窝（www.mafengwo.cn）',
            x: -20
        },
        xAxis: {
            categories: months
        },
        yAxis: {
            title: {
                text: '客流量'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '人数'
        },
        legend: {
            layout: 'vertical',
            align: 'center',
            verticalAlign: 'bottom',
            borderWidth: 0
        },
        series: [{
            name: '客流量',
            data: $('#grid').datagrid('getRows')
        }],
        credits:{
        	enabled: false
        }
    });
}
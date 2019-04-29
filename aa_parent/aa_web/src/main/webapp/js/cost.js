$(function(){
	//加载表格数据
	$('#grid').datagrid({
		queryParams:{},
		columns:[[
		    {field:'name',title:'花费金额',width:100},
		    {field:'value',title:'人数',width:100}
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
			url:'report_cost',
			queryParams:formdata
		});
	});
	
	
});

function showChart(){
	var myChart = echarts.init(document.getElementById('trendChart'));

    // 指定图表的配置项和数据
    var option = {
       title : {
    	        text: $('#city').combobox('getValue')+"地区人均花费分布图",
    	        subtext: '来源：蚂蜂窝（www.mafengwo.cn）',
    	        x:'center'
    	    },
       legend: {
    	        orient : 'vertical',
    	        x : 'left',
    	        data:['1-999','1k-6k','6k-20k','20k以上']
    	    },
        series : [
    {
        name: '访问来源',
        type: 'pie',
        radius: '55%',
        data: $('#grid').datagrid('getRows')
    }
]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
$(function(){
	//加载表格数据
	$('#grid').datagrid({
		queryParams:{},
		columns:[[
		    {field:'name',title:'出行天数',width:100},
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
			url:'report_time',
			queryParams:formdata
		});
	});
	
	
});

function showChart(){
	var myChart = echarts.init(document.getElementById('trendChart'));

    // 指定图表的配置项和数据
	option = {
			title : {
				text : $('#city').combobox('getValue')+"出行天数分析",
				subtext : '来源：蚂蜂窝（www.mafengwo.cn）',
				x : 'center'
			},
	
		    legend: {
		    	orient : 'vertical',
    	        x : 'left',
		        data:['3天以下','4-7天','8-14天','15天以上']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'center',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : ['50%', '70%'],
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : true
		                    },
		                    labelLine : {
		                        show : true
		                    }
		                },
		                
					   
		                emphasis : {
		                    label : {
		                        show : true,
		                        position : 'center',
		                        textStyle : {
		                            fontSize : '30',
		                            fontWeight : 'bold'
		                        }
		                    }
		                }
		            },
		            data: $('#grid').datagrid('getRows')
		            
		        }
		    ]
		};

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
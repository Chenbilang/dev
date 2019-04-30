$(function() {
	var mydata;
	$.get("report_avg",{group: "city"}, function(data){
		
		var json = eval('(' + data + ')');
		var optionMap = {
				backgroundColor : '#FFFFFF',
				title : {
					text : '全国旅游地区人均费用(只含票价)',
					subtext : '来源：去哪儿（www.qunar.com）',
					x : 'center'
				},
				tooltip : {
					trigger : 'item'
				},

				//左侧小导航图标
				visualMap : {
					show : true,
					x : 'left',
					y : 'center',
					splitList : [ {
						start : 250,
						end : 300
					}, {
						start : 200,
						end : 250
					}, {
						start : 150,
						end : 200
					}, {
						start : 100,
						end : 150
					}, {
						start : 50,
						end : 100
					}, {
						start : 0,
						end : 50
					}, ],
					color : [ '#5475f5', '#9feaa5', '#85daef', '#74e2ca', '#e6ac53',
							'#9fb5ea' ]
				},

				//配置属性
				series : [ {
					name : '数据',
					type : 'map',
					mapType : 'china',
					roam : true,
					label : {
						normal : {
							show : true
						//省份名称  
						},
						emphasis : {
							show : false
						}
					},
					data : json
				//数据
				} ]
			};
			//初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));

			//使用制定的配置项和数据显示图表
			myChart.setOption(optionMap);
			  });
	

});
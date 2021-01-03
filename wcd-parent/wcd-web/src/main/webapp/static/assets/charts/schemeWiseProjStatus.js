$(function () {
	
	Highcharts.chart('schemeWiseProjStatus', {
			    chart: {
			        type: 'pie',
			        options3d: {
			            enabled: true,
			            alpha: 45,
			            beta: 0
			        }
			    },
			    title: {
			        text: null
			    },
			    plotOptions: {
			        pie: {
			            allowPointSelect: true,
			            cursor: 'pointer',
			            innerSize: 50,
			            depth: 35,
			            dataLabels: {
			                enabled: true
			            },
            			showInLegend: false
			        }
			    },
			    tooltip: {
			        headerFormat: '<span style="font-size:14px"><b>{series.name}</b></span><br>',
			        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b><br/>'
			    },
			    

			    "series": [
			        {
			            "name": "Total Projects",
			            "colorByPoint": true,
			            "data": [
			                {
			                    "name": "Rural Houshing",
			                    "y": 635
			                },
			                {
			                    "name": "NREGA",
			                    "y": 234
			                },
			                {
			                    "name": "GGY",
			                    "y": 224
			                },
			                {
			                    "name": "OLM",
			                    "y": 344
			                },
			                {
			                    "name": "RURBAN",
			                    "y": 444
			                },
			                {
			                    "name": "SIRD",
			                    "y": 223
			                },
			                {
			                    "name": "DW & S",
			                    "y": 452
			                },
			                {
			                    "name": "CFC",
			                    "y": 452
			                },
			                {
			                    "name": "SFC",
			                    "y": 452
			                }
			            ]
			        }
			    ]
			});

});
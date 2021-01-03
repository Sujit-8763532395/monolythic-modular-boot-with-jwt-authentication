$(function () {
	
	var DistrictWise_scheme = Highcharts.chart('districtWiseFundStatus', {
				chart: {
			        type: 'column',
			        options3d: {
			            enabled: true,
			            alpha: 0,
			            beta: 0,
			            depth: 20
			        }
			    },
			    title: {
			        text: null
			    },
			    xAxis: {
			        type: 'category'
			    },
			    yAxis: {
			        title: {
			            text: 'Amount'
			        }

			    },
			    legend: {
			        enabled: false
			    },
			    plotOptions: {
			        series: {
			            borderWidth: 0,
			            dataLabels: {
			                enabled: false
			            }
			        }
			    },

			    tooltip: {
			        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
			        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b><br/>'
			    },

			    "series": [
			        {
			            "name": "Total Amount Disbursed",
			            "colorByPoint": true,
			            "data": [
			                {
			                    "name": "Anugul",
			                    "y": 6204,
			                   
			                },
			                {
			                    "name": "Banarpal",
			                    "y": 4567,
			                   
			                },
			                {
			                    "name": "Chhendipada",
			                    "y": 2702,
			                    
			                },
			                {
			                    "name": "Athamallik",
			                    "y": 4522,
			                    
			                },
			                {
			                    "name": "Kishorenagar",
			                    "y": 2240,
			                    
			                },
			                {
			                    "name": "Pallahara",
			                    "y": 6192,
			                    
			                },
			                {
			                    "name": "Talcher",
			                    "y": 8102,
			                    
			                },
			                {
			                    "name": "Kaniha",
			                    "y": 1192,
			                    
			                },
			                {
			                    "name": "Dhenkanal",
			                    "y": 3136,
			                    
			                },
			                {
			                    "name": "Gajapati",
			                    "y": 1558,
			                    
			                }

			            ]
			        }
			    ],
			});
});
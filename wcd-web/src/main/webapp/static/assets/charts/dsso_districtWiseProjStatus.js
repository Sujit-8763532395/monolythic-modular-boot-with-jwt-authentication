$(function () {
	
	var DistrictWise_scheme = Highcharts.chart('districtWiseProjStatus', {
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
			            text: 'Projects'
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
			            "name": "Total Projects",
			            "colorByPoint": true,
			            "data": [
			                {
			                    "name": "Anugul",
			                    "y": 8,
			                   
			                },
			                {
			                    "name": "Banarpal",
			                    "y":6,
			                   
			                },
			                {
			                    "name": "Chhendipada",
			                    "y": 2,
			                    
			                },
			                {
			                    "name": "Athamallik",
			                    "y": 4,
			                    
			                },
			                {
			                    "name": "Kishorenagar",
			                    "y": 2,
			                    
			                },
			                {
			                    "name": "Pallahara",
			                    "y": 7,
			                    
			                },
			                {
			                    "name": "Talcher",
			                    "y": 6,
			                    
			                },
			                {
			                    "name": "Kaniha",
			                    "y": 5,
			                    
			                },
			                {
			                    "name": "Dhenkanal",
			                    "y": 8,
			                    
			                },
			                {
			                    "name": "Gajapati",
			                    "y": 7,
			                    
			                }

			            ]
			        }
			    ],

			});
});
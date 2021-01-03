			Highcharts.chart('basnp', {
			    chart: {
			        type: 'pie',
			        options3d: {
			            enabled: true,
			            alpha: 45,
			            beta: 0
			        }
			    },
			    lang: {
		              drillUpText: '<< Back'
		          },
			    title: {
			        text: null
			    },
			    plotOptions: {
			        pie: {
			            allowPointSelect: true,
			            cursor: 'pointer',
			            depth: 35,
			            dataLabels: {
			                enabled: false,
			                format: '{point.name}: {point.y}k'
			            },
            showInLegend: true
			        }
			    },

			    tooltip: {
			        headerFormat: '<span style="font-size:13px;color:{point.color}">{series.name}</span><br>',
			        pointFormat: '<span><b>{point.name}</b></span>: <b>{point.y}</b><br/>'
			    },

			    series: [
			        {
			            name: "",
			            colorByPoint: true,
			            data: [
			                {
			                    name: "Take Home Ration",
			                    y: 2000,
			                    drilldown: "TMR"
			                },
			                {
			                    name: "Hot Cooked Meal",
			                    y: 1057,
			                    drilldown: "HCM"
			                }
			                
			            ]
			        }
			    ],
			    drilldown: {
			        series: [
			            {
			                name: "Take Home Ration",
			                id: "TMR",
			                data: [
			                    [
			                        "Pregnant Women",
			                        5672
			                    ],
			                    [
			                        "Lacating Women",
			                        3243
			                    ],
			                    [
				                    "Severely Malnourished Children",
				                        3243
			                    ]
			                ]
			            },
			            {
			                name: "Hot Cooked Meal",
			                id: "HCM",
			                data: [
			                    [
			                        "Children (0-3 years)",
			                        5672
			                    ],
			                    [
			                        "Children (3-6 years)",
			                        3243
			                    ]
			                ]
			            },
			            {
			                name: "SBM-G",
			                id: "SBMG",
			                data: [
			                    [
			                        "Expenditure",
			                        5672
			                    ],
			                    [
			                        "Balance",
			                        3243
			                    ]
			                ]
			            },
			            {
			                name: "PMAY-G",
			                id: "PMAY-G",
			                data: [
			                    [
			                        "Expenditure",
			                        5672
			                    ],
			                    [
			                        "Balance",
			                        3243
			                    ]
			                ]
			            }
			        ]
			    }
			});
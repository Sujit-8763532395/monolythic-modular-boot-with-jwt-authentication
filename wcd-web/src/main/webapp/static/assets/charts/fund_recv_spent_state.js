			Highcharts.chart('BASNP', {
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
			        pointFormat: '<span><b>{point.name}</b></span>: <b>{point.y}</b>k (inr)<br/>'
			    },

			    series: [
			        {
			            name: "Total Fund Received",
			            colorByPoint: true,
			            data: [
			                {
			                    name: "Scheme-1",
			                    y: 274,
			                    drilldown: "Scheme-1"
			                },
			                {
			                    name: "Scheme-2",
			                    y: 557,
			                    drilldown: "Scheme-2"
			                },
			                {
			                    name: "Scheme-3",
			                    y: 923,
			                    drilldown: "Scheme-3"
			                },
			                {
			                    name: "Scheme-4",
			                    y: 1158,
			                    drilldown: "Scheme-4"
			                },
			                {
			                    name: "Scheme-5",
			                    y: 158,
			                    drilldown: "Scheme-5"
			                },
			                {
			                    name: "Scheme-6",
			                    y: 758,
			                    drilldown: "Scheme-6"
			                }
			            ]
			        }
			    ],
			    drilldown: {
			        series: [
			            {
			                name: "Scheme-1",
			                id: "Scheme-1",
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
			                name: "Scheme-2",
			                id: "Scheme-2",
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
			                name: "Scheme-3",
			                id: "Scheme-3",
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
			                name: "Scheme-4",
			                id: "Scheme-4",
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
			                name: "Scheme-5",
			                id: "Scheme-5",
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
			                name: "Scheme-6",
			                id: "Scheme-6",
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
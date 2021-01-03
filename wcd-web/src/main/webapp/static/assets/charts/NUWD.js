			Highcharts.chart('nuwd', {
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
			                    name: "Swadhar Greh",
			                    y: 2000,
			                    drilldown: "SG"
			                },
			                {
			                    name: "Ujjawala",
			                    y: 1057,
			                    drilldown: "UJL"
			                },
			                {
			                    name: "One Step Centre",
			                    y: 1057,
			                    drilldown: "OSC"
			                }
			                
			            ]
			        }
			    ],
			    drilldown: {
			        series: [
			            {
			                name: "Swadhar Greh",
			                id: "SG",
			                data: [
			                    [
			                        "Desserted Widows",
			                        5672
			                    ],
			                    [
			                        "Unaccepted Women Prisoners",
			                        3243
			                    ],
			                    [
				                    "Natural Calamity Survivors",
				                        3243
			                    ],
			                    [
			                    	"Mentally Challenged Women",
			                    		1234
			                    ]
			                ]
			            }
			        ]
			    }
			});
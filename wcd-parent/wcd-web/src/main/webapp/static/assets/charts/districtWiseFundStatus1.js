$(function () {
	
	var DistrictWise_scheme = Highcharts.chart('districtWiseFundStatus1', {
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
			            text: 'Progress(%)'
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
			        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b>%<br/>'
			    },

			    "series": [
			        {
			            "name": "Progress",
			            "colorByPoint": true,
			            "data": [
			                {
			                    "name": "Project-1",
			                    "y": 46,
			                     "drilldown": "cl1"
			                         },
			                {
			                    "name": "Project-2",
			                    "y": 54,
			                     "drilldown": "cl2"

			                            },
			                {
			                    "name": "Project-3",
			                    "y": 30,
			                     "drilldown": "cl3"
			                              },
			                {
			                    "name": "Project-4",
			                    "y": 45,
			                     "drilldown": "cl4"
			                                   },
			                {
			                    "name": "Project-5",
			                    "y": 22,
			                     "drilldown": "cl5"
			                           },
			                

			            ]
			        }
			    ],
			    //  "drilldown": {
			    //     "series": [
			    //         {
			    //             "name": "Fund Requisition",
			    //             "id": "cl1",
			    //             "data": [["January",5],["February",3],["March",2],["April",7],["May",13],["June",43],["July",11],["August",24],["September",11],["October",31],["November",11],["December",8]]
			                
			    //         },
			    //          {
			    //             "name": "Fund Requisition",
			    //             "id": "cl2",
			    //             "data": [["January",5],["February",13],["March",2],["April",7],["May",13],["June",43],["July",11],["August",24],["September",11],["October",31],["November",11],["December",8]]
			                
			    //         },
			    //          {
			    //             "name": "Fund Requisition",
			    //             "id": "cl3",
			    //             "data": [["January",5],["February",3],["March",2],["April",7],["May",13],["June",43],["July",11],["August",24],["September",11],["October",31],["November",11],["December",8]]
			                
			    //         },
			    //          {
			    //             "name": "Fund Requisition",
			    //             "id": "cl4",
			    //             "data": [["January",5],["February",3],["March",2],["April",7],["May",13],["June",43],["July",11],["August",24],["September",11],["October",31],["November",11],["December",8]]
			                
			    //         },
			    //          {
			    //             "name": "Fund Requisition",
			    //             "id": "cl5",
			    //             "data": [["January",5],["February",3],["March",2],["April",7],["May",13],["June",43],["July",11],["August",24],["September",11],["October",31],["November",11],["December",8]]
			                
			    //         }
			    //     ]
			    // }

			});
});
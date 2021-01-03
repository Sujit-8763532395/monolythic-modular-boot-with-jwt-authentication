$(function () {
    // Create the chart
    $('#districtWiseFundStatus').highcharts({
        chart: {
            type: 'column'
        },

			    title: {
			        text: null
			    },
        xAxis: {
            type: 'category'
        },
        yAxis: {
			        title: {
			            text: 'Amount(Cr)'
			        }

			    },
			     lang: {
		              drillUpText: '<< Back'
		          }
			    ,
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
			        headerFormat: '<span style="font-size:11px">{data.name}</span><br>',
			        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b>Cr<br/>'
			    },
        series: [{
            data: [{
                name: 'Cluster-1',
                y: 2569,
                drilldown: 'Cluster-1'
            }, {
                name: 'Cluster-2',
                y: 1124,
                drilldown: 'Cluster-2'
            },
             {
                name: 'Cluster-3',
                y: 2134,
                drilldown: 'Cluster-3'
            },
             {
                name: 'Cluster-4',
                y: 3344,
                drilldown: 'Cluster-4'
            },
             {
                name: 'Cluster-4',
                y: 8424,
                drilldown: 'Cluster-4'
            },
             {
                name: 'Cluster-5',
                y: 9154,
                drilldown: 'Cluster-5'
            },
             {
                name: 'Cluster-6',
                y: 1864,
                drilldown: 'Cluster-6'
            },
             {
                name: 'Cluster-7',
                y: 7964,
                drilldown: 'Cluster-7'
            },
             {
                name: 'Cluster-8',
                y: 1884,
                drilldown: 'Cluster-8'
            },
             {
                name: 'Cluster-9',
                y: 9674,
                drilldown: 'Cluster-9'
            },
             {
                name: 'Cluster-10',
                y: 1804,
                drilldown: 'Cluster-10'
            },
             {
                name: 'Cluster-11',
                y: 2811,
                drilldown: 'Cluster-11'
            },
             {
                name: 'Cluster-12',
                y: 2534,
                drilldown: 'Cluster-12'
            },
             {
                name: 'Cluster-13',
                y: 9924,
                drilldown: 'Cluster-13'
            },
             {
                name: 'Cluster-14',
                y: 2444,
                drilldown: 'Cluster-14'
            },
             {
                name: 'Cluster-15',
                y:1554,
                drilldown: 'Cluster-15'
            },
             {
                name: 'Cluster-16',
                y: 5884,
                drilldown: 'Cluster-16'
            },
             {
                name: 'Cluster-17',
                y: 1294,
                drilldown: 'Cluster-17'
            },
             {
                name: 'Cluster-18',
                y: 5134,
                drilldown: 'Cluster-18'
            },
             {
                name: 'Cluster-19',
                y: 8584,
                drilldown: 'Cluster-19'
            }
            ]
        }],
        drilldown: {
            series: [{
                name: 'Cluster-1',
                id: 'Cluster-1',
                data: [{
                    name: 'January',
                    y: 80,
                    drilldown: 'January'
                },
                {
                    name: 'February',
                    y: 142,
                    drilldown: 'February'
                },
                {
                    name: 'March',
                    y: 232,
                    drilldown: 'March'
                },
                {
                    name: 'April',
                    y: 255,
                    drilldown: 'April'
                },
                {
                    name: 'May',
                    y: 248,
                    drilldown: 'May'
                },
                {
                    name: 'June',
                    y: 212,
                    drilldown: 'June'
                },{
                    name: 'July',
                    y: 20,
                    drilldown: 'July'
                },
                {
                    name: 'August',
                    y: 112,
                    drilldown: 'August'
                },
                {
                    name: 'September',
                    y: 532,
                    drilldown: 'September'
                },
                {
                    name: 'October',
                    y: 582,
                    drilldown: 'October'
                },
                {
                    name: 'November',
                    y: 92,
                    drilldown: 'November'
                },
                {
                    name: 'December',
                    y: 62,
                    drilldown: 'December'
                }]
            }, {
                name: 'Cluster-2',
                id: 'Cluster-2',
                data: [
                    [
                        'v40.0',
                    5]
                ]
            }, {
                id: 'January',
                data: [
                    [
                        'Project-1',
                    17],
                    [
                        'Project-2',
                    5],
                    [
                        'Project-3',
                    15.2],
                    [
                        'Project-4',
                    21.8],
                    [
                        'Project-5',
                    21]
                ]
            }]
        }
    });
});
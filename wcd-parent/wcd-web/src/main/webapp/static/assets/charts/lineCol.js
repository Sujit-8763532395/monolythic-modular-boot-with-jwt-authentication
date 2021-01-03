Highcharts.chart('lineCol', {
    chart: {
        zoomType: 'xy'
    },
    title: {
       text: ''
    },
    xAxis: [{
        categories: ['Cluster-1', 'Cluster-2', 'Cluster-3', 'Cluster-4', 'Cluster-5', 'Cluster-6',
            'Cluster-7', 'Cluster-8', 'Cluster-9', 'Cluster-10', 'Cluster-11', 'Cluster-12','Cluster-13','Cluster-14','Cluster-15','Cluster-16','Cluster-17','Cluster-18','Cluster-19'],
        crosshair: true
    }],
    yAxis: [{ // Primary yAxis
        labels: {
            format: '{value}Cr',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        },
        title: {
            text: 'Fund Requisition',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        }
    }, { // Secondary yAxis
        title: {
            text: 'Fund Disbursed',
            style: {
                color: Highcharts.getOptions().colors[0]
            }
        },
        labels: {
            format: '{value} Cr',
            style: {
                color: Highcharts.getOptions().colors[0]
            }
        },
        opposite: true
    }],
    tooltip: {
        shared: true
    },
    legend: {
        backgroundColor:
            Highcharts.defaultOptions.legend.backgroundColor || // theme
            'rgba(255,255,255,0.25)'
    },
    series: [{
        name: 'Requisition',
        type: 'column',
        yAxis: 1,
        data: [350, 271, 300, 129, 144, 176, 135, 148, 271, 394, 195, 254,78,125,345,281,255,60,45],
        tooltip: {
            valueSuffix: ' Cr'
        }

    }, {
        name: 'Disbursed',
        type: 'spline',
        data: [245,180,250,115,140,165,100,132,255,185,186,78,70,105,240,180,40,55,45],
        tooltip: {
            valueSuffix: 'Cr'
        }
    }]
});
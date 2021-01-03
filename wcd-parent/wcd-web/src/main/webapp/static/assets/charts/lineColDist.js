Highcharts.chart('lineColDist', {
    chart: {
        zoomType: 'xy'
    },
    title: {
       text: ''
    },
    xAxis: [{
        categories: ['Project-1', 'Project-2', 'Project-3', 'Project-4', 'Project-5', 'Project-6',
            'Project-7', 'Project-8', 'Project-9', 'Project-10'],
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
        data: [ 394, 195, 254,78,125,345,281,255,60,350],
        tooltip: {
            valueSuffix: ' Cr'
        }

    }, {
        name: 'Disbursed',
        type: 'spline',
        data: [185,186,78,70,105,240,180,40,55,260],
        tooltip: {
            valueSuffix: 'Cr'
        }
    }]
});
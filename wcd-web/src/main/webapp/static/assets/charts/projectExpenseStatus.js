Highcharts.chart('projectExpenseStatus', {
    chart: {
        type: 'areaspline'
    },
    title: {
        text: null
    },
    legend: {
        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
    },
    xAxis: {
        categories: [
            'Apr',
            'May',
            'Jun',
            'Jul',
            'Aug',
            'Sep',
            'Oct',
            'Nov',
            'Dec',
            'Jan',
            'Feb',
            'Mar'
        ]
    },
    yAxis: {
        title: {
            text: 'No. of Works'
        }
    },
    tooltip: {
        shared: true,
        valueSuffix: ''
    },
    credits: {
        enabled: false
    },
    plotOptions: {
        areaspline: {
            fillOpacity: 0.5
        }
    },
    series: [{
        name: 'Target',
        data: [3, 4, 3, 5, 4, 10, 12,3, 4, 3, 5, 4]
    }, {
        name: 'Achievement',
        data: [1, 3, 4, 3, 3, 5, 4, 1, 2, 3, 2, 2]
    }]
});
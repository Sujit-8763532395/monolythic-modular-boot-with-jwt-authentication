Highcharts.chart('progress', {
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
            'Project-1',
            'Project-2',
            'Project-3',
            'Project-4',
            'Project-5'
        ]
    },
    yAxis: {
        title: {
            text: 'Amount (Cr)'
        }
    },
    tooltip: {
        shared: true,
        valueSuffix: 'Cr'
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
        name: 'Release',
        data: [81, 63, 74, 43, 73]
    }, {
        name: 'Expenditure',
        data: [43, 54, 33, 25, 64]
    }]
});
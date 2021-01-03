Highcharts.chart('FundRecvStatus', {
/*    chart: {
        type: 'areaspline'
    },*/
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
            text: 'Amount'
        }
    },
    tooltip: {
        shared: true,
        valueSuffix: 'cr'
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
        name: 'Total Fund Received',
        data: [320, 304, 533, 554, 304, 0, 102,312, 456, 287, 150, 234]
    }]
});
var chart =Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    xAxis: {
        categories: [
            'Cluster-1',
            'Cluster-2',
            'Cluster-3',
            'Cluster-4',
            'Cluster-5'
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Fund Requisition'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} Cr</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: 'Phase-1',
        data: [49.9, 21.5, 10.4, 29.2, 44.0]

    },
     
      {
        name: 'Phase-2',
        data: [13.6, 58.8, 98.5, 23.4, 6.0,]

    }, {
        name: 'Phase-3',
        data: [38.9, 38.8, 39.3, 41.4, 47.0,]

    }],
    
});
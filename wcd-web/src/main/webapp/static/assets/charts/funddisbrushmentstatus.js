var fund_dishbrushment = Highcharts.chart('funddisbrushmentstatus', {
    chart: {
        zoomType: 'xy'
    },
    title: {
        text: 'Monthly fund disbrushment status'
    },
    
    xAxis: [{
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        crosshair: true
    }],
    yAxis: [{ // Primary yAxis
        labels: {
            format: '{value}lakh',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        },
        title: {
            text: 'Amount',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        }
    }, { // Secondary yAxis
        title: {
            text: 'Components',
            style: {
                color: Highcharts.getOptions().colors[0]
            }
        },
        labels: {
            format: '{value}',
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
        layout: 'vertical',
        align: 'left',
        x: 120,
        verticalAlign: 'top',
        y: 100,
        floating: true,
        backgroundColor:
            Highcharts.defaultOptions.legend.backgroundColor || // theme
            'rgba(255,255,255,0.25)'
    },
    series: [{
        name: 'Amount',
        type: 'column',
        yAxis: 1,
        data: [49, 71, 106, 129, 144, 176, 135, 148, 216, 194, 95, 54],
        tooltip: {
            valueSuffix: 'lakh'
        }

    }, {
        name: 'Components',
        type: 'spline',
        data: [7, 6, 9, 14, 18, 21, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
        tooltip: {
            valueSuffix: ''
        }
    }]
});
$("#districtWise_graph_select").change(function(){
				Pension_chartType = $("#districtWise_graph_select option:selected").val();
				if (Pension_chartType == 'monthlyfund') {
					fund_dishbrushment.update({
									        title: {
					        text: 'Monthly fund disbrushment status'
					    },
					    
					    xAxis: [{
					        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
					            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
					        crosshair: true
					    }],
					    yAxis: [{ // Primary yAxis
        labels: {
            format: '{value}lakh',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        },
        title: {
            text: 'Amount',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        }
    }, { // Secondary yAxis
        title: {
            text: 'Components',
            style: {
                color: Highcharts.getOptions().colors[0]
            }
        },
        labels: {
            format: '{value}',
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
        layout: 'vertical',
        align: 'left',
        x: 120,
        verticalAlign: 'top',
        y: 100,
        floating: true,
        backgroundColor:
            Highcharts.defaultOptions.legend.backgroundColor || // theme
            'rgba(255,255,255,0.25)'
    },
    series: [{
        name: 'Amount',
        type: 'column',
        yAxis: 1,
        data: [49, 71, 106, 129, 144, 176, 135, 148, 216, 194, 95, 54],
        tooltip: {
            valueSuffix: 'lakh'
        }

    }, {
        name: 'Components',
        type: 'spline',
        data: [7, 6, 9, 14, 18, 21, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
        tooltip: {
            valueSuffix: ''
        }
    }]

				    });
				
				}
				else if (Pension_chartType == 'quaterlyfund') {
					fund_dishbrushment.update({
				       title: {
					        text: 'Quaterly fund disbrushment status'
					    },
					    
					    xAxis: [{
					        categories: ['quarter-1', 'quarter-2', 'quarter-3', 'quarter-4'],
					        crosshair: true
					    }],
					    yAxis: [{ // Primary yAxis
        labels: {
            format: '{value}lakh',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        },
        title: {
            text: 'Amount',
            style: {
                color: Highcharts.getOptions().colors[1]
            }
        }
    }, { // Secondary yAxis
        title: {
            text: 'Components',
            style: {
                color: Highcharts.getOptions().colors[0]
            }
        },
        labels: {
            format: '{value}',
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
        layout: 'vertical',
        align: 'left',
        x: 120,
        verticalAlign: 'top',
        y: 100,
        floating: true,
        backgroundColor:
            Highcharts.defaultOptions.legend.backgroundColor || // theme
            'rgba(255,255,255,0.25)'
    },
    series: [{
        name: 'Amount',
        type: 'column',
        yAxis: 1,
        data: [49, 71, 106, 129],
        tooltip: {
            valueSuffix: 'lakh'
        }

    }, {
        name: 'Components',
        type: 'spline',
        data: [7, 6, 9, 14],
        tooltip: {
            valueSuffix: ''
        }
    }]
				    });
				}
			});
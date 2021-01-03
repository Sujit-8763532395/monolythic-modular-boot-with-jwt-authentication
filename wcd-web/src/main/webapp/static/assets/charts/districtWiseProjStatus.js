$(function () {
	
	var DistrictWise_scheme = Highcharts.chart('districtWiseProjStatus', {
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
			            text: 'Projects'
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
			        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b><br/>'
			    },

			    "series": [
			        {
			            "name": "Total Projects",
			            "colorByPoint": true,
			            "data": [
			                {
			                    "name": "Anugul",
			                    "y": 4,
			                    "drilldown": "Anugul"
			                },
			                {
			                    "name": "Bargarh",
			                    "y": 45,
			                    "drilldown": "Bargarh"
			                },
			                {
			                    "name": "Bhadrak",
			                    "y": 22,
			                    "drilldown": "Bhadrak"
			                },
			                {
			                    "name": "Balasore",
			                    "y": 42,
			                    "drilldown": "Balasore"
			                },
			                {
			                    "name": "Balangir",
			                    "y": 40,
			                    "drilldown": "Balangir"
			                },
			                {
			                    "name": "Boudh",
			                    "y": 62,
			                    "drilldown": "Boudh"
			                },
			                {
			                    "name": "Cuttack",
			                    "y": 82,
			                    "drilldown": "Cuttack"
			                },
			                {
			                    "name": "Deogar",
			                    "y": 12,
			                    "drilldown": "Deogar"
			                },
			                {
			                    "name": "Dhenkanal",
			                    "y": 36,
			                    "drilldown": "Dhenkanal"
			                },
			                {
			                    "name": "Gajapati",
			                    "y": 18,
			                    "drilldown": "Gajapati"
			                },
			                {
			                    "name": "Ganjam",
			                    "y": 17,
			                    "drilldown": "Ganjam"
			                },
			                {
			                    "name": "Jagatsinghpur",
			                    "y": 14,
			                    "drilldown": "Jagatsinghpur"
			                },
			                {
			                    "name": "Jajpur",
			                    "y": 60,
			                    "drilldown": "Jajpur"
			                },
			                {
			                    "name": "Jharsuguda",
			                    "y": 18,
			                    "drilldown": "Jharsuguda"
			                },
			                {
			                    "name": "Kalahandi",
			                    "y": 34,
			                    "drilldown": "Kalahandi"
			                },
			                {
			                    "name": "Kandhamal",
			                    "y": 48,
			                    "drilldown": "Kandhamal"
			                },
			                {
			                    "name": "KendraPara",
			                    "y": 55,
			                    "drilldown": "KendraPara"
			                },
			                {
			                    "name": "Keonjhar",
			                    "y": 78,
			                    "drilldown": "Keonjhar"
			                },
			                {
			                    "name": "Khurda",
			                    "y": 10,
			                    "drilldown": "Khurda"
			                },
			                {
			                    "name": "Koraput",
			                    "y": 47,
			                    "drilldown": "Koraput"
			                },
			                {
			                    "name": "Malkangiri",
			                    "y": 50,
			                    "drilldown": "Malkangiri"
			                },
			                {
			                    "name": "Mayurbhanj",
			                    "y": 50,
			                    "drilldown": "Mayurbhanj"
			                },
			                {
			                    "name": "Nuapada",
			                    "y": 50,
			                    "drilldown": "Nuapada"
			                },
			                {
			                    "name": "Nabarangpur",
			                    "y": 36,
			                    "drilldown": "Nabarangpur"
			                },
			                   {
			                    "name": "Nayagarh",
			                    "y": 46,
			                    "drilldown": "Nayagarh"
			                },
			                   {
			                    "name": "Puri",
			                    "y": 44,
			                    "drilldown": "Puri"
			                },
			                   {
			                    "name": "Rayagada",
			                    "y": 36,
			                    "drilldown": "Rayagada"
			                },
			                     {
			                    "name": "Sambalpur",
			                    "y": 40,
			                    "drilldown": "Sambalpur"
			                },
			                     {
			                    "name": "Sonepur",
			                    "y": 30,
			                    "drilldown": "Sonepur"
			                },
			                          {
			                    "name": "Sundargarh",
			                    "y": 60,
			                    "drilldown": "Sundargarh"
			                }

			            ]
			        }
			    ],
		    "drilldown": {
			        "series": [
			            {
			                "name": "Total Projects",
			                "id": "Anugul",
			                "data": [["Anugul",5],["Banarpal",3],["Chhendipada",2],["Athamallik",7],["Kishorenagar",3],["Pallahara",3],["Talcher",1],["Kaniha",4]]
			                
			            },
			            {
			                "name": "Total Block Level Beneficiary",
			                "id": "Bargarh",
			                "data": [["Bargarh",5],["Attabira",3],["Barapali",2],["Bheden",5],["Bijepur",3],["Sohela",4],["Jharbandha",1],["Bhatli",8],["Padmapur",4],["Bargarh Sadar",5],["Gaisilet",7],["Melchhamunda",6],["Ambabhona",4],["BurdenP.S.",4]]
			            },
			            {
			                "name": "Latehar",
			                "id": "Latehar",
			                "data": [["MLC",3],["Non MLC",423]]
			            },
			            {
			                "name": "Chatra",
			                "id": "Chatra",
			               	"data": [["MLC",553],["Non MLC",423]]
			            },
			            {
			                "name": "Hazaribagh",
			                "id": "Hazaribagh",
			               	"data": [["MLC",553],["Non MLC",423]]
			            },
			            {
			                "name": "Koderma",
			                "id": "Koderma",
			                "data": [["MLC",553],["Non MLC",423]]
			            }
			        ]
			    }

			});
});
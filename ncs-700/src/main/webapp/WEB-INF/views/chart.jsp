<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {'packages' : [ 'bar', 'corechart' ] });
		google.charts.setOnLoadCallback(drawChart);

		function drawChart() {
			//for Bar
			var data = google.visualization.arrayToDataTable([
					[ '영정이의 일상', 'HAPPY','SAD', 'TIRED' ],
					[ '22.08.19', 0.6, 0.0, 0.8 ], [ '22.08.20', 1, 0.0, 0.3 ],
					[ '22.08.21', 1, 0.0, 0.7 ], [ '22.08.22', 0.5, 0.0, 0.8],
					[ '22.08.23', 0.8, 0.0, 0.2 ] ]);

			var options = {
				chart : {
					title : "영정's Daliy",
					subtitle : '',
				},
				series: {
		               0: {color: '#F65A83'},
		               1: {color: '#607EAA'},
		               2: {color: '#EAE3D2'}
		            }
			};

			var chart = new google.charts.Bar(document.getElementById('barchart-section'));
			chart.draw(data, google.charts.Bar.convertOptions(options));
			
			//for PI
			var data = google.visualization.arrayToDataTable([
		          ['EmotionalState', 'Range'],
		          ['HAPPY',        56],
		          ['TIRED',    18],
		          ['FRUSTRATION',   27.4],
		          ['SAD', 0.6]
		        ]);

		        var options = {
		          title: '평소의 영정이',
		          is3D: false,
		          colors: ['#F65A83', '#EAE3D2', '#AF7AB3', '#607EAA'],
		        };

		        var chart = new google.visualization.PieChart(document.getElementById('piechart-section'));

		        chart.draw(data, options);
		}
	</script>
</head>
<body>
	<div id="barchart-section" style="width: 800px; height: 500px;"></div>
	<div id="piechart-section" style="width: 900px; height: 500px;"></div>
	<div id="barchart-section2" style="width: 800px; height: 500px;"></div>
	<div id="piechart-section2" style="width: 900px; height: 500px;"></div>
</body>
</html>
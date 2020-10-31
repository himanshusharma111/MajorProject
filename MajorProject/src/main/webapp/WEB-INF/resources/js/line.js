$(document).ready(function() {

	//after the doc is ready
	// get canvas

	var ctx = $("#line-chartcanvas");

	// Score of two teams a and b
	// match1 and match2 .....match5
	var data = {

		// This is array 
		labels : ["match1", "match2", "match2", "match2", "match5"],
		
		// This is array and take the value as object
		datasets: [
			// first obj
				{
					label : "TeamA score",
					data : [10, 50, 25, 70, 40], 
					background : "blue", 
					borderColor: "lightblue", 
					fill : false, 
					lineTension : 0,
					pointRadius : 5  
				},
				{
					label : "TeamB score",
					data : [20, 35, 40, 60, 50], 
					background : "green", 
					borderColor: "lightgreen", 
					fill : false, 
					lineTension : 0,
					pointRadius : 5  
				}
		]
	};

	var options = {
		title:{
			display:true, 
			position : "top",
			text : "line Graph", 
			fontSize: 18, 
			fontColor : "#111"

		}, 
		legend : {
			display : true, 
			position : "bottom"
		}
	};

	//constructor Chart two args(ctx and object)
	var chart = new Chart(ctx, {
		type:"line",
		// data - team ab
		data: data,
		// options - for title
		options: options

	}); 


});
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- add pom maven dependency and after add the bellow line for jstl  -->
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChartJS-Line</title>



<!-- adding css using curl for in jsp -->
<link href= "<c:url value="/resources/css/default.css "/>">
 
</head>
<body>
	
	<!-- too add an image   -->
	<!-- <img alt="my image" src="<c:url value="/resources/js" />"> -->
	
	
	<script src="<c:url value="/resources/js/Chart.min.js" />"> </script>
	<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>

	
	<script>
	<%
	// List<String> friendsmatches = (List<String>) request.getAttribute("matches");
	//ArrayList<String> sk = new ArrayList<String>();
	// ArrayList<String> friendsmatches = (ArrayList<String>) request.getAttribute("ma");
	// Set<String> times = (Set<String>) request.getAttribute("sendkeyset");
	ArrayList<String> dates = (ArrayList<String>) request.getAttribute("sendarrayform");
	String getvalSet = (String)request.getAttribute("sendvalueSet");
	// String getkeys = (String)request.getAttribute("SendstrKey");
	%>
	
	$(document).ready(function() {

		//after the doc is ready
		// get canvas

		var ctx = $("#line-chartcanvas");

		// Score of two teams a and b
		// match1 and match2 .....match5
		var data = {

			// This is array 
			// labels : ["match1", "match2", "match2", "match2", "match5"],
			
			
			
			
			//<c:set var="myVal" value="${matches}"/> 
			
		 //	labels : "${myval}",
	
		 <% 
		 for (String s : dates) 
		 {
		 %>
		 
		 labels : <%=dates%>,
		 
		 <%
		 }
		 %>
		
		
				
		 // This is array and take the value as object
			datasets: [
				// first obj
					{
						//label : "TeamA score",
						//data : [10, 50, 25, 70, 40], 
						
						label :  "TeamA score",
						data : <%=getvalSet%>, 
						background : "blue", 
						borderColor: "lightblue", 
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
	
	</script>

	<!-- for creating chart we need to create canvas element <script type="text/javascript" src="js/line.js"></script> -->

	<div class="chart-container">
		<canvas id="line-chartcanvas" height="300px" width="900px"></canvas>
	</div>
	
	



</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2>Purchased Report</h2>
			<small>These are the Customers Purchased on ${date} </small>
		</div>
	</div>
	
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			
		
			<!--  add our html table here -->
		
			<table >
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>City</th>
					<th>Gender</th>
					<th>Date</th>
					<th>Product_name</th>
					<th>Price</th>
					<th>Company</th>
					<th>Category</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProduct" items="${purchased_db}">
				
									
					
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.age} </td>
						<td> ${tempProduct.city} </td>
						<td> ${tempProduct.gender} </td>
						<td> ${tempProduct.date} </td>
						<td> ${tempProduct.product_name} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.company} </td>
						<td> ${tempProduct.category} </td>
						
					</tr>
				
				</c:forEach>
						
			</table><br/>
			
			
		</div>
	
	</div>
	<br/>
	
	
</body>

</html>









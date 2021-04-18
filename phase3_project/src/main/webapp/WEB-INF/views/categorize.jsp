<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		 <script src="<c:url value="/resources/js/h.js"/>"></script>

</head>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>Categorized </h2>
		</div>
	</div>
	
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			
		
			<!--  add our html table here -->
		
			<table id="k">
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Company</th>
					<th>Category</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${products}">
				
									
					
					<tr>
						<td> ${tempUser.name} </td>
						<td> ${tempUser.price} </td>
						<td> ${tempUser.company} </td>
						<td> ${tempUser.category} </td>
						
					</tr>
				
				</c:forEach>
						
			</table><br/>
			
			
		</div>
	
	</div>
	<br/>
	
	

</body>

</html>









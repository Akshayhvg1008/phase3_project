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
			<h2>Products</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Price </th>
					<th>Company</th>
					<th>Category</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProduct" items="${products}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="buy" value="/user/getid">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					

								
					
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.company} </td>
						<td> ${tempProduct.category} </td>
						
						<td>
							<!-- display the update link -->
							<button><a href="${buy}">Buy Product</a></button>
							
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table><br/>
	
		</div>
	
	</div>
	<br/>
	
	
	
	
	

</body>

</html>









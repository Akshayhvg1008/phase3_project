<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
					<c:url var="updateLink" value="/products/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/products/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.company} </td>
						<td> ${tempProduct.category} </td>
						
						<td>
							<!-- display the update link -->
							
							
							<a href="${updateLink}"><button style="font-size:15px">Edit <i class="fa fa-edit"></i></button>
</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this Product?'))) return false"><button style="font-size:15px">Delete <i class="fa fa-trash-o"></i></button>
</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table><br/>
			<div>
			
			<input type="button" value="Add Product"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<br/>
			
			<input type="button" value="List of Users"
				   onclick="window.location.href='getAllUsers'; return false;"
				   class="add-button"
			/>
			<br/>
			<input type="button" value="Change Password"
				   onclick="window.location.href='change-password'; return false;"
				   class="add-button"
			/>
			
				</div>
		</div>
	
	</div>
	<br/>
	
	<div>
	<form action="doCategorize" method="get">
	<div class="col-3">
        	<input class="effect-10" type="text" placeholder="Enter Category" name="category">
            <span class="focus-bg"></span>
        
        
        <input type="submit" value="Categorize"/>
        </div>
	</form>
	</div>
	<br/>
	<div>
	<form action="getByDate" method="get" >
	<div class="col-3">
        	<input class="effect-10" type="text" placeholder="Enter Date" name="date">
            <span class="focus-bg"></span>
       
        
        <input type="submit" value="Generate Report by Date"/> </div>
	</form>
	<small style="color: white;">Please Enter Date format like YY/MM//DD</small>
	</div>
	<br/>
		<div>
	<form action="getByCategory" method="get" >
	<div class="col-3">
        	<input class="effect-10" type="text" placeholder="Enter Category" name="category">
            <span class="focus-bg"></span>
        
       
        
        <input type="submit" value="Generate Report by Category"/></div>
	</form>
	</div>
	
	

</body>

</html>









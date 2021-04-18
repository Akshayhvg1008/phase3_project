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
			<h2>These are the Customers Who Signed on SportyShoes.com </h2>
		</div>
	</div>
	
	<div class="col-md-4">
	
	</div>
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			
		
			<!--  add our html table here -->
			<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
		
<br/><br/>
			<table id="myTable">
			
		
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>City</th>
					<th>Gender</th>
					<th>Phone Number</th>
					<th>Country</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${User}">
				
									
					
					<tr>
						<td> ${tempUser.name} </td>
						<td> ${tempUser.age} </td>
						<td> ${tempUser.city} </td>
						<td> ${tempUser.gender} </td>
						<td> ${tempUser.ph_no} </td>
						<td> ${tempUser.country} </td>
						
					</tr>
				
				</c:forEach>
						
			</table><br/>
			
			
		</div>
	
	</div>
	<br/>
	
	<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
	

</body>

</html>









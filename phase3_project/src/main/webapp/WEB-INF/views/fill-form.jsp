<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Product</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Product</h2>
		</div>
	</div>

	<div id="container">
		<h3>Fill Details</h3>
	
		<form action="addToDb" method="post"> 
	<div align="center" class="center">
  <table>
    <tr>
      <td align="right">Name</td>
      <td align="left"><input type="text" name="name" /></td>
    </tr>
    <tr>
      <td align="right">Age</td>
      <td align="left"><input type="int" name="age" /></td>
    </tr>
    <tr>
      <td align="right">Gender</td>
      <td align="left"><input type="text" name="gender" /></td>
    </tr>
    <tr>
      <td align="right">City</td>
      <td align="left"><input type="text" name="city" /></td>
    </tr>
   
     <tr>
      <td align="right"></td>
      <td align="left"><input type="submit"  value="Submit Details" /></td>
    </tr>
  </table>
  </div>
</form>
		
		

</body>

</html>










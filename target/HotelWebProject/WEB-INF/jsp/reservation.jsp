<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>MyHotel</title>
  <meta name="description" content="My Hotel" />
  <meta name="keywords" content="hotel" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
</head>
<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index">My<span class="logo_colour">Hotel</span></a></h1>
          <h2>make a booking now</h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li><a href="index">Home</a></li>
		  <li class="selected"><a href="reservation">Reservation</a></li>
		  <li><a href="rooms">Rooms</a></li>
          <li><a href="contact">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
        <h2>Get a room for:</h2>
        <h3>${price} Euros</h3>
      </div>
      <div id="content">
        <!-- insert the page content here -->
        
        <div align="left">
        <h2>Reserve a room</h2>
		<form:form action="reservation" method="POST" commandName="reservation">
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="customerName" />&nbsp;&nbsp;<h7><form:errors path="customerName" /></h7></td>
				</tr>
				<tr>
					<td>Surname:</td>
					<td><form:input path="customerSurname" />&nbsp;&nbsp;<h7><form:errors path="customerSurname" /></h7></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="customerEmail" />&nbsp;&nbsp;<h7><form:errors path="customerEmail" /></h7></td>
				</tr>
				<tr>
					<td>Check-In:</td>
					<td><form:input path="checkInDate" placeholder="mm/dd/yyyy" />&nbsp;&nbsp;<h7><form:errors path="checkInDate" /></h7></td>
				</tr>
				<tr>
					<td>Check-Out:</td>
					<td><form:input path="checkOutDate" placeholder="mm/dd/yyyy" />&nbsp;&nbsp;<h7><form:errors path="checkOutDate" /></h7></td>
				</tr>
				<tr>
				    <td>Select Room:</td>
								<td><form:select path="roomType">
										<form:option value="Single">Single</form:option>
										<form:option value="Double">Double</form:option>
										<form:option value="Triple">Triple</form:option>
										<form:option value="Quad">Quad</form:option>
										<form:option value="Queen">Queen</form:option>
										<form:option value="King">King</form:option>
										<form:option value="Double-double">Double-double</form:option>
										<form:option value="Mini-Suite">Mini-Suite</form:option>
										<form:option value="Suite">Suite</form:option>
									</form:select></td>
							</tr>
				<tr>
					<td>Have you stayed at our hotel before?</td>
					<td><form:select path="regularCustomer">
										<form:option value="0">No</form:option>
										<form:option value="1">Yes</form:option>							
						</form:select></td>
					</tr>		
				<tr>
					<td>No return in case of canceling:</td>
					<td><form:checkbox path="noCancel" /></td>
				</tr>
				<tr>
					<td>Half-board:</td>
					<td><form:checkbox path="halfBoard" /></td>
				</tr>
				<tr>
					<td>Use of sports facilities:</td>
					<td><form:checkbox path="sportsFacility" /></td>
				</tr>
				<tr>
					<td>Use of pool facility:</td>
					<td><form:checkbox path="poolFacility" /></td>
				</tr>
				<tr>
					<td>All Inclusive:</td>
					<td><form:checkbox path="allInclusive" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Confirm" /></td>
				</tr>
			</table>
		</form:form>
	</div>
      </div>
    </div>
    <div id="content_footer"></div>      
    <div id="footer">
	  <a href="mailto:konstantinos.gottis@gmail.com">konstantinos.gottis@gmail.com</a>
    </div>
  </div>
</body>
</html>
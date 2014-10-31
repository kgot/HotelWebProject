<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
          <li><a href="reservation">Reservation</a></li>
          <li><a href="rooms">Rooms</a></li>
          <li class="selected"><a href="contact">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <h1>Contact Us</h1>
        <p>Phone: +030...........</p>
        <p>Email: myhotel@hotel.com</p>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      <a href="mailto:konstantinos.gottis@gmail.com">konstantinos.gottis@gmail.com</a>
    </div>
  </div>
</body>
</html>

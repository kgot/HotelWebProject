<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
          <li class="selected"><a href="rooms">Rooms</a></li>
          <li><a href="contact">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <h1>Our Rooms</h1>
        <p>Our hotel provides a variety of rooms:</p>
        <ul>
          <li>Single: A room assigned to one person. May have one or more beds.</li>
          <li>Double: A room assigned to two people. May have one or more beds.</li>
          <li>Triple: A room assigned to three people. May have two or more beds.</li>
          <li>Quad: A room assigned to four people. May have two or more beds.</li>
          <li>Queen: A room with a queen sized bed. May be occupied by one or more people.</li>
          <li>King: A room with a king sized bed. May be occupied by one or more people.</li>
          <li>Double-double: A Room with two double ( or perhaps queen) beds. May be occupied by one or more person.</li>
          <li>Mini-Suite or junior suite: A single room with a bed and sitting area. Sometimes the sleeping area is in a bedroom separate from the parlour or living room.</li>
          <li>Suite: A parlour or living room connected with to one or more bedrooms.</li>
        </ul>
        <h1>Facility Amenities</h1>
        <ul>
          <li>Pool</li>
          <li>Sport Facilities</li>
          <li>Restaurant</li>
        </ul>
      </div>
    </div>
    <div id="content_footer"></div>      
    <div id="footer">
	  <a href="mailto:konstantinos.gottis@gmail.com">konstantinos.gottis@gmail.com</a>
    </div>
  </div>
</body>
</html>



<%@page import="com.sql.web.java.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>

<style type = "text/css">
html, body{
	margin-left:15px; margin-right:15px; 
	padding:0px; 
	font-family:Verdana, Arial, Helvetica, sans-serif;
}

table {   
	border-collapse:collapse;
	border-bottom:1px solid gray;
	font-family: Tahoma,Verdana,Segoe,sans-serif;
	width:72%;
}
 
th {
	border-bottom:1px solid gray;
	background:none repeat scroll 0 0 #0775d3;
	padding:10px;
	color: #FFFFFF;
}

tr {
	border-top:1px solid gray;
	text-align:center;	
}
 
tr:nth-child(even) {background: #FFFFFF}
tr:nth-child(odd) {background: #BBBBBB}	
 
#wrapper {width: 100%; margin-top: 0px; }
#header {width: 72%; background: #0775d3; margin-top: 0px; padding:15px 0px 15px 0px;}
#header h2 {width: 100%; margin:auto; color: #FFFFFF;}
#container {width: 100%; margin:auto}
#container h3 {color: #000;}
#container #content {margin-top: 20px;}

.add-student-button {
	border: 1px solid #666; 
	border-radius: 5px; 
	padding: 4px; 
	font-size: 12px;
	font-weight: bold;
	width: 120px; 
	padding: 5px 10px; 
	
	margin-bottom: 15px;
	background: #cccccc;
}

</style>
<head>
<title>Student Trcaker App</title>



</head>

<%   List<Student> thestudents = (List<Student>) request.getAttribute("STUDENT_LIST");
%>
<body>

<div id ="wrapper">

 <div id ="header">
 <h2> Prince ki University</h2>
 </div>
</div>

<div id = "container">
   <div id ="content">
   <table>
   <tr>
   <th>FirstName</th>
   <th>LastName</th>
   <th>Email</th>
   
   </tr>
   
   <% for(Student tempStudent: thestudents){%>
	   
   <tr>
   <td><%=tempStudent.getFirstname() %></td>
    <td><%=tempStudent.getLastname() %></td>
     <td><%=tempStudent.getEmail() %></td>
   </tr>
   <%} %>
   </table>
   
   
   </div>

</div>
</body>
</html>
<%@page import=
"java.util.List"%>

<%@page import=
"com.drivesmart.model.SessionBean"%>

<!DOCTYPE html>

<html>

<head>

<title>

Schedule

</title>

</head>

<body>

<h2>

Centralized Schedule

</h2>


<table
border="1">

<tr>

<th>ID</th>

<th>Student</th>

<th>Branch</th>

<th>Lesson</th>

<th>Status</th>

</tr>


<%

List<SessionBean>

list=

(List<SessionBean>)

request.getAttribute(

"sessionList"

);


if(
list!=null
){

for(
SessionBean s
:
list
){

%>


<tr>

<td>

<%=s.getSession_id()%>

</td>

<td>

<%=s.getStudent_name()%>

</td>

<td>

<%=s.getBranch_location()%>

</td>

<td>

<%=s.getLesson_type()%>

</td>

<td>

<%=s.getStatus()%>

</td>

</tr>


<%

}

}
%>

</table>

</body>

</html>
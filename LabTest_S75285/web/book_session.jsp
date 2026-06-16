<!DOCTYPE html>
<html>

<head>

<title>
Book Session
</title>

</head>

<body>

<h2>
Driving Session Booking
</h2>

<form
method="POST"
action="BookSessionServlet"
>

Student Name:

<br>

<input
type="text"
name="student_name"
required>

<br><br>

Branch Location:

<br>

<select
name="branch_location"
required>

<option>
Kuala Lumpur
</option>

<option>
Penang
</option>

<option>
Johor
</option>

</select>

<br><br>

Lesson Type:

<br>

<select
name="lesson_type"
required>

<option>
Manual Car
</option>

<option>
Automatic Car
</option>

<option>
Motorcycle
</option>

</select>

<br><br>

<button
type="submit">

Book Session

</button>

</form>

</body>

</html>
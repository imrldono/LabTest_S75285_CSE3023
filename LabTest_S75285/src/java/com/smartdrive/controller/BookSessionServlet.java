package com.smartdrive.controller;

import com.drivesmart.model.SessionBean;
import com.smartdrive.dao.SessionDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookSessionServlet")

public class BookSessionServlet
extends HttpServlet{

@Override

protected void doPost(
HttpServletRequest request,
HttpServletResponse response
)

throws ServletException,
IOException{


String student=
request.getParameter(
"student_name"
);

String branch=
request.getParameter(
"branch_location"
);

String lesson=
request.getParameter(
"lesson_type"
);


SessionBean s=
new SessionBean();

s.setStudent_name(
student
);

s.setBranch_location(
branch
);

s.setLesson_type(
lesson
);

s.setStatus(
"Booked"
);


SessionDAO dao=
new SessionDAO();

dao.bookSession(
s
);


response.sendRedirect(
"ScheduleServlet"
);

}

}
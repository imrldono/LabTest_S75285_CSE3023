package com.smartdrive.controller;

import com.drivesmart.model.SessionBean;
import com.smartdrive.dao.SessionDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

@WebServlet(
"/ScheduleServlet"
)

public class ScheduleServlet
extends HttpServlet{

@Override

protected void doGet(

HttpServletRequest request,

HttpServletResponse response

)

throws ServletException,
IOException{


SessionDAO dao=
new SessionDAO();


List<SessionBean>
list=

dao.getAllSessions();


request.setAttribute(

"sessionList",

list

);


RequestDispatcher rd=

request.getRequestDispatcher(

"schedule.jsp"

);


rd.forward(

request,

response

);

}

}
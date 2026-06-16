package com.smartdrive.dao;

import com.drivesmart.model.SessionBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {

    private String dbURL =
            "jdbc:mysql://localhost:3306/drivesmart_db";

    private String dbUser =
            "root";

    private String dbPass =
            "";



    public Connection getConnection(){

        Connection conn=null;

        try{

            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

            conn=
                    DriverManager.getConnection(
                            dbURL,
                            dbUser,
                            dbPass
                    );

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return conn;

    }



    public boolean bookSession(
            SessionBean session
    ){

        boolean success=false;

        try{

            Connection conn=
                    getConnection();

            String sql=
                    "INSERT INTO Training_Sessions "
                    +
                    "(student_name,"
                    +
                    "branch_location,"
                    +
                    "lesson_type,"
                    +
                    "status)"
                    +
                    " VALUES(?,?,?,?)";

            PreparedStatement ps=
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    session.getStudent_name()
            );

            ps.setString(
                    2,
                    session.getBranch_location()
            );

            ps.setString(
                    3,
                    session.getLesson_type()
            );

            ps.setString(
                    4,
                    session.getStatus()
            );

            int row=
                    ps.executeUpdate();

            success=
                    row>0;

            conn.close();

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return success;

    }



    public List<SessionBean>
    getAllSessions(){

        List<SessionBean>
                list=
                new ArrayList<>();

        try{

            Connection conn=
                    getConnection();

            String sql=
                    "SELECT * "
                    +
                    "FROM Training_Sessions "
                    +
                    "ORDER BY branch_location ASC";

            PreparedStatement ps=
                    conn.prepareStatement(
                            sql
                    );

            ResultSet rs=
                    ps.executeQuery();

            while(
                    rs.next()
            ){

                SessionBean s=
                        new SessionBean();

                s.setSession_id(
                        rs.getInt(
                                "session_id"
                        )
                );

                s.setStudent_name(
                        rs.getString(
                                "student_name"
                        )
                );

                s.setBranch_location(
                        rs.getString(
                                "branch_location"
                        )
                );

                s.setLesson_type(
                        rs.getString(
                                "lesson_type"
                        )
                );

                s.setStatus(
                        rs.getString(
                                "status"
                        )
                );

                list.add(s);

            }

            conn.close();

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }

}
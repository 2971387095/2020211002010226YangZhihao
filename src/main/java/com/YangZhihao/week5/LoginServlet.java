package com.YangZhihao.week5;

import com.YangZhihao.dao.Userdao;
import com.YangZhihao.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement ps = null;
     ResultSet rs = null;
    @Override
    public void init()throws ServletException{
//        super.init();
//        ServletContext context=getServletContext();
//        String driver=context.getInitParameter("driver");
//        String url=context.getInitParameter("url");
//        String username=context.getInitParameter("username");
//        String password=context.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            try {
//                con = DriverManager.getConnection(url, username, password);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        Userdao userdao=new Userdao();
        try {
            User user=userdao.findByUsernamePassword(con,username,password);
            if(user!=null){
                request.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
            request.setAttribute("message","Username or Password error!!!");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        String sql = "Select * from student where username = ? and password = ?";
//        try {
//            try {
//                ps = con.prepareStatement(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                ps.setString(1, username);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                ps.setString(2, password);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                rs = ps.executeQuery();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                ResultSet rs=con.createStatement().executeQuery(sql);
//                if (rs.next()) {
//                    try {
//                        request.setAttribute("id", rs.getLong("id"));
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    request.setAttribute("username", username);
//                    request.setAttribute("password", password);
//                    try {
//                        request.setAttribute("email", rs.getString("email"));
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        request.setAttribute("gender", rs.getString("gender"));
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        request.setAttribute("birthdate", rs.getString("birthdate"));
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    request.getRequestDispatcher("userInfo.jsp").forward(request, response);
//                } else {
//                    request.setAttribute("message", "Username or Password Error!");
//                    request.getRequestDispatcher("login.jsp").forward(request, response);
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } finally {
//            try {
//                if(rs!=null){
//
//                    rs.close();
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(ps!=null){
//
//                    ps.close();
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        }
}
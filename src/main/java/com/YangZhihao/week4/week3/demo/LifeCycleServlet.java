package com.YangZhihao.week4.week3.demo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {
    Connection con=null;
    public LifeCycleServlet() {
        System.out.println("i am constructor-->LifeCycleServlet()");
    }

    @Override
    public void init() {
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection -->"+con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("i am init()->LifeCycleServlet-->"+con);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service() -->do get()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destory(){
        System.out.println("i am in destory()");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

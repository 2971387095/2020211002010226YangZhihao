package com.YangZhihao.week6;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCServletcontextlistener implements ServletContextListener {
    @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {
            ServletContext context = servletContextEvent.getServletContext();
            String driver = context.getInitParameter("driver");
            String url = context.getInitParameter("url");
            String username = context.getInitParameter("username");
            String password = context.getInitParameter("password");
            try {
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url,username,password);
                System.out.println("i am in contextInitialized"+con);
                context.setAttribute("con",con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
@Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {
            System.out.println(" i am in contextDestroyed()");
            servletContextEvent.getServletContext().removeAttribute("con");
        }
    }


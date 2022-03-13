package com.YangZhihao.week3.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet() {
        System.out.println("i am constructor-->LifeCycleServlet()");
    }

    @Override
    public void init() {
        System.out.println("i am init");
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
    }
}

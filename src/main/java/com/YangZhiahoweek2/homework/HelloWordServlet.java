package com.YangZhiahoweek2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws IOException{
            PrintWriter writer= null;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.println("Hello Client!!!");
        }
    public void dopost(HttpServletRequest request,HttpServletResponse response){

    }

}

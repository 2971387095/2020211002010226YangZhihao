package com.YangZhihao.controller;

import com.YangZhihao.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminhomeServlet", value = "/admin/home")
public class AdminhomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("admin".equals(user.getUsername())) {
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request, response);
            } else {
                session.invalidate();
                request.setAttribute("message", "Unauthorized Access admin module!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Please Login as admin!!!");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

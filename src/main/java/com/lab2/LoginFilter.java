package com.lab2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in LoginFilter --> init()");
    }

    public void destroy() {
        System.out.println("I am in LoginFilter --> destroy()");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException, IOException {
        System.out.println("LoginFilter --> request before chain");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession() != null && request.getSession().isNew()){
            request.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath() + "/lab2/login.jsp");
        }
        chain.doFilter(request, response);
        System.out.println(" LoginFilter --> request after chain");

    }
}

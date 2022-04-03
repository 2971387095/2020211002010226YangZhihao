package com.YangZhihao.week4.week3.demo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stmt = null;
    @Override
    public void init() throws ServletException {
        super.init();
//        String driver="com.mysql.cj.jdbc.Driver";
//        String url="jdbc:mysql://localhost:3306/userdb";
//        String username="root";
//        String password="123456";
//        ServletConfig config =getServletConfig();
//       String driver =config.getInitParameter("driver");
//        String url =config.getInitParameter("url");
//        String username =config.getInitParameter("usname");
//        String password =config.getInitParameter("password");
//        ServletContext context = getServletContext();
//        String driver = context.getInitParameter("driver");
//        String url = context.getInitParameter("url");
//        String username = context.getInitParameter("username");
//        String password = context.getInitParameter("password");
//        //now use 4 variables to get connection
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("Connection --> in register " + con);//just print for test
//            //one connection
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con=(Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
    String password=request.getParameter("password");
    String email=request.getParameter("Email");
    String gender=request.getParameter("gender");
    String birthdate=request.getParameter("birthdate");
        String sql="insert into student values(?,?,?,?,?)";
        try {
            //insert data
            PreparedStatement preparedStatement= null;
            try {
                preparedStatement = con.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,birthdate);
            preparedStatement.execute();
            //get data and print data
//            PrintWriter out=response.getWriter();
//            sql="select * from student";
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(sql);
//            out.println("id\t\tusername\t\tpassword\t\temail\t\tgender\t\tbirthdate");
//            out.println("<html><head><title></title></head><table border=1><tr>");
//            out.println("<th>id</th><th>username</th><th>password</th><th>Email</th><th>gender</th><th>birthdate</th></tr>");
//            while (rs.next()) {
//                int ID = rs.getInt("id");
//                String Username = rs.getString("username");
//                String Password = rs.getString("password");
//                String Email = rs.getString("email");
//                String Gender = rs.getString("gender");
//                Date Birthdate = rs.getDate("birthdate");
//                PrintWriter writer = response.getWriter();
//                out.println(ID + "\t\t" + Username + "\t\t" + Password + "\t\t" + Email + "\t\t" + Gender + "\t\t" + Birthdate);
//                out.println("<tr>");
//                out.println("<td>" + rs.getInt("id") + "</td>");
//                out.println("<td>" + rs.getString("username") + "</td>");
//                out.println("<td>" + rs.getString("password") + "</td>");
//                out.println("<td>" + rs.getString("email") + "</td>");
//                out.println("<td>" + rs.getString("gender") + "</td>");
//                out.println("<td>" + rs.getDate("birthdate") + "</td>");
//                out.println("</tr>");
//            }
//            out.println("</table></body></html>");
//            stmt.close();
//            con.close();
            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userlist.jsp").forward(request,response);
            //System.out.println("I am in RegisterServlet-->do post()-->after forward()");
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

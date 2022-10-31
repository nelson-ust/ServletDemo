package com.example.servletdemo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String firstname;
    private String lastname;
    private Long age;
    private String phone;

    public void init() {
        message = "Hello World!";firstname="Nelson";lastname="Attah";age= Long.valueOf(37);phone="+237037176436";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        /*
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<tr></tr>");
        out.println("<td>FirstName</td>");
        out.println("<td>"+ firstname + "</td>");
        out.println("<td>LastName</td>");
        out.println("<td>"+ lastname + "</td>");
        out.println("<td>Age</td>");
        out.println("<td>"+ age + "</td>");
        out.println("<td>Phone</td>");
        out.println("<td>"+ phone + "</td>");

        out.println("</body></html>"); */


        PrintWriter pw = response.getWriter();

        firstname = request.getParameter("FirstName");
        lastname = request.getParameter("LastName");
        age = Long.parseLong(request.getParameter("Age"));
        phone = request.getParameter("Phone");

        userData newUser = new userData();
        newUser.setUserData(firstname, lastname, age, phone);

        pw.println("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset='ISO-8859-1'>"
                + "<title>Servlet Demo</title>"
                + "<link rel='stylesheet' type='text/css'"
                + "href='/newServlet/style.css'>"
                + "</head>"
                + "<body>"
                + "<h2>Well done!</h2>"
                + "<p>Information below from given data.</p>"
                + "<h2>Your Information:</h2>");
        pw.println("<p>FirstName: " + newUser.getFirstName() +
                "</p><p>LastName: " + newUser.getLastName() + "</p><p>Your Age: "
                + newUser.getAge() + "</p><p>Phone Number: " +
                newUser.getPhone());
        pw.println("</body>"
                + "</html>");

    }

    public void destroy() {
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
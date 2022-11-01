package com.example.servletdemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", value = "/userServlet")
public class userServlet extends HttpServlet {
    private String firstname;
    private String lastname;
    private Long age;
    private String phone;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
}

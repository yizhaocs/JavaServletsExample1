package com.yizhao.CookiesHandling;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * https://www.tutorialspoint.com/servlets/servlets-cookies-handling.htm
 * <p>
 * Browser:
 * http://localhost:8080/HelloFormWithCookie?first_name=First&last_name=Cookies
 * http://localhost:8080/ReadCookies
 * http://localhost:8080/HelloFormWithCookie?first_name=Second&last_name=Cookies
 * http://localhost:8080/ReadCookies
 * http://localhost:8080/DeleteCookies
 * http://localhost:8080/ReadCookies
 */
public class HelloFormWithCookie extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Create cookies for first and last names.
        Cookie firstName = new Cookie("first_name",
                request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name",
                request.getParameter("last_name"));

        // Set expiry date after 24 Hrs for both the cookies.
        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);

        // Add both the cookies in the response header.
        response.addCookie(firstName);
        response.addCookie(lastName);

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Setting Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
}

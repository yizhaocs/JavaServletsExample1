package com.yizhao.PageRedirection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * https://www.tutorialspoint.com/servlets/servlets-page-redirect.htm
 * browser:
 * http://localhost:8080/PageRedirect
 */
public class PageRedirect extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // New location to be redirected
        String site = new String("http://www.google.com");

        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}
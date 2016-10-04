package com.yizhao.HttpStatusCodes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * https://www.tutorialspoint.com/servlets/servlets-http-status-codes.htm
 * curl http://localhost:8080/ShowError
 */
// Extend HttpServlet class
public class ShowError extends HttpServlet {

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Set error code and reason.
        response.sendError(407, "Need authentication!!!");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
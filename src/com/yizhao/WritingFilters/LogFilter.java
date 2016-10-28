package com.yizhao.WritingFilters;


// Import required java libraries

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Date;

/**
 * https://www.tutorialspoint.com/servlets/servlets-writing-filters.htm
 * run the tomcat then read from console
 * curl http://localhost:8080/a
 * curl http://localhost:8080/b
 * curl http://localhost:8080/c
 * curl http://localhost:8080/d
 * curl http://localhost:8080/a/a
 * then read console
 */
// Implements Filter class
public class LogFilter implements Filter {
    public void init(FilterConfig config)
            throws ServletException {
        // Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws java.io.IOException, ServletException {

        // Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();

        // Log the IP address and current timestamp.
        System.out.println("Print from Filter: IP " + ipAddress + ", Time "
                + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
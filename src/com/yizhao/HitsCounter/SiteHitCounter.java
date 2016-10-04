package com.yizhao.HitsCounter;

import javax.servlet.*;

/**
 * https://www.tutorialspoint.com/servlets/servlets-hits-counter.htm
 * browser:
 * http://localhost:8080/
 */
public class SiteHitCounter implements Filter{

    private int hitCount;

    public void  init(FilterConfig config)
            throws ServletException {
        // Reset hit counter.
        hitCount = 0;
    }

    public void  doFilter(ServletRequest request,
                          ServletResponse response,
                          FilterChain chain)
            throws java.io.IOException, ServletException {

        // increase counter by one
        hitCount++;

        // Print the counter.
        System.out.println("Site visits count :"+ hitCount );

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }
    public void destroy()
    {
        // This is optional step but if you like you
        // can write hitCount value in your database.
    }
}
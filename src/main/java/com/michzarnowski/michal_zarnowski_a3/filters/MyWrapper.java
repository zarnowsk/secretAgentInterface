package com.michzarnowski.michal_zarnowski_a3.filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Wrapper class which intercepts Servlet Response object to be processed by
 * the CensorFilter.java
 * @author Michal Zarnowski
 * @author Paul Bonenfant (code inspiration)
 */
public class MyWrapper extends HttpServletResponseWrapper {
    
    CharArrayWriter caw = new CharArrayWriter();
    PrintWriter writer = new PrintWriter(caw);

    public MyWrapper(HttpServletResponse response) {
        super(response);
    }
    
    @Override
    public PrintWriter getWriter() throws IOException {
        return writer;
    }
    
    @Override
    public String toString() {
        return caw.toString();
    }

}

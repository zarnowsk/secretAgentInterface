package com.michzarnowski.michal_zarnowski_a3.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter class which acquires a list of words to be censored (transformed into
 * "****") from the context parameter and censors the response object being
 * returned back to the user.
 * @author Michal Zarnowski
 * @author Paul Bonenfant (code inspiration)
 */
public class CensorFilter implements Filter {
    
    FilterConfig fiterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fiterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     
        //Create a wrapper to send to JSP
        MyWrapper myWrapper = new MyWrapper((HttpServletResponse)response);
        
        //Wait for JSP to finish its work
        chain.doFilter(request, myWrapper);
        
        //Get JSP's html text written to response
        String jspText = myWrapper.toString();
        
        //Get filter words from context parameters
        ServletContext context = request.getServletContext();
        String rawWords = context.getInitParameter("filterWords");
        String[] filterWords = rawWords.split(":");
        
        //Censor required words
        String newOutput = censorWords(jspText, filterWords);
        
        //Send output back to the stream
        PrintWriter out = response.getWriter();
        out.print(newOutput);
    }
    
    /**
     * Method transforms the words in input String responseText into "*" based
     * on the array of Strings filterWords
     * @param responseText String to be censored
     * @param filterWords filter Strings to transform into "*"
     * @return censored text
     */
    public String censorWords(String responseText, String[] filterWords) {
        
        //Check if input String contains any of the words which need censoring
        for(String filterWord : filterWords) {
            if (responseText.contains(filterWord)) {
                                
                //Get length of filtered word
                int filterLength = filterWord.length();
                
                //Build censored word
                String censoredWord = "";
                for (int i = 0; i < filterLength; i++) {
                    censoredWord += "*";
                }
                
                //Replace uncensored word with its censored version
                responseText = responseText.replace(filterWord, censoredWord);
            }
        }
        
        return responseText;
    }

    @Override
    public void destroy() {
        
    }

}

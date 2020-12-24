package kz.edu.nu.cs.exercise;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@WebServlet(urlPatterns = { "/myservlet" })
public class MyServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }
    
    static ArrayList<String> records = new ArrayList<String>();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	
    	Date date = new Date( session.getLastAccessedTime() );
    		
    	records.add( "\nRequest made: " + date );
    	records.add( request.getRemoteHost() );
    	records.add( request.getContextPath() ); 
    	
    	response.getWriter().append( records.toString() );   	
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}

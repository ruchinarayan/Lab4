package todoservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoExeServlet
 */
@WebServlet("/TodoExeServlet")
public class TodoExeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<String, String> todoMessageHashMap;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoExeServlet() {
        super();
        // TODO Auto-generated constructor stub
        todoMessageHashMap = new ConcurrentHashMap<String, String>();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	String title = "TODO Operation";
    String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String opr = request.getParameter("opr");
		

		if(opr.contentEquals("display"))
		{
			out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h2>Message with Id "+id+" is: "+todoMessageHashMap.get(id)+"</h2>"+
	                "</body></html>");
		}
		else if(opr.contentEquals("delete"))
		{
			todoMessageHashMap.remove(id);
			out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h2>Message with Id: "+id+" has been deleted!!"+
					"</body></html>");
		}
		else if(opr.contentEquals("All"))
		{
			out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h2>List of All Todo Messages:</h2>");
	                
		for (String key : todoMessageHashMap.keySet()) {
			out.println("<h2>Id: "+key+", TODO Message: "+todoMessageHashMap.get(key)+"</h2>");
		}
		out.println("</body></html>");
		}
		else
		{
			out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h2>Please enter correct value!!</h2>"+
	                "</body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String message = request.getParameter("message");
		todoMessageHashMap.put(id,message);
	
			out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h2>POST [id] [todo message]</h2>\n" +
	                "  <h2><b>Id: </b> "
	                + id + "</h2>\n" +
	                "  <h2>ToDO Message: </b>"
	                + message + "</h2>\n" +
	                "<h1>Saved !!</h1>\n" +
	                "</body></html>");
			
		/*
		out.println("<h2>List of All TODO Messages: </h2>");
		
		for (String key : todoMessageHashMap.keySet()) {
		    out.println("<h2>Id: "+key+", TODO Message: "+todoMessageHashMap.get(key)+"</h2>");
		}
		*/
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		todoMessageHashMap.remove(id);
		out.println("Message with "+id+" has been deleted !");
	}

}

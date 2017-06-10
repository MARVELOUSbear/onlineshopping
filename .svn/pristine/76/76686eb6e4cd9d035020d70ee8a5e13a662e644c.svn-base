import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfirmOrder extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ConfirmOrder() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		try{
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");	
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String dbUser="root";
			String dbPwd="123456";
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			String listId=(String)request.getSession().getAttribute("loginid");
			String Id=(String)request.getParameter("hidden");
			out.print(listId);
			out.println(Id);
		}catch(Exception e){}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		*/
		
		try{
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");	
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String dbUser="root";
			String dbPwd="123456";
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			String listId=(String)request.getSession().getAttribute("loginid");
			String Id=(String)request.getParameter("hidden");
			Statement stctc = con.createStatement();
			stctc.executeUpdate("DELETE FROM orderlist_"+listId+" WHERE Id = "+Id);
			request.getRequestDispatcher("/order-list.jsp").forward(request,response);
		}catch(Exception e){}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

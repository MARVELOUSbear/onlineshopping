import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreateAddress extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CreateAddress() {
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
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		String Title=request.getParameter("addresstitle");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
		String dbUser="root";
		String dbPwd="123456";
		con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		String Email=(String)request.getSession().getAttribute("loginemail");
		PreparedStatement psid = con.prepareStatement("select * from user where Email='"+Email+"'");
		ResultSet rsid = psid.executeQuery();
		rsid.next();
		String Id = rsid.getString(1);
		out.print(Id);
		}catch(Exception e){}
		
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		*/
		
		try{
			Connection con=null;
			ResultSet rs=null;
			PreparedStatement ps=null;
			Class.forName("com.mysql.jdbc.Driver");	
			String Name=request.getParameter("addressname");
			String Company=request.getParameter("addresscompany");
			String Address=request.getParameter("address");
			String City=request.getParameter("addresscity");
			String State=request.getParameter("addressstate");
			String PostalCode=request.getParameter("addresspostal");
			String AddressAdditional=request.getParameter("addressadditional");
			String Mobile=request.getParameter("aaddressmobile");
			String Title=request.getParameter("addresstitle");
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String dbUser="root";
			String dbPwd="123456";
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			String Email=(String)request.getSession().getAttribute("loginemail");
			PreparedStatement psid = con.prepareStatement("SELECT * FROM user WHERE Email='"+Email+"'");
			ResultSet rsid = psid.executeQuery();
			rsid.next();
			String Id = rsid.getString(1);
			PreparedStatement psal=con.prepareStatement("SELECT * FROM address_"+Id+" WHERE Title='"+Title+"'");
			ResultSet rsal= psal.executeQuery();
			
			//ÅÐ¶Ïresult setÊÇ·ñÎª¿Õ
			if(rsal.next())
			{
				request.getRequestDispatcher("/error-page - registered.html").forward(request,response);
			}
			else
			{
				Statement stca = con.createStatement();
				stca.executeUpdate("INSERT INTO address_"+Id+" (Name,Company,Address,City,State,PostalCode,AdditionalInformation,MobilePhone,Title) VALUES('"+Name+"','"+Company+"','"+Address+"','"+City+"','"+State+"','"+PostalCode+"','"+AddressAdditional+"','"+Mobile+"','"+Title+"')");//insert the record
				request.getRequestDispatcher("/account.html").forward(request,response);
			}
			if(rsal!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				rs=null;
			}
			if(psal!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				ps=null;
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				con=null;
			}
		}catch(Exception e){
		}
		
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

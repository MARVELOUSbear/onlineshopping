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



public class CreateAccount extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CreateAccount() {
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
		try{
			Connection con=null;
			ResultSet rs=null;
			PreparedStatement ps=null;
			Class.forName("com.mysql.jdbc.Driver");	
			String Name=request.getParameter("username");
			String Email=request.getParameter("useremail");
			String Password=request.getParameter("userpassword");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String dbUser="root";
			String dbPwd="123456";
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			ps=con.prepareStatement("SELECT * FROM user WHERE Email='"+Email+"'");
			rs = ps.executeQuery();
			//ÅÐ¶Ïresult setÊÇ·ñÎª¿Õ
			if(rs.next())
			{
				request.getRequestDispatcher("/error-page - registered.html").forward(request,response);
			}
			else
			{
				Statement stca = con.createStatement();
				stca.executeUpdate("INSERT INTO user (Name,Email,Password) VALUES('"+Name+"','"+Email+"','"+Password+"')");//insert the record
				PreparedStatement pss=con.prepareStatement("SELECT * FROM user WHERE Email='"+Email+"'");//select the new record and get its id
				ResultSet rss = pss.executeQuery();
				rss.first();
				String Id=rss.getString(1);
				
				Statement stctc = con.createStatement();//create table cart
				stctc.executeUpdate("CREATE TABLE cart_"+Id+" (Id int auto_increment primary key,Name varchar(255),Size char(3),Number int,Color varchar(255),Price double,Image varchar(255),Url varchar(255))");
				Statement stctw = con.createStatement();//create table wishlist
				stctw.executeUpdate("CREATE TABLE wishlist_"+Id+" (Id int auto_increment primary key,Name varchar(255),Size char(3),Price double,Image varchar(255),Url varchar(255))");
				Statement stcta = con.createStatement();//create table address
				stcta.executeUpdate("CREATE TABLE address_"+Id+" (Id int auto_increment primary key,Title varchar(255),Name varchar(255),Company varchar(255),Address varchar(255),City varchar(255),State varchar(255),PostalCode char(6),AdditionalInformation varchar(255),MobilePhone char(11))");
				Statement stcto = con.createStatement();//create table order
				stcto.executeUpdate("CREATE TABLE orderlist_"+Id+" (Id int auto_increment primary key,OrderId varchar(255),OrderDate date,ItemNumber int,Price double,AddressTitle varchar(255))");
				HttpSession session = request.getSession();
				session.setAttribute("loginemail", Email); 
				session.setAttribute("loginpassword", Password);
				request.getRequestDispatcher("/account.html").forward(request,response);
				
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				rs=null;
			}
			if(ps!=null){
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

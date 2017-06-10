import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangeAccount extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChangeAccount() {
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
		String currentEmail=(String)request.getSession().getAttribute("loginemail");
		String currentPassword=(String)request.getSession().getAttribute("loginpassword");
		try{
			Connection con=null;
			ResultSet rs=null;
			PreparedStatement ps=null;
			Class.forName("com.mysql.jdbc.Driver");	
			String Name=request.getParameter("changename");
			String Email=request.getParameter("changeemail");
			String Day=request.getParameter("changebirthday");
			String Month=request.getParameter("changebirthmonth");
			String Year=request.getParameter("changebirthyear");
			String date=Year+"-"+Month+"-"+Day;
			String newPassword=request.getParameter("changepassword");
			String newPasswordConfirm=request.getParameter("changepasswordconfirm");
			String changeNewsLetter=request.getParameter("changenewsletter");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String dbUser="root";
			String dbPwd="123456";
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			PreparedStatement pss=con.prepareStatement("SELECT * FROM user WHERE Email='"+currentEmail+"'");//select the new record and get its id
			ResultSet rss = pss.executeQuery();
			rss.first();
			String currentName=rss.getString(2);
			String currentDate=rss.getString(4);
			if(currentDate==null)
				out.println(currentDate);
		}catch(Exception e){}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		*/
		
		
		String currentEmail=(String)request.getSession().getAttribute("loginemail");
		String currentPassword=(String)request.getSession().getAttribute("loginpassword");
		
		try{
			Connection con=null;
			ResultSet rs=null;
			PreparedStatement ps=null;
			Class.forName("com.mysql.jdbc.Driver");	
			String Name=request.getParameter("changename");
			String Email=request.getParameter("changeemail");
			String Day=request.getParameter("changebirthday");
			String Month=request.getParameter("changebirthmonth");
			String Year=request.getParameter("changebirthyear");
			String date=Year+"-"+Month+"-"+Day;
			String newPassword=request.getParameter("changepassword");
			String newPasswordConfirm=request.getParameter("changepasswordconfirm");
			String changeNewsLetter=request.getParameter("changenewsletter");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String dbUser="root";
			String dbPwd="123456";
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			ps=con.prepareStatement("SELECT * FROM user WHERE Email='"+Email+"'");
			rs = ps.executeQuery();
			//ÅÐ¶Ïresult setÊÇ·ñÎª¿Õ
			if(rs.next()&&(!Email.equals(currentEmail)))
			{
				request.getRequestDispatcher("/error-page - registered.html").forward(request,response);
			}
			else
			{
				PreparedStatement pss=con.prepareStatement("SELECT * FROM user WHERE Email='"+currentEmail+"'");//select the new record and get its id
				ResultSet rss = pss.executeQuery();
				rss.first();
				String currentName=rss.getString(2);
				String currentDate=rss.getString(4);
				String currentNewsLetter=rss.getString(6);
				if(newPassword.equals(newPasswordConfirm))
				{	
					if(!currentName.equals(Name)){
						Statement stcn = con.createStatement();
						stcn.executeUpdate("UPDATE user SET Name='"+Name+"' WHERE Email = '"+currentEmail+"'");
					}
					if(((!(currentDate==null))&&(!currentDate.equals(date)))||(currentDate==null)){
						Statement stcd = con.createStatement();
						stcd.executeUpdate("UPDATE user SET DateOfBirth='"+date+"' WHERE Email = '"+currentEmail+"'");
					}
					if(!currentPassword.equals(newPassword)){
						Statement stcp = con.createStatement();
						stcp.executeUpdate("UPDATE user SET Password='"+newPassword+"' WHERE Email = '"+currentEmail+"'");
					}
					if(((!(currentNewsLetter==null))&&(!currentNewsLetter.equals(changeNewsLetter)))||(currentNewsLetter==null)){
						Statement stcc = con.createStatement();
						stcc.executeUpdate("UPDATE user SET SignNewsLetter="+changeNewsLetter+" WHERE Email = '"+currentEmail+"'");
					}
					if(!currentEmail.equals(Email)){
						Statement stce = con.createStatement();
						stce.executeUpdate("UPDATE user SET Email='"+Email+"' WHERE Email = '"+currentEmail+"'");
					}
					request.getRequestDispatcher("/account.html").forward(request,response);
				}
				else
				{
					request.getRequestDispatcher("login.html").forward(request,response);
				}
				
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

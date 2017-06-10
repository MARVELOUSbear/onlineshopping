import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//�����û��ύ���û���������
		String email=request.getParameter("loginemail");
		String password=request.getParameter("loginpassword");

		Connection con=null;
		//Statement stmt;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
			  
			//����������������Ĵ������MySQL��������
			Class.forName("com.mysql.jdbc.Driver");
			//ע��MySQL��������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//���ʵ��������������ӵ����ݿ�
			String dbUrl =  "jdbc:mysql://localhost:3306/onlineshopping?useUnicode=true&characterEncoding=utf8";
			String dbUser="root";
			String dbPwd="123456";
			//�������ݿ�����
			con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			//����һ��SQL����
			//stmt = con.createStatement();
			  
			ps=con.prepareStatement("select * from user where Email='"+email+"' and password='"+password+"'");
			//��ѯ��¼
			rs = ps.executeQuery();
			
			if(rs.next()){//valid
				HttpSession session = request.getSession(); 
				session.setAttribute("loginemail", email); 
				session.setAttribute("loginpassword", password);
				request.getRequestDispatcher("/account.html").forward(request,response);			
			}else{
				request.getRequestDispatcher("/error-page-login.html").forward(request,response);
			}
			}catch(Exception e){
				out.println(e.getMessage());
			}finally{
				//�ر���Դ
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

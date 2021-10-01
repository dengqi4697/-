package com.cusm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cusm.bean.User;
import com.cusm.common.Constant;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String loginName = request.getParameter("username");
		String loginPass = request.getParameter("password");
		
		if((Constant.LOGIN_NORMAL_USERNAME.equals(loginName) && Constant.LOGIN_NORMAL_PASSWORD.equals(loginPass))||(Constant.LOGIN_ADMIN_USERNAME.equals(loginName) && Constant.LOGIN_ADMIN_PASSWORD.equals(loginPass))){
			User user = new User();
			user.setUserName(loginName);
			user.setUserPass(loginPass);
			HttpSession session = request.getSession();
			session.setAttribute(Constant.LOGIN_USER_ATTR, user);
			/*if(Constant.LOGIN_NORMAL_USERNAME.equals(loginName)){
				response.sendRedirect("http://"+Constant.WEB_SERVER_IP+":"+Constant.WEB_SERVER_PORT+"/CustomerManage/login.html");
				response.sendRedirect("http://"+Constant.WEB_SERVER_IP+":"+Constant.WEB_SERVER_PORT+"/CustomerManage/customerinfo_list.html");
				//request.getRequestDispatcher("http://"+Constant.WEB_SERVER_IP+":"+Constant.WEB_SERVER_PORT+"/CustomerManage/customerinfo_list.html").forward(request, response);
			}else{
				request.getRequestDispatcher("http://"+Constant.WEB_SERVER_IP+":"+Constant.WEB_SERVER_PORT+"/CustomerManage/customer_list_opt.html").forward(request, response);
			}*/
			
			//response.sendRedirect("http://"+Constant.WEB_SERVER_IP+":"+Constant.WEB_SERVER_PORT+"/CustomerManage/login.html");
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);
		}
        
	}

}

package com.cusm.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiterImpl implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
	    HttpServletRequest httpServletRequest = (HttpServletRequest)request;    
	    HttpServletResponse httpServletResponse = (HttpServletResponse)response; 
	    
	    /*if( httpServletRequest.getSession().getAttribute(Constant.LOGIN_USER_ATTR) == null){
	    	httpServletResponse.sendRedirect("login.html");
	    }*/
		if(httpServletRequest.getSession().getAttribute(Constant.LOGIN_USER_ATTR) != null
		   || httpServletRequest.getRequestURI().contains("ServletRegister") ||	httpServletRequest.getRequestURI().contains("login.html")){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else{
			httpServletResponse.sendRedirect("http://"+Constant.WEB_SERVER_IP+":"+Constant.WEB_SERVER_PORT+"/CustomerManage/login.html");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}

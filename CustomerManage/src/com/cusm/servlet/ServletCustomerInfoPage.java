package com.cusm.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.cusm.bean.CustomerInfo;
import com.cusm.dao.CustomerInfoDao;



/**
 * Servlet implementation class ServletRegister
 */
public class ServletCustomerInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ServletCustomerInfoPage.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCustomerInfoPage() {
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
		request.setCharacterEncoding("utf-8");
		String areaName = request.getParameter("areaname").trim();
		String startTime = request.getParameter("starttime").trim();
		String endTime = request.getParameter("endtime").trim();
		int offset = Integer.parseInt(request.getParameter("offset"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		CustomerInfoDao customerInfoDao = new CustomerInfoDao();
		List<CustomerInfo> customerInfoPage = customerInfoDao.queryCustomerInfoPage(areaName,startTime,endTime,offset,limit);
		
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setCharacterEncoding("utf-8");
		
		int total = customerInfoDao.queryCustomerInfoTotal(areaName, startTime, endTime);

         Map<String,Object> map = new HashMap<String, Object>();
         map.put("rows", customerInfoPage);
         map.put("total", total);
              
		response.getWriter().print(JSON.toJSONString(map));
		
	}
  
}

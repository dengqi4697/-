package com.cusm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cusm.bean.CustomerInfo;
import com.cusm.common.Constant;
import com.cusm.dao.CustomerInfoDao;
import com.cusm.utils.CommonUtil;



/**
 * Servlet implementation class ServletRegister
 */
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ServletRegister.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegister() {
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
		String result = "";
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String areaId= request.getParameter("areaid");
		String areaName = request.getParameter("areaname");
		
				
		CustomerInfo customerInfo = new CustomerInfo();
		CustomerInfoDao customerInfoDao = new CustomerInfoDao();
		
		customerInfo.setName(name.trim());
		customerInfo.setTelephone(telephone.trim());
		customerInfo.setAddress(address.trim());
		customerInfo.setAreaId(areaId.trim());
		customerInfo.setAreaName(areaName.trim());
		customerInfo.setCreateTime(System.currentTimeMillis()/1000*1000);
		customerInfo.setUpdateTime(System.currentTimeMillis()/1000*1000);
		customerInfo.setFlag("1");
		
		List<CustomerInfo> customerInfoList = customerInfoDao.queryCustomerInfoList(name, telephone, address, areaId, areaName);
		
		if(customerInfoList.size() > 0){
			long oldCreateTime = customerInfoList.get(0).getCreateTime();
			String oldYMDStr = CommonUtil.fomatDateLongToStr(oldCreateTime, "yyyy-MM-dd");
			String currentYMDStr = CommonUtil.fomatDateLongToStr(System.currentTimeMillis()/1000*1000, "yyyy-MM-dd");
		    if(oldYMDStr.equals(currentYMDStr)){
		    	result = Constant.REGISTER_SUCCESS_REPEAT_SAMEDAY;
		    }else{
		    	boolean flag = customerInfoDao.insertCustomerInfo(customerInfo);
				if(flag)
				{
					result = Constant.REGISTER_SUCCESS_REPEAT_DIFFDAY;
				}else{
					//失败记录日志 日志目录在log4j.properties的文件 log4j.appender.errorlog.File后面配置
					logger.error("insert fail[name="+name+";telephone="+telephone+";address="+address+";areaId="+areaId+";areaName="+areaName+";createTime="+customerInfo.getCreateTime()+"]");
					result = Constant.REGISTER_FAIL_REPEAT_DIFFDAY;
				}
		    }
		}else{
			
			boolean flag = customerInfoDao.insertCustomerInfo(customerInfo);
			if(flag)
			{
				result = Constant.REGISTER_SUCCESS_NO_REPEAT;
			}else{
				//失败记录日志 日志目录在log4j.properties的文件 log4j.appender.errorlog.File后面配置
				logger.error("insert fail[name="+name+";telephone="+telephone+";address="+address+";areaId="+areaId+";areaName="+areaName+";createTime="+customerInfo.getCreateTime()+"]");
				result = Constant.REGISTER_FAIL_NO_REPEAT;
			}
			
		}
				
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.getWriter().print(result);
		
	}

}

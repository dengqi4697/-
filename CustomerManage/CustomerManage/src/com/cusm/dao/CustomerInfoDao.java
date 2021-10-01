package com.cusm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cusm.bean.CustomerInfo;
import com.cusm.common.Constant;
import com.cusm.db.MYSQLDBmanger;
import com.cusm.utils.CommonUtil;

public class CustomerInfoDao{
	
	
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;

	public boolean insertCustomerInfo(CustomerInfo customerInfo) {
		  boolean flag = false;
		  String name = customerInfo.getName();
		  String telephone = customerInfo.getTelephone();
		  String address = customerInfo.getAddress();
		  String areaId = customerInfo.getAreaId();
		  String areaName = customerInfo.getAreaName();
		  long createTime = customerInfo.getCreateTime();
		  
		  long updateTime = customerInfo.getUpdateTime();
		  String custflag = customerInfo.getFlag();
		  
		  conn=MYSQLDBmanger.getConnection();
		  String sql="insert into customerinfo (name, telephone, createtime, updatetime, address, areaid, areaname,flag) values(?,?,?,?,?,?,?,?)";
		  
		    try {
		    	ptst=conn.prepareStatement(sql);
		    	
		    	ptst.setString(1,name);
		    	ptst.setString(2,telephone);
		    	ptst.setLong(3,createTime);
		    	ptst.setLong(4,updateTime);
		    	ptst.setString(5,address);
		    	ptst.setString(6,areaId);
		    	ptst.setString(7,areaName);
		    	ptst.setString(8,custflag);
		        
				
				
				int num=ptst.executeUpdate();
				
				
				flag = num > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				MYSQLDBmanger.closeAll(conn, ptst, null);
			}
			
			return flag;
	}
	
	public List<CustomerInfo> queryCustomerInfoList(String areaName, String startTime, String endTime) {
		
		List<CustomerInfo> customerInfoList = new ArrayList<CustomerInfo>();
		conn = MYSQLDBmanger.getConnection();
		
		String sql = "select name,telephone,address,createtime,updatetime,areaid,areaname from customerinfo ";
		String conditionSql = "";
		
		if((!(areaName == "" || areaName == null))){
			conditionSql = "areaname like '%"+areaName+"%' ";
		}
		
		if((!(startTime == "" || startTime == null))){
			long startTimeLong = CommonUtil.fomatDateStrToLong(startTime, "yyyy-MM-dd HH:mm:ss");
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and createtime >= " + startTimeLong + " ";
			}else{
				conditionSql += "createtime >= " + startTimeLong + " ";
			}
			
		}
		
		if((!(endTime == "" || endTime == null))){
			long endTimeLong = CommonUtil.fomatDateStrToLong(endTime, "yyyy-MM-dd HH:mm:ss");
			
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and createtime <= " + endTimeLong + " ";
			}else{
				conditionSql += "createtime <= " + endTimeLong + " ";
			}
		}
		
		if(!(conditionSql == "" || conditionSql == null)){
			sql += " where " + conditionSql + " order by createtime desc";
		}else{
			sql += " order by createtime desc";
		}
		
		try {
				ptst=conn.prepareStatement(sql);
	            rs = ptst.executeQuery();
			
	            CustomerInfo customerInfo=null;
				while (rs.next()) {
					customerInfo=new CustomerInfo();
					customerInfo.setName(rs.getString(1));
					customerInfo.setTelephone(rs.getString(2));
					customerInfo.setAddress(rs.getString(3));
					
					customerInfo.setCreateTime(rs.getLong(4));
					customerInfo.setCreateTimeStr(CommonUtil.fomatDateLongToStr(rs.getLong(4),"yyyy-MM-dd HH:mm:ss"));
					customerInfo.setAreaId(rs.getString(6));
					customerInfo.setAreaName(rs.getString(7));
					
					customerInfoList.add(customerInfo);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				MYSQLDBmanger.closeAll(conn, ptst, rs);
			}
		return	customerInfoList;
		
	}
	
	public List<CustomerInfo> queryCustomerInfoList(String name, String telephone, String address,String areaId,String areaName) {
		
		List<CustomerInfo> customerInfoList = new ArrayList<CustomerInfo>();
		conn = MYSQLDBmanger.getConnection();
		
		String sql = "select name,telephone,address,createtime,updatetime,areaid,areaname from customerinfo ";
		String conditionSql = "";
		
		if((!(name == "" || name == null))){
			conditionSql = "name = '"+name+"' ";
		}
		
		if((!(telephone == "" || telephone == null))){
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and telephone = '"+telephone+"' ";
			}else{
				conditionSql += "telephone = '"+telephone+"' ";
			}
		}
		
		if((!(address == "" || address == null))){
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and address = '"+address+"' ";
			}else{
				conditionSql += "address = '"+address+"' ";
			}
		}
		
		if((!(areaId == "" || areaId == null))){
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and areaid = '"+areaId+"' ";
			}else{
				conditionSql += "areaid = '"+areaId+"' ";
			}
		}
		
		if((!(areaName == "" || areaName == null))){
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and areaname = '"+areaName+"' ";
			}else{
				conditionSql += "areaname = '"+areaName+"' ";
			}
		}
		
		if(!(conditionSql == "" || conditionSql == null)){
			sql += " where " + conditionSql + " order by createtime desc";
		}else{
			sql += " order by createtime desc";
		}
		
		try {
				ptst=conn.prepareStatement(sql);
	            rs = ptst.executeQuery();
			
	            CustomerInfo customerInfo=null;
				while (rs.next()) {
					customerInfo=new CustomerInfo();
					customerInfo.setName(rs.getString(1));
					customerInfo.setTelephone(rs.getString(2));
					customerInfo.setAddress(rs.getString(3));
					
					customerInfo.setCreateTime(rs.getLong(4));
					customerInfo.setCreateTimeStr(CommonUtil.fomatDateLongToStr(rs.getLong(4),"yyyy-MM-dd HH:mm:ss"));
					customerInfo.setAreaId(rs.getString(6));
					customerInfo.setAreaName(rs.getString(7));
					
					customerInfoList.add(customerInfo);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				MYSQLDBmanger.closeAll(conn, ptst, rs);
			}
		return	customerInfoList;
		
	}
	
	
public List<CustomerInfo> queryCustomerInfoPage(String areaName, String startTime, String endTime, int offset, int limit) {
		
	    System.out.println(Constant.LOGIN_NORMAL_USERNAME);
		List<CustomerInfo> customerInfoList = new ArrayList<CustomerInfo>();
		conn = MYSQLDBmanger.getConnection();
		
		String sql = "select name,telephone,address,createtime,updatetime,areaid,areaname from customerinfo ";
		String conditionSql = "";
		String limitSql = " limit " + offset + "," + limit;
		
		if((!(areaName == "" || areaName == null))){
			conditionSql = "areaname like '%"+areaName+"%' ";
		}
		
		if((!(startTime == "" || startTime == null))){
			long startTimeLong = CommonUtil.fomatDateStrToLong(startTime, "yyyy-MM-dd HH:mm:ss");
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and createtime >= " + startTimeLong + " ";
			}else{
				conditionSql += "createtime >= " + startTimeLong + " ";
			}
			
		}
		
		if((!(endTime == "" || endTime == null))){
			long endTimeLong = CommonUtil.fomatDateStrToLong(endTime, "yyyy-MM-dd HH:mm:ss");
			
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and createtime <= " + endTimeLong + " ";
			}else{
				conditionSql += "createtime <= " + endTimeLong + " ";
			}
		}
		
		if(!(conditionSql == "" || conditionSql == null)){
			sql += " where " + conditionSql + " order by createtime desc " + limitSql;
		}else{
			sql += " order by createtime desc " + limitSql;
		}
		
		try {
				ptst=conn.prepareStatement(sql);
	            rs = ptst.executeQuery();
			
	            CustomerInfo customerInfo=null;
				while (rs.next()) {
					customerInfo=new CustomerInfo();
					customerInfo.setName(rs.getString(1));
					customerInfo.setTelephone(rs.getString(2));
					customerInfo.setAddress(rs.getString(3));
					customerInfo.setCreateTime(rs.getLong(4));
					customerInfo.setCreateTimeStr(CommonUtil.fomatDateLongToStr(rs.getLong(4),"yyyy-MM-dd HH:mm:ss"));
					customerInfo.setAreaId(rs.getString(6));
					customerInfo.setAreaName(rs.getString(7));
					customerInfoList.add(customerInfo);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				MYSQLDBmanger.closeAll(conn, ptst, rs);
			}
		return	customerInfoList;
		
	}


	public int queryCustomerInfoTotal(String areaName, String startTime, String endTime) {
		int count = 0;
		conn = MYSQLDBmanger.getConnection();

		String sql = "select count(*) from customerinfo ";
		String conditionSql = "";
		
		if((!(areaName == "" || areaName == null))){
			conditionSql = "areaname like '%"+areaName+"%' ";
		}
		
		if((!(startTime == "" || startTime == null))){
			long startTimeLong = CommonUtil.fomatDateStrToLong(startTime, "yyyy-MM-dd HH:mm:ss");
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and createtime >= " + startTimeLong + " ";
			}else{
				conditionSql += "createtime >= " + startTimeLong + " ";
			}
			
		}
		
		if((!(endTime == "" || endTime == null))){
			long endTimeLong = CommonUtil.fomatDateStrToLong(endTime, "yyyy-MM-dd HH:mm:ss");
			
			if(!(conditionSql == "" || conditionSql == null)){
				conditionSql += "and createtime <= " + endTimeLong + " ";
			}else{
				conditionSql += "createtime <= " + endTimeLong + " ";
			}
		}
		
		if(!(conditionSql == "" || conditionSql == null)){
			sql += " where " + conditionSql + " order by createtime desc ";
		}else{
			sql += " order by createtime desc ";
		}
		
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MYSQLDBmanger.closeAll(conn, ptst, rs);
		}
		return count;

	}
	

}

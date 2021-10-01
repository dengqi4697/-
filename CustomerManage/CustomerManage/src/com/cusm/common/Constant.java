package com.cusm.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {
	
	public static final String LOGIN_USER_ATTR = "LOGIN_USER_ATTR";
	
	public static String LOGIN_NORMAL_USERNAME = "xaxkt";
	
	public static String LOGIN_NORMAL_PASSWORD = "xaxkt@123456";
	
	public static String LOGIN_ADMIN_USERNAME = "admin";
	
	public static String LOGIN_ADMIN_PASSWORD = "admin@Dq654321";
	
	public static String WEB_SERVER_IP = "127.0.0.2";//服务39.105.76.114 本地127.0.0.1
	
	public static String WEB_SERVER_PORT = "8099";//服务8081
	
	public static String MYSQL_SERVER_IP = "127.0.0.2";//服务和本地一致127.0.0.1
	
	public static String MYSQL_SERVER_PORT = "3306";//服务和本地一致3306
	
	public static String MYSQL_DATABASE_NAME = "mysql";//服务是form 本地mysql
	
	public static String MYSQL_DATABASE_USER = "root";//服务是dengqi 本地root
	
	public static String MYSQL_DATABASE_USERPWD = "";//服务是xiaomayi 本地密码是空
	
	public static String  configPath = "";
	
	/**
	 * 没有重复插入成功 
	 * 注：编号为三位 第一位字母无意义仅代表错误码第二位代表请求是否成功第三位为重复情况的编码
	 */
	public static final String REGISTER_SUCCESS_NO_REPEAT = "E10";
	
	/**
	 * 没有重复 插入失败
	 * 注：编号为三位 第一位字母无意义仅代表错误码第二位代表请求是否成功第三位为重复情况的编码
	 */
	public static final String REGISTER_FAIL_NO_REPEAT = "E00";
	
	/**
	 * 重复并且同天 
	 * 注：编号为三位 第一位字母无意义仅代表错误码第二位代表请求是否成功第三位为重复情况的编码
	 */
	public static final String REGISTER_SUCCESS_REPEAT_SAMEDAY = "E01";
	
	/**
	 * 重复并且不同天插入成功 
	 * 注：编号为三位 第一位字母无意义仅代表错误码第二位代表请求是否成功第三位为重复情况的编码
	 */
	public static final String REGISTER_SUCCESS_REPEAT_DIFFDAY = "E12";
	
	/**
	 * 重复并且不同天插入失败 
	 * 注：编号为三位 第一位字母无意义仅代表错误码第二位代表请求是否成功第三位为重复情况的编码
	 */
	public static final String REGISTER_FAIL_REPEAT_DIFFDAY = "E02";
	
	/**
	 * 初始化config
	 * @param path
	 */
	public static void initSysConfig(String path){
		configPath = path;
		System.out.println(path);
		Properties prop = new Properties();     
        try{
	        //读取属性文件a.properties
	        InputStream in = new BufferedInputStream (new FileInputStream(path));
	         prop.load(in);     ///加载属性列表
	         Iterator<String> it=prop.stringPropertyNames().iterator();
	          while(it.hasNext()){
	        	  String keyPro = it.next();
	              String valuePro = prop.getProperty(keyPro);
	              if("LOGIN_NORMAL_USERNAME".equals(keyPro)){
	            	  LOGIN_NORMAL_USERNAME = valuePro;
	              }else if("LOGIN_NORMAL_PASSWORD".equals(keyPro)){
	            	  LOGIN_NORMAL_PASSWORD = valuePro;
	              }else if("LOGIN_ADMIN_USERNAME".equals(keyPro)){
	            	  LOGIN_ADMIN_USERNAME = valuePro;
	              }else if("LOGIN_ADMIN_PASSWORD".equals(keyPro)){
	            	  LOGIN_ADMIN_PASSWORD = valuePro;
	              }else if("WEB_SERVER_IP".equals(keyPro)){
	            	  WEB_SERVER_IP = valuePro;
	              }else if("WEB_SERVER_PORT".equals(keyPro)){
	            	  WEB_SERVER_PORT = valuePro;
	              }else if("MYSQL_SERVER_IP".equals(keyPro)){
	            	  MYSQL_SERVER_IP = valuePro;
	              }else if("MYSQL_SERVER_PORT".equals(keyPro)){
	            	  MYSQL_SERVER_PORT = valuePro;
	              }else if("MYSQL_DATABASE_NAME".equals(keyPro)){
	            	  MYSQL_DATABASE_NAME = valuePro;
	              }else if("MYSQL_DATABASE_USER".equals(keyPro)){
	            	  MYSQL_DATABASE_USER = valuePro;
	              }else if("MYSQL_DATABASE_USERPWD".equals(keyPro)){
	            	  MYSQL_DATABASE_USERPWD = valuePro;
	              }
	          }
	         in.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
	}

	public static String getLOGIN_NORMAL_USERNAME() {
		return LOGIN_NORMAL_USERNAME;
	}

	public static void setLOGIN_NORMAL_USERNAME(String lOGINNORMALUSERNAME) {
		LOGIN_NORMAL_USERNAME = lOGINNORMALUSERNAME;
	}

	public static String getLOGIN_NORMAL_PASSWORD() {
		return LOGIN_NORMAL_PASSWORD;
	}

	public static void setLOGIN_NORMAL_PASSWORD(String lOGINNORMALPASSWORD) {
		LOGIN_NORMAL_PASSWORD = lOGINNORMALPASSWORD;
	}

	public static String getLOGIN_ADMIN_USERNAME() {
		return LOGIN_ADMIN_USERNAME;
	}

	public static void setLOGIN_ADMIN_USERNAME(String lOGINADMINUSERNAME) {
		LOGIN_ADMIN_USERNAME = lOGINADMINUSERNAME;
	}

	public static String getLOGIN_ADMIN_PASSWORD() {
		return LOGIN_ADMIN_PASSWORD;
	}

	public static void setLOGIN_ADMIN_PASSWORD(String lOGINADMINPASSWORD) {
		LOGIN_ADMIN_PASSWORD = lOGINADMINPASSWORD;
	}

	public static String getWEB_SERVER_IP() {
		return WEB_SERVER_IP;
	}

	public static void setWEB_SERVER_IP(String wEBSERVERIP) {
		WEB_SERVER_IP = wEBSERVERIP;
	}

	public static String getWEB_SERVER_PORT() {
		return WEB_SERVER_PORT;
	}

	public static void setWEB_SERVER_PORT(String wEBSERVERPORT) {
		WEB_SERVER_PORT = wEBSERVERPORT;
	}

	public static String getMYSQL_SERVER_IP() {
		return MYSQL_SERVER_IP;
	}

	public static void setMYSQL_SERVER_IP(String mYSQLSERVERIP) {
		MYSQL_SERVER_IP = mYSQLSERVERIP;
	}

	public static String getMYSQL_SERVER_PORT() {
		return MYSQL_SERVER_PORT;
	}

	public static void setMYSQL_SERVER_PORT(String mYSQLSERVERPORT) {
		MYSQL_SERVER_PORT = mYSQLSERVERPORT;
	}

	public static String getMYSQL_DATABASE_NAME() {
		return MYSQL_DATABASE_NAME;
	}

	public static void setMYSQL_DATABASE_NAME(String mYSQLDATABASENAME) {
		MYSQL_DATABASE_NAME = mYSQLDATABASENAME;
	}

	public static String getMYSQL_DATABASE_USER() {
		return MYSQL_DATABASE_USER;
	}

	public static void setMYSQL_DATABASE_USER(String mYSQLDATABASEUSER) {
		MYSQL_DATABASE_USER = mYSQLDATABASEUSER;
	}

	public static String getMYSQL_DATABASE_USERPWD() {
		return MYSQL_DATABASE_USERPWD;
	}

	public static void setMYSQL_DATABASE_USERPWD(String mYSQLDATABASEUSERPWD) {
		MYSQL_DATABASE_USERPWD = mYSQLDATABASEUSERPWD;
	}

	public static String getConfigPath() {
		return configPath;
	}

	public static void setConfigPath(String configPath) {
		Constant.configPath = configPath;
	}

	public static String getLoginUserAttr() {
		return LOGIN_USER_ATTR;
	}

	public static String getRegisterSuccessNoRepeat() {
		return REGISTER_SUCCESS_NO_REPEAT;
	}

	public static String getRegisterFailNoRepeat() {
		return REGISTER_FAIL_NO_REPEAT;
	}

	public static String getRegisterSuccessRepeatSameday() {
		return REGISTER_SUCCESS_REPEAT_SAMEDAY;
	}

	public static String getRegisterSuccessRepeatDiffday() {
		return REGISTER_SUCCESS_REPEAT_DIFFDAY;
	}

	public static String getRegisterFailRepeatDiffday() {
		return REGISTER_FAIL_REPEAT_DIFFDAY;
	}
	
	
	
	
	
}

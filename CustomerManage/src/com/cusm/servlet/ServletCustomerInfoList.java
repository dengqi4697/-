package com.cusm.servlet;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cusm.bean.CustomerInfo;
import com.cusm.dao.CustomerInfoDao;




/**
 * Servlet implementation class ServletRegister
 */
public class ServletCustomerInfoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ServletCustomerInfoList.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCustomerInfoList() {
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
		
	        try {
	        	
	        	InputStream in = new FileInputStream("D://stu-manger.rar");
	            //String gFileName = URLEncoder.encode(fileName, "UTF-8");
	            //如进行下载名为：文件（3）.txt，下载时显示名为：文件+（3）.txt --空格变为了+号
	            //解决办法如下
	            //String dFileName = gFileName.replaceAll("\\+", "%20");
	            //设置输出的格式
	            response.reset();	//去除前后空格
	            //激活浏览器弹出窗口
	            //response.setContentType("application/x-msdownload");
	            //浏览器弹出窗口显示的文件名
	            //response.addHeader("Content-Disposition", "attachment;filename="+dFileName);
	            byte[] b = new byte[1024];
	            int len;
	            while ((len = in.read(b)) > 0){
	                response.getOutputStream().write(b, 0, len);
	            }
	           // File file = new File(WordText.fileNew);
	           // file.delete();
	        } catch (Exception e){
	            e.printStackTrace();
	        }

		
		
		/*request.setCharacterEncoding("utf-8");
		String areaName = request.getParameter("areaname");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		CustomerInfoDao customerInfoDao = new CustomerInfoDao();
		List<CustomerInfo> customerInfoList = customerInfoDao.queryCustomerInfoList(areaName,startTime,endTime);
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setCharacterEncoding("utf-8");
         
        ExportExcel<CustomerInfo> ee = new ExportExcel<CustomerInfo>();
        String[] headers = { "姓名", "电话", "创建时间","创建时间戳", "地址","区域编号","区域名称" };
        String[] fields = { "name", "telephone", "createTimeStr","createTime","address", "areaId", "areaName" };
        
         ee.exportExcel(headers,fields, customerInfoList, "客户信息", response);*/
              
		//System.out.println(JSON.toJSONString(customerInfoList));
		//response.getWriter().print(JSON.toJSONString(map));
	}
	
	class ExportExcel<T> {
		public void exportExcel(String[] headers,String[] fields,Collection<T> dataset, String fileName,HttpServletResponse response) {
			// 声明一个工作薄
			XSSFWorkbook workbook = new XSSFWorkbook();
			// 生成一个表格
			XSSFSheet sheet = workbook.createSheet(fileName);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth((short) 20);
			// 产生表格标题行
			XSSFRow row = sheet.createRow(0);
			for (short i = 0; i < headers.length; i++) {
				XSSFCell cell = row.createCell(i);
				XSSFRichTextString text = new XSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			try {
				// 遍历集合数据，产生数据行
				Iterator<T> it = dataset.iterator();
				int index = 0;
				while (it.hasNext()) {
					index++;
					row = sheet.createRow(index);
					T t = (T) it.next();
					// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
					//Field[] fields = t.getClass().getDeclaredFields();
					for (short i = 0; i < headers.length; i++) {
						XSSFCell cell = row.createCell(i);
						String fieldName = fields[i];
						String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
						Class tCls = t.getClass();
						Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
						Object value = getMethod.invoke(t, new Object[] {});
						// 判断值的类型后进行强制类型转换
						String textValue = null;
						// 其它数据类型都当作字符串简单处理
						if(value != null && value != ""){
							textValue = value.toString();
						}
						if (textValue != null) {
							XSSFRichTextString richString = new XSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}
				}
				getExportedFile(workbook, fileName,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	//产生输出
		public void getExportedFile(XSSFWorkbook workbook, String name,
				HttpServletResponse response) throws Exception {
			BufferedOutputStream fos = null;
			try {
				String fileName = name + ".xlsx";
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-Disposition",
						"attachment;filename="
								+ new String(fileName.getBytes("gb2312"),
										"ISO8859-1"));
				fos = new BufferedOutputStream(response.getOutputStream());
				workbook.write(fos);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
		}
	}
	
	/**
	 * long时间转换为能看懂的String
	 * @param time
	 * @param format
	 * @return
	 */
	 public static String fomatLongToDate(Long time,String format){
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	Date date = new Date(time);
    	return sdf.format(date);
	 }
	
  
}

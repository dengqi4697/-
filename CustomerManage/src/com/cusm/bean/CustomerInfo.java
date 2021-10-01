package com.cusm.bean;

/**
 * 
 * @author zyy
 * 客户信息bean
 *
 */
public class CustomerInfo {
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 电话号码
	 */
	private String telephone;
	/**
	 * 创建时间
	 */
	private long createTime;
	
	/**
	 * 创建时间要显示的时间
	 */
	private String createTimeStr;
	
	/**
	 * 修改时间 暂时预留
	 */
	private long updateTime;
	
	/**
	 * 修改时间  显示的时间 要暂时预留
	 */
	private String updateTimeStr;
	
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 区域id
	 */
	private String areaId;
	/**
	 * 区域名称 暂时预留
	 */
	private String areaName;
	/**
	 * 备注 暂时预留
	 */
	private String remark;
	/**
	 * 是否删除标记 暂时预留
	 */
	private String flag;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateTimeStr() {
		return updateTimeStr;
	}
	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}

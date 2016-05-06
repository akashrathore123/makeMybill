package com.makeMybill.dto;

public class BillDTO {
	private int meterId;
	private String userId;
	private String lastMonthPaid;
	private String unbilledAmount;
	private double totalUnit;
	private String lastPaidAmount;
	private String billTill;
	private String totalPaid;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMeterId() {
		return meterId;
	}
	public void setMeterId(int meterId) {
		this.meterId = meterId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLastMonthPaid() {
		return lastMonthPaid;
	}
	public void setLastMonthPaid(String lastMonthPaid) {
		this.lastMonthPaid = lastMonthPaid;
	}
	public String getUnbilledAmount() {
		return unbilledAmount;
	}
	public void setUnbilledAmount(String unbilledAmount) {
		this.unbilledAmount = unbilledAmount;
	}
	public double getTotalUnit() {
		return totalUnit;
	}
	public void setTotalUnit(double totalUnit) {
		this.totalUnit = totalUnit;
	}
	public String getLastPaidAmount() {
		return lastPaidAmount;
	}
	public void setLastPaidAmount(String lastPaidAmount) {
		this.lastPaidAmount = lastPaidAmount;
	}
	public String getBillTill() {
		return billTill;
	}
	public void setBillTill(String billTill) {
		this.billTill = billTill;
	}
	public String getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}
	
}

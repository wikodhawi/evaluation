package dto;

import java.util.Date;

public class PoDto {
	private String poNo;
	private String supId;
	private String poAddress;
	private String cityId;
	private Date poDate;
	private Date poExpDate;
	private String poShipment;
	private String poNotes;
	private int discount;
	private int total;
	private String supName;
	
	
	
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getPoAddress() {
		return poAddress;
	}
	public void setPoAddress(String poAddress) {
		this.poAddress = poAddress;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public Date getPoExpDate() {
		return poExpDate;
	}
	public void setPoExpDate(Date poExpDate) {
		this.poExpDate = poExpDate;
	}
	public String getPoShipment() {
		return poShipment;
	}
	public void setPoShipment(String poShipment) {
		this.poShipment = poShipment;
	}
	public String getPoNotes() {
		return poNotes;
	}
	public void setPoNotes(String poNotes) {
		this.poNotes = poNotes;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}

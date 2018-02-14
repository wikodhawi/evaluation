package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="t_po")
@IdClass(PoPK.class)
public class Po {
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
	
	@Id
	@Column(name="po_no")
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	
	@Column(name="sup_id")
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	
	@Column(name="po_address")
	public String getPoAddress() {
		return poAddress;
	}
	public void setPoAddress(String poAddress) {
		this.poAddress = poAddress;
	}
	
	@Column(name="city_id")
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	@Column(name="po_date")
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	
	@Column(name="po_exp_date")
	public Date getPoExpDate() {
		return poExpDate;
	}
	public void setPoExpDate(Date poExpDate) {
		this.poExpDate = poExpDate;
	}
	
	@Column(name="po_shipment")
	public String getPoShipment() {
		return poShipment;
	}
	public void setPoShipment(String poShipment) {
		this.poShipment = poShipment;
	}
	
	@Column(name="po_notes")
	public String getPoNotes() {
		return poNotes;
	}
	
	
	public void setPoNotes(String poNotes) {
		this.poNotes = poNotes;
	}
	
	@Column(name="discount")
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	@Column(name="total")
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
}

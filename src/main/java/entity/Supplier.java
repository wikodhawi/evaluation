package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="m_supplier")
@IdClass(SupplierPK.class)
public class Supplier {
	
	private String supId;
	private String supName;
	private String supAddress;
	

	@Id
	@Column(name="sup_id")
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	
	@Column(name="sup_name")
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	
	@Column(name="sup_address")
	public String getSupAddress() {
		return supAddress;
	}
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	
	
	
}

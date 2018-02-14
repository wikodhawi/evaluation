package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="m_province")
@IdClass(ProvincePK.class)
public class Province {
	
	private String provId;
	private String provName;
	
	@Id
	@Column(name="prov_id")
	public String getProvId() {
		return provId;
	}
	public void setProvId(String provId) {
		this.provId = provId;
	}
	
	@Column(name="prov_name")
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	
	
		
}

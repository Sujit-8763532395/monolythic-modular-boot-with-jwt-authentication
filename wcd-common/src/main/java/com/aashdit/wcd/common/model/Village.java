package com.aashdit.wcd.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_mst_village")
public class Village extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = -4417067869809987363L;

	@Id
	@Column(name = "village_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long villageId;

	@Column(name = "village_name")
	private String villageName;

	@Column(name = "village_code")
	private String villageCode;

	@ManyToOne
	@JoinColumn(name = "gp_id")
	private Panchayat panchayat;

	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "is_active")
	private Boolean isActive;

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Panchayat getPanchayat() {
		return panchayat;
	}

	public void setPanchayat(Panchayat panchayat) {
		this.panchayat = panchayat;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
	
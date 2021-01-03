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
@Table(name = "t_mst_municipality")
public class Municipality extends Auditable<Long>implements Serializable {

	private static final long serialVersionUID = 3564519581695874915L;

	@Id
	@Column(name = "municipality_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long municipalityId;

	@Column(name = "municipality_name")
	private String municipalityName;
	
	@Column(name = "municipality_code")
	private String municipalityCode;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "remarks")
	private String remarks;

	public Long getMunicipalityId() {
		return municipalityId;
	}

	public void setMunicipalityId(Long municipalityId) {
		this.municipalityId = municipalityId;
	}

	public String getMunicipalityName() {
		return municipalityName;
	}

	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
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

	public String getMunicipalityCode() {
		return municipalityCode;
	}

	public void setMunicipalityCode(String municipalityCode) {
		this.municipalityCode = municipalityCode;
	}

}
	
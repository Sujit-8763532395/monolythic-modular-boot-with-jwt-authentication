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
@Table(name = "t_mst_subdivision")
public class Subdivision extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = -4017365926398370178L;

	@Id
	@Column(name = "subdivision_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long subdivisionId;

	@Column(name = "subdivision_name")
	private String subdivisionName;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "subdivision_code")
	private String subdivisionCode;

	public Long getSubdivisionId() {
		return subdivisionId;
	}

	public void setSubdivisionId(Long subdivisionId) {
		this.subdivisionId = subdivisionId;
	}

	public String getSubdivisionName() {
		return subdivisionName;
	}

	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getSubdivisionCode() {
		return subdivisionCode;
	}

	public void setSubdivisionCode(String subdivisionCode) {
		this.subdivisionCode = subdivisionCode;
	}
	
}
	
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
@Table(name = "t_mst_gramapanchayat")
public class Panchayat extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 4436643400293481259L;

	@Id
	@Column(name = "gp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gpId;

	@Column(name = "gp_name")
	private String gpName;
	
	@Column(name = "gp_code")
	private String gpCode;

	@ManyToOne
	@JoinColumn(name = "block_id")
	private Block block;

	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	public Long getGpId() {
		return gpId;
	}

	public void setGpId(Long gpId) {
		this.gpId = gpId;
	}

	public String getGpName() {
		return gpName;
	}

	public void setGpName(String gpName) {
		this.gpName = gpName;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getGpCode() {
		return gpCode;
	}

	public void setGpCode(String gpCode) {
		this.gpCode = gpCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
	
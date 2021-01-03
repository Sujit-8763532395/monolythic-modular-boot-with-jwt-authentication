package com.aashdit.wcd.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aashdit.wcd.common.model.Block;
import com.aashdit.wcd.common.model.District;
import com.aashdit.wcd.common.model.Subdivision;

@Entity
@Table(name = "user_location")
public class UserLocation implements Serializable {

	private static final long serialVersionUID = 6386524578826187796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_location_id")
	Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "district_id")
	District district;

	@ManyToOne
	@JoinColumn(name = "subdivision_id")
	Subdivision subdivision;
	
	@ManyToOne
	@JoinColumn(name = "block_id")
	Block block;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Subdivision getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(Subdivision subdivision) {
		this.subdivision = subdivision;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}
	
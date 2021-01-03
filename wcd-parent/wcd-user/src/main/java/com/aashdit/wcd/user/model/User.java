package com.aashdit.wcd.user.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_um_user")
public class User implements Serializable {

	private static final long serialVersionUID = 3411429084975763614L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	Long id;

	@Column(name = "name")
	String name;

	@Column(name = "user_name")
	String userName;

	@Column(name = "password")
	String password;

	@Column(name = "email")
	String email;

	@Column(name = "mobile_no")
	String mobile;

	@Column(name = "address")
	String address;

	@Column(name = "is_enabled")
	Boolean isEnabled;

	@Column(name = "is_account_non_locked")
	Boolean isAccountNonLocked;

	@Column(name = "is_account_non_logged")
	Boolean isConfirm;

	@Column(name = "created_by")
	String createdBy;

	@Column(name = "created_date")
	Date createdDate;

	@Column(name = "updated_by")
	String updatedBy;

	@Column(name = "updated_date")
	Date updatedDate;
	
	@Column(name="loggedin_time")
	private Timestamp loggedinTime; 
	
	@Column(name="reset_password_otp")
	String resetPasswordOtp;
	
	@Column(name="reset_password_time")
	Timestamp resetPasswordTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public Boolean getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(Boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Timestamp getLoggedinTime() {
		return loggedinTime;
	}

	public void setLoggedinTime(Timestamp loggedinTime) {
		this.loggedinTime = loggedinTime;
	}

	public String getResetPasswordOtp() {
		return resetPasswordOtp;
	}

	public void setResetPasswordOtp(String resetPasswordOtp) {
		this.resetPasswordOtp = resetPasswordOtp;
	}

	public Timestamp getResetPasswordTime() {
		return resetPasswordTime;
	}

	public void setResetPasswordTime(Timestamp resetPasswordTime) {
		this.resetPasswordTime = resetPasswordTime;
	}

}
	
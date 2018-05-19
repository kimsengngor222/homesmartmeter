package com.keylesson.EntityClasses;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	private int roleID;
	private String role;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int userID;
	private User_Registration user_registration;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User_Registration getUser_registration() {
		return user_registration;
	}

	public void setUser_registration(User_Registration user_registration) {
		this.user_registration = user_registration;
	}
}

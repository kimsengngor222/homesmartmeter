package com.keylesson.EntityClasses;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	private int userID;
	private int regionID;
	private int ID;
	private String name;
	private String type;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	private User_Registration user_registration;
	private Region region;
	private Set<Data> data;
	private Set<Report> report;
	private Set<Board> board;
	private Set<Daily_Usage> daily_usage;

	public Set<Daily_Usage> getDaily_usage() {
		return daily_usage;
	}

	public void setDaily_usage(Set<Daily_Usage> daily_usage) {
		this.daily_usage = daily_usage;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
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

	public Set<Report> getReport() {
		return report;
	}

	public void setReport(Set<Report> report) {
		this.report = report;
	}

	public Set<Board> getBoard() {
		return board;
	}

	public void setBoard(Set<Board> board) {
		this.board = board;
	}

	public Set<Data> getData() {
		return data;
	}

	public void setData(Set<Data> data) {
		this.data = data;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public User_Registration getUser_registration() {
		return user_registration;
	}

	public void setUser_registration(User_Registration user_registration) {
		this.user_registration = user_registration;
	}
}

package com.keylesson.EntityClasses;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {
	private int ID;
	private int roomID;
	private String roomName;
	private Room room;
	private float power;
	private float water;
	private float overUsagePower;
	private float overUsageWater;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private String message;
	private String email;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}

	public float getWater() {
		return water;
	}

	public void setWater(float water) {
		this.water = water;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public float getOverUsagePower() {
		return overUsagePower;
	}

	public void setOverUsagePower(float overUsagePower) {
		this.overUsagePower = overUsagePower;
	}

	public float getOverUsageWater() {
		return overUsageWater;
	}

	public void setOverUsageWater(float overUsageWater) {
		this.overUsageWater = overUsageWater;
	}

}

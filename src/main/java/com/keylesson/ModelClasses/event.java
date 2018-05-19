package com.keylesson.ModelClasses;

public class event {

	private float power;
	private float water;
	private String message;
	private String email;
	private String roomName;
	private int roomID;
	private int ID;
	private float overUsagePower;
	private float overUsageWater;
	
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		this.ID = id;
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

}

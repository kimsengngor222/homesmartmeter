package com.keylesson.ServiceClasses;

import java.util.List;
import java.util.Map;

import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.ModelClasses.boardreg;
import com.keylesson.ModelClasses.delete;
import com.keylesson.ModelClasses.update;
import com.keylesson.ModelClasses.event;
//import com.keylesson.ModelClasses.event;



public interface usersService {
	public List<Map<String,Object>> getAllRegion();
	public List<User_Registration> getUsers();
	public List<Map<String,Object>> getSource();
	public List<Map<String,Object>> getAllLocation();
	public List<Map<String, Object>> getRegion(String id);
	public List<Map<String, Object>> getRoom(String id);
	public List<Map<String, Object>> getSingleRoom(int i);
	public int getEvent(event event);
	public boolean getUpdation(update update);
	public boolean getDeletion(delete delete);
	public Map<String, Object> getReport(String id, String export_from, String export_until);
	public List<Map<String, Object>> getEvents();
	public int registerBoard(boardreg boardreg);
	public int registerRoom(boardreg boardreg);
	public int registerRegionName(boardreg boardreg);
	public int registerLocation(boardreg boardreg);
	
	
}

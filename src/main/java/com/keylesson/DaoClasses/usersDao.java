package com.keylesson.DaoClasses;

import java.util.List;
import java.util.Map;

import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.ModelClasses.boardreg;
import com.keylesson.ModelClasses.delete;
import com.keylesson.ModelClasses.update;
import com.keylesson.ModelClasses.event;



public interface usersDao {
	public List<Map<String,Object>> getAllRegion();
	public List<User_Registration> getUsers();
	public List<Map<String, Object>> getSource();
	public List<Map<String,Object>> getAllLocation();
	public List<Map<String, Object>> getRegion(String id);
	public List<Map<String, Object>> getRoom(String id);
	public Map<String, Object> getReport(String id, String export_from, String export_until);
	public int getEvent(event event);
	
	public List<Map<String, Object>> getEvents();
	public int registerBoard(boardreg boardreg);
	public int registerRoom(boardreg boardreg);
	public int registerRegionName(boardreg boardreg);
	public int registerLocation(boardreg boardreg);
	public boolean getUpdation(update update);
	public boolean getDeletion(delete delete);
	public List<Map<String, Object>> getSingleRoom(int id);
}

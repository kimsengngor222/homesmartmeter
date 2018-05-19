package com.keylesson.ServiceClasses;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.DaoClasses.usersDao;
import com.keylesson.ModelClasses.boardreg;
import com.keylesson.ModelClasses.delete;
import com.keylesson.ModelClasses.update;
import com.keylesson.ModelClasses.event;



@Service
public class usersServiceImpl implements usersService{

	@Autowired
	usersDao usersDao1;

	public List<Map<String,Object>> getAllRegion() {
		return usersDao1.getAllRegion();
	}
	public List<User_Registration> getUsers(){
		return usersDao1.getUsers();
	}
	public List<Map<String,Object>> getSource() {
		return usersDao1.getSource();
	}
	public  List<Map<String,Object>> getAllLocation(){
		return usersDao1.getAllLocation();
	}
	public List<Map<String, Object>> getRegion(String id){
		return usersDao1.getRegion(id);
	}
	public List<Map<String, Object>> getRoom(String id){
		return usersDao1.getRoom(id);
	}
	
	public List<Map<String, Object>> getSingleRoom(int id){
		return usersDao1.getSingleRoom(id);
	}
	
		
	public int getEvent(event event){
		return usersDao1.getEvent(event);
	}
	public boolean getUpdation(update update){
		return usersDao1.getUpdation(update);
	}
	public boolean getDeletion(delete delete){
		return usersDao1.getDeletion(delete);
	}
	public int registerBoard(boardreg boardreg){
		return usersDao1.registerBoard(boardreg);
	}
	public int registerRoom(boardreg boardreg){
		return usersDao1.registerRoom(boardreg);
	}
	public int registerRegionName(boardreg boardreg){
		return usersDao1.registerRegionName(boardreg);
	}
	public int registerLocation(boardreg boardreg){
		return usersDao1.registerLocation(boardreg);
	}
	public Map<String, Object> getReport(String id, String export_from, String export_until){
		return usersDao1.getReport(id, export_from, export_until);
	}
	
	public List<Map<String, Object>> getEvents(){
		return usersDao1.getEvents();
	}
	
	

	
	
}

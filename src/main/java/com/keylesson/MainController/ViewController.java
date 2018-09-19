package com.keylesson.MainController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.keylesson.ModelClasses.boardreg;
import com.keylesson.ModelClasses.delete;
import com.keylesson.ModelClasses.update;
import com.keylesson.ModelClasses.event;
import com.keylesson.ServiceClasses.usersService;

@Controller
public class ViewController {
	@Autowired
	usersService usersService1;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView init() {

		return new ModelAndView("dashboard");
	}

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public @ResponseBody Map<Object, Object> getAll() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Map<String, Object>> list = usersService1.getAllRegion();
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/sourceload", method = RequestMethod.GET)
	public @ResponseBody Map<Object, Object> getSourceBody() {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map<String, Object>> list = usersService1.getSource();
		if (list != null) {
			map1.put("status", "200");
			map1.put("message", "Data found");
			map1.put("data", list);

		} else {
			map1.put("status", "404");
			map1.put("message", "Data not found");
		}

		return map1;
	}

	@RequestMapping(value = "/exportloc", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getLoc() {
		Map<Object, Object> map = new HashMap<Object, Object>();

		List<Map<String, Object>> list = usersService1.getAllLocation();

		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/exportreg", method = RequestMethod.GET)
	public @ResponseBody Map<Object, Object> getReg(String id) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		List<Map<String, Object>> list = usersService1.getRegion(id);

		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/exportroom", method = RequestMethod.GET)
	public @ResponseBody Map<Object, Object> getRoom(String id) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		List<Map<String, Object>> list = usersService1.getRoom(id);
		
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}
	@RequestMapping(value = "/exportroomname", method = RequestMethod.GET)
	public @ResponseBody Map<Object, Object> getEventRoomName(String id) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Map<String, Object>> list = usersService1.getEventRoomName(id);
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/exportroomid", method = RequestMethod.GET)
	public @ResponseBody Map<Object, Object> getEventRoomID(String id) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		List<Map<String, Object>> list = usersService1.getEventRoomID(id);
		
		
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}


	@RequestMapping(value = "/exportoutput", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getReport(String id,
			String export_from, String export_until) {
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> ret = usersService1.getReport(id, export_from,
				export_until);

		if (ret.size() > 0) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", ret);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/jobEvent", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getEvent(@RequestBody event event) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Map<String, Object>> room = new ArrayList<Map<String, Object>>();
		int check;
		check = usersService1.getEvent(event);
		if (check == 1) {
			room = usersService1.getSingleRoom(event.getRoomID());
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("room", room);
		} else if (check == 5) {
			map.put("status", "5");
			map.put("message", "Room already existed!");
		} else {
			map.put("status", "404");
			map.put("message", "Technical error!");
		}
		return map;
	}

	@RequestMapping(value = "/updateCard", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getUpdation(
			@RequestBody update update) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean list = usersService1.getUpdation(update);

		if (list) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getDeletion(
			@RequestBody delete delete) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean list = usersService1.getDeletion(delete);

		if (list) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;
	}

	@RequestMapping(value = "/boardboard", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> registerBoard(boardreg boardreg) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		int check;

		check = usersService1.registerBoard(boardreg);
		if (check == 1) {
			map.put("status", "200");
			map.put("message", "Successfully Added");
		} else if (check == 5) {
			map.put("status", "5");
			map.put("message", "Successfully Updated");
		} else {
			map.put("status", "404");
			map.put("message", "Technical error!");
		}
		return map;
	}

	@RequestMapping(value = "/boardroom", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> registerRoom(boardreg boardreg) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		int check;
		check = usersService1.registerRoom(boardreg);
		if (check == 1) {
			map.put("status", "200");
			map.put("message", "Data found");
		} else if (check == 5) {
			map.put("status", "5");
			map.put("message", "Room already existed!");
		} else {
			map.put("status", "404");
			map.put("message", "Technical error!");
		}
		return map;
	}

	@RequestMapping(value = "/boardregion", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> registerRegionName(
			boardreg boardreg) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		int check;
		check = usersService1.registerRegionName(boardreg);
		if (check == 1) {
			map.put("status", "200");
			map.put("message", "Data found");
		} else if (check == 5) {
			map.put("status", "5");
			map.put("message", "Room already existed!");
		} else {
			map.put("status", "404");
			map.put("message", "Technical error!");
		}
		return map;
	}

	@RequestMapping(value = "/boardlocation", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> registerLocation(boardreg boardreg) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		int check;
		check = usersService1.registerLocation(boardreg);
		if (check == 1) {
			map.put("status", "200");
			map.put("message", "Data found");
		} else if (check == 5) {
			map.put("status", "5");
			map.put("message", "Room already existed!");
		} else {
			map.put("status", "404");
			map.put("message", "Technical error!");
		}
		return map;
	}

	@RequestMapping(value = "/getEvents", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getEvents() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> ret = usersService1.getEvents();
		if (ret.size() > 0) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", ret);

		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}

		return map;

	}

}
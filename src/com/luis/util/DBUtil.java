package com.luis.util;

import java.util.HashMap;

import com.luis.model.User;

public class DBUtil {
	private static HashMap<String, User> userMap = new HashMap<String, User>();
	
	public static boolean addUser(String username, String password, int age, String sex)
	{
		if(userMap.containsKey(username)) {
			return false;
		}
		else {
			User user = new User(username, password, age, sex);
			userMap.put(username, user);
			return true;
		}		
	}
	public static User verifyAccount(String username, String password) {
		if(userMap.containsKey(username)) {
			User user = userMap.get(username);
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}
}

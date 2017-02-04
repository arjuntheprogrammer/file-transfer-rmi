package service;

import java.util.HashMap;

import dto.User;

public class LoginService {
	
	HashMap<String, String> users=new HashMap<String, String>();
	
	public LoginService(){
		users.put("arjun","arjun gupta");
		users.put("komal","komal");
		users.put("abc","abc");
		
	}
	
	public boolean authenticate(String userId, String password){
		 if(password==null || password.trim()==""){
			 return false;
		 }
		 return true;
	}
	
	public User getUserDetails(String userId){
		
		User user=new User();
		
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		
		return user;
	}
	
}

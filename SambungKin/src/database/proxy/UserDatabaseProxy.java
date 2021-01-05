package database.proxy;

import java.util.Iterator;

import database.UserDatabase;
import model.User;

public class UserDatabaseProxy implements DatabaseProxy{
	private UserDatabase userDB;
	
	public UserDatabaseProxy() {
		userDB = new UserDatabase();
	}

	@Override
	public void registerUser(User user) {
		userDB.addUser(user);
	}

	@Override
	public User isUser(String email, String password) {
		Iterator users = userDB.createIterator();
		
		if(!users.hasNext()) {
			return null;
		}
		
		while(users.hasNext()) {
			User user = (User) users.next();
			
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}

}

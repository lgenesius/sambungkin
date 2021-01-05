package database;

import java.util.Iterator;
import java.util.Vector;

import database.iterators.UserIterator;
import database.proxy.DatabaseProxy;
import model.User;

public class UserDatabase implements UserIterator{
	private Vector<User> userList;
	
	public UserDatabase() {
		userList = new Vector<>();
	}

	public void addUser(User user) {
		userList.add(user);
	}

	@Override
	public Iterator createIterator() {
		return userList.iterator();
	}

	
}

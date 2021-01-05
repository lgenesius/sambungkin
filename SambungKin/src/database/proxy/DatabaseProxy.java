package database.proxy;

import model.User;

public interface DatabaseProxy {
	public void registerUser(User user);
	public User isUser(String email, String password);
}

package model;

public class User {
	private String name;
	private String email;
	private String password;
	private String company;
	private int age;
	private String description;

	public User(String name, String email, String password, String company, int age, String description) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.company = company;
		this.age = age;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

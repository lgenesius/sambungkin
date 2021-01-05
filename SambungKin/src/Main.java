import java.util.Scanner;

import database.proxy.UserDatabaseProxy;
import model.User;

public class Main {
	UserDatabaseProxy proxy = new UserDatabaseProxy();
	Scanner scan = new Scanner(System.in);
	public Main() {
		int choose = 0;
		
		do {
			try {
				menu();
				choose = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.next();
				choose = 0;
			}
			
			switch(choose) {
			case 1:login();
				break;
			case 2: register();
				break;
			}
		} while (choose != 3);
		
	}

	private void register() {
		String name = null;
		
		do {
			System.out.print("Insert name[4-10]: ");
			name = scan.nextLine();
		} while (name.length() < 4 || name.length() > 10);
		
		String email = null;
		boolean flag = false;
		
		do {
			System.out.print("Set your email[must have '@' and '.com']: ");
			email = scan.nextLine();
			
			if(email.contains("@") && email.endsWith(".com") && email.length() > 4) {
				flag = true;
			}
		} while (flag == false);
		
		String password = null;
		
		do {
			System.out.print("Set your password[6-12]: ");
			password = scan.nextLine();
		} while (password.length() < 6 || password.length() > 12);
		
		System.out.println("Success create profile! now for the last step fill your resume!");
		
		String haveJob = null;
		String company = null;
		
		do {
			System.out.print("Do you have current job? [y|n]: ");
			haveJob = scan.nextLine();
		} while (!haveJob.equalsIgnoreCase("y") && !haveJob.equalsIgnoreCase("n"));
		
		if(haveJob.equalsIgnoreCase("Y")) {
			System.out.print("Input your company name: ");
			company = scan.nextLine();
		} else {
			company = "-";
		}
		
		int age = 0;
		
		System.out.print("Set your age: ");
		age = scan.nextInt(); scan.nextLine();
		
		String description = null;
		System.out.println("Describe Your Character:");
		description = scan.nextLine();
		
		User user = new User(name, email, password, company, age, description);
		proxy.registerUser(user);
	}

	private void login() {
		String email = null;
		boolean flag = false;
		System.out.println("Login");
		System.out.println("========");
		do {
			System.out.print("Email: ");
			email = scan.nextLine();
			
			if(email.contains("@") && email.endsWith(".com") && email.length() > 4) {
				flag = true;
			}
		} while (flag == false);
		
		String password = null;
		
		do {
			System.out.print("Password: ");
			password = scan.nextLine();
		} while (password.length() < 4);
		
		User user = proxy.isUser(email, password);
		if(user != null) {
			boolean logout = homeMenu(user);
			if(logout == true) {
				return;
			}
		} else {
			return;
		}
	}
	
	private boolean homeMenu(User user) {
		int choose = 0;
		
		System.out.println("Hello, " + user.getName());
		do {
			try {
				System.out.println();
				System.out.println("1. Show my profile");
				System.out.println("2. Logout");
				System.out.print(">> ");
				choose = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				scan.next();
				choose = 0;
			}
			if(choose == 1) {
				showProfile(user);
			}
		} while (choose != 2);
		
		return true;
	}
	
	private void showProfile(User user) {
		System.out.println();
		System.out.println("Name: " + user.getName());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Age: " + user.getAge());
		System.out.println("Current job: " + user.getCompany());
		System.out.println("Description :");
		System.out.println(user.getDescription());
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public void menu() {
		System.out.println();
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}
}

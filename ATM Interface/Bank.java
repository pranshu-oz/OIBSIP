import java.util.ArrayList;

public class Bank {
	ArrayList<User> users;
	User currentUser=null;

	public Bank() {
		users=new ArrayList<>();
		users.add(new User("pranshu","shukla","330048008","pranshu",10000.0));
		users.add(new User("rahul","pandey","330048033","rahul",200000.0));
		users.add(new User("shyam","sundar","330048090","shyam",300000.0));
	}
	public boolean authenticate(String accountNo, String password) {
		for(User u: users) {
			if(u.getAccountNo().equals(accountNo) && u.getPassword().equals(password)) {
				currentUser=u;
				return true;
			}
		}
		return false;
	}
	public User getUserByAccountNo(String accountNo){

		for(User u: users) {
			if(u.getAccountNo().equals(accountNo))return u;
		}
		return null;
	}
	public User getCurrentUser() {
		return currentUser;
	}

}

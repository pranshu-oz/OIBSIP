import java.util.ArrayList;

public class User {
	String firstName;
	String lastName;
	String accountNo;
	String password;
	ArrayList<String> Transiction;
	double accountBalance;
	public User(String firstName, String lastName, String accountNo, String password,
			double accountBalance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNo = accountNo;
		this.password = password;
		this.accountBalance=accountBalance;
		Transiction = new ArrayList<>();
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getPassword() {
		return password;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public boolean withdraw(double amount) {
		if(amount>accountBalance)return false;
		else {
			accountBalance-=amount;
			Transiction.add("Withdrawal : "+amount+" New Balance : "+accountBalance+"");
			return true;
		}
	}
	public boolean transfer(User recipient, double amount) {
		if(amount>accountBalance)return false;
		else {
			accountBalance-=amount;
			recipient.deposit(amount);
			Transiction.add("Transfer to : "+recipient.getAccountNo()+" balance : "+amount);
			return true;
		}
	}
	public void deposit(double amount) {
		accountBalance+=amount;
		Transiction.add("Deposit : "+amount+" New Balance is : "+accountBalance);
		
	}
	public ArrayList<String> getTransictionHistory() {
		// TODO Auto-generated method stub
		return Transiction;
	}

}

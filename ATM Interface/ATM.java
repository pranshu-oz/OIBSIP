import java.util.Scanner;

public class ATM {

	Bank bank=new Bank();
	String userId;
	String password;
	Scanner sc=new Scanner(System.in);
	public boolean login() {
		System.out.println("Enter AccountNo : ");
		userId=sc.nextLine();
		System.out.println("Enter Password : ");
		password=sc.nextLine();
		return bank.authenticate(userId, password);
		
	}
	public void doDeposit() {
		User currentUser=bank.getCurrentUser();
		System.out.println("Please Enter Amount to Deposit");
		double amount=sc.nextDouble();
		currentUser.deposit(amount);
		System.out.println("Deposite Succesfull Your New Balance is : "+currentUser.getAccountBalance());
	}
	public void doWithDrawal() {
		User currentUser=bank.getCurrentUser();
		System.out.println("Please Enter Amount : ");
		double amount=sc.nextDouble();
		if(currentUser.withdraw(amount)) {
			System.out.println("Withdraw Successfull Your New Balance is : "+currentUser.getAccountBalance());
		}
		else {
			System.out.println("Insufficiet amount Please enter valid amount");
		}
	}
	public void showTransictionHistory() {
		User currentUser=bank.getCurrentUser();
		System.out.println("Transiction History For :"+currentUser.getFirstName()+" "+currentUser.getLastName());
		for(String str: currentUser.getTransictionHistory()) {
			System.out.println(str);
		}
	}
	public void doTransfer() {
		System.out.println("Enter Users Account No.");
		String accountNo =sc.nextLine();
		User recipient=bank.getUserByAccountNo(accountNo);
		if(recipient==null) {
			System.out.println("Please Enter valid Account No.");
			return;
		}else {
			System.out.println("Please Enter Amount to Transfer");
			double amount=sc.nextDouble();
			User currentUser=bank.getCurrentUser();
			if(currentUser.transfer(recipient, amount)) {
				System.out.println("Transfer Succesfull New Balance is : "+currentUser.accountBalance);
			}else {
				System.out.println("Insufficient Balance");
			}
		}
	}
}

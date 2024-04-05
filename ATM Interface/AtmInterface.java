import java.util.Scanner;

public class AtmInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM card=new ATM();
		User currentUser;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome To Our ATM Service");
		while(true) {
			if(card.login()) {
				while(true) {
					System.out.println("Choose an option : ");
					System.out.println("1. View Transiction History");
					System.out.println("2. Withdraw");
					System.out.println("3. Deposite");
					System.out.println("4. Transfer");
					System.out.println("5. Quit");
					System.out.println("Please Enter Your Choice");
					int choice=sc.nextInt();
					
					switch(choice) {
					case 1:
						card.showTransictionHistory();
						break;
					case 2:
						card.doWithDrawal();
						break;
					case 3:
						card.doDeposit();
						break;
					case 4:
						card.doTransfer();
						break;
					case 5:
						System.out.println("ThankYou");
						return;
					default:
						System.out.println("Invalid choice , Enter valid NO.");
					}
				}
			}else System.out.println("Invalid userId or Password ");
		}

	}

}

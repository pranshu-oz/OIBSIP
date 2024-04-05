import java.util.Scanner;

public class GessingGame {

	static int TotalGamePlayed=0;
	static int TotalGuess=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		checkNoIsCorrect(sc);//check given no. is equal to generated no. or not
		
		//generate result 
		generateResult();
	}
	private static void checkNoIsCorrect(Scanner sc) {
		boolean start=true;
		final int TotalAttempt=10;
		while(start) {
			int random=(int)Math.ceil(Math.random()*100);//generate random number from 1 to 100.
			int guess=0;
			int count=0;
			System.out.println("Please Enter NO. Between 1 to 100");
			do{
				guess=isValid(sc);//if no. is valid return no.
				
				if(guess<random) {
					System.out.print("Too Low ");
					System.out.println("Please Enter No Again");
				}else if(guess>random) {
					System.out.print("Too High ");
					System.out.println("Please Enter No Again");
				}
				else { 
					System.out.println("That is correct..////??");
					break;
				}
				count++;
				System.out.println("Remaining Attempts : "+(TotalAttempt-count));
				if(count==TotalAttempt)break;
			}while(guess!=0);
			TotalGamePlayed++;
			TotalGuess+=count;
			System.out.println("Want To Guess Again press 1");
			System.out.println("Want To Exit press 0");
			int x=sc.nextInt();
			if(x==1)start=true;
			else if(x==0)start=false;
			else System.out.println("Please Enter Valid Key 0 or 1");
		}
	}
	static int isValid(Scanner sc) {
		int x=0;
		while(true) {
			try {
				x=sc.nextInt();
				if(x>=1 && x<=100) {
					return x;
				}
				else System.out.println("Please Enter Valid Number Between 1 to 100");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	static void generateResult() {
		System.out.println("Total No. Game Played By You :"+TotalGamePlayed);
		System.out.println("In "+TotalGamePlayed+" Game Total No. Of Guesses : "+TotalGuess);
		System.out.println("Your Score Is : "+(TotalGuess/TotalGamePlayed));
	}
}

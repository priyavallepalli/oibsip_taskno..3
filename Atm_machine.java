import java.util.*;
class Login{
	Scanner sc=new Scanner(System.in);
	private Object card_num;
	private Object pin_num;

	void check_account(int card_num,int pin_num){
		System.out.println("Enter your card number");
		this.card_num=sc.nextInt();
		System.out.println("Enter your pin number");
		this.pin_num=sc.nextInt();
		if(this.card_num.equals(card_num) && this.pin_num.equals(pin_num)){
			System.out.println("You have succesfully logged in.");
		}
		else {
			System.out.println("Wrong details.Please enter your details correctly!!!");
			check_account(card_num,pin_num);
		}
	}
}
public class Atm_machine {

	public static void main(String[] args) {
		int card_num;
		int pin_num;
		int choice,ch,balance=50000;
		String str="";
		String t_history="";
		Login l = new Login();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Automated Teller machine");
		System.out.println("1-Registartion\n2-Exit\nPlease enter your choice: ");
		choice=sc.nextInt();
		if(choice == 1) {
			System.out.println("Enter your card number");
			card_num=sc.nextInt();
			System.out.println("Enter your pin number");
			pin_num=sc.nextInt();
			System.out.println("You have successfully registered.");
			System.out.println("Please Login to your account");
			l.check_account(card_num,pin_num);
			System.out.println("Welcome Back......");
			while(true) {
			System.out.println("1 - WithDraw\n2 - Deposit\n3 - Balance\n4 - Transfer\n5 - Transactions history\n6 - exit\n7 - Please enter your choice");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter the amount you want to withdraw: ");
				int withdraw_amo=sc.nextInt();
				if(balance>=withdraw_amo) {
				balance-=withdraw_amo;
				System.out.println("Successfully debited.");
				t_history+=+withdraw_amo+"rs is debited from your account.\n";
				}
				else {
					System.out.println("Insufficient Balance.");
				}
				break;
			
			case 2:
				System.out.println("Enter the amount you want to deposit: ");
			    int deposit_amo=sc.nextInt();
			    balance+=deposit_amo;
			    System.out.println("Successfully credited.");
			    t_history+=+deposit_amo+"rs is credited to your account\n";
			    break;
			    
			case 3:
				System.out.println("Your current balance is "+balance);
				break;
				
			case 4:
				System.out.println("Enter the amount you want to transfer: ");
				int transfer_amo=sc.nextInt();
				if(balance>=transfer_amo) {
				balance-=transfer_amo;
				System.out.println("Successfully transfered.\n");
				t_history+=+transfer_amo+"rs is transfered from your account\n";
				}
				else {
					System.out.println("Insufficient Balance.");
				}
				break;
				
			case 5:
				System.out.println(t_history);
				break;
				
			case 6:
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Choice. Please enter correct choice.");
				break;
				
			}
			
		}
		}
		else if(choice==2) {
			System.exit(0);;
		}
		else {
			System.out.println("Invalid Input.");
		}

	}

}

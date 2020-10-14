import java.util.Scanner;

public class Budget{

   double balance;
   int account;

  public Budget(int name, double total){
    account = name;
    balance = total;
  }

  public void getBalance(){
    switch(choice){
      case 1:
        System.out.println("Your balance is: $"+balance+" in your Spend account.");
        break;
      case 2: 
        System.out.println("Your balance is: $"+balance+" in your Reserve account.");
        break;
      case 3:
        System.out.println("Your balance is: $"+balance+" in your Savings account.");
        break;
      case 4:
        System.out.println("Your balance is: $"+balance+" in your Investment account.");
        break;
      case 5:
        System.out.println("Goodbye!");
        break;
      default:
        System.out.println("Invalid selection");
    }
  }



  public static void main(String[] args){
    int choice;
    Scanner myScanner = new Scanner(System.in);
    while(choice != 5){
    System.out.println("Each account is associated with a number choose one of the following:\n 1.) Spend\n 2.) Reserve\n 3.) Savings\n 4.) Investment");
    choice = myScanner.nextInt();
    }

  }
}

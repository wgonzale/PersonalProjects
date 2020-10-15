public class BankAccount{

protected int account;
protected String accountName;
protected double balance;

public BankAccount(String accountNamed, double bal){
  accountName = accountNamed;
  balance = bal;
}

public double getBalance(){
    return balance;
}

public double spend(double amount){
  balance -= amount;
  return balance;
}

public double deposit(double amount){
  balance += amount;
  return balance; 
}
public String updateBalance(double bal){
  balance = bal;
  if(accountName.contains("Spend")){
    return ("The updated balance for your Spend account is: $"+balance);
  }
  else if(accountName.contains("Reserve")){
    return ("The updated balance for your Spend account is: $"+balance);
  }
  else if(accountName.contains("Growth")){
    return ("The updated balance for your Growth account is: $"+balance);
  }
  else if(accountName.contains("Stash")){
    return("The updated balance for your Investment account is: $"+balance);
  }
  else
    return "ERROR!";
}


public static void main(String[] args){
  BankAccount spend = new BankAccount("Spend",0.0);
  BankAccount reserve = new BankAccount("Reserve",8.92);
  BankAccount growth = new BankAccount("Growth", 560.00);
  BankAccount stash = new BankAccount("Stash",122.38);
  
  







}

}

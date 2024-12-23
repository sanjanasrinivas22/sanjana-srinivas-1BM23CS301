import java.util.Scanner 
abstract class account{
	String customername,accountnumber;
	double balance;
	account(String customername,String accountnumber,double initialbalance){
		this.customername=customername;
		this.accountnumber=accountnumber;
		this.balance=initialbalance;
	}
	abstract void deposit(double amount);
	abstract void displaybalance();
	abstract void withdraw(double amount);
}

class savacc extends account{
	double interestrate;
	savingsaccount(String customername,String accountnumber,double initialbalance){
		super(customername,accountnumber,initialbalance);
		this.interestrate=interestrate;
	}
	void displaybalance(){
	System.out.println("savings balance:"+balance);
	}
	void deposit(double amount){
	balance+=amount;
	}

	void withdraw(double amount){
		if (amount<=balance){
			balance==amount;
			}
	}

 	void computeanddepositinterest(){
		balance+=balance.interestrate/100;
	}
}
class curacc extends account{
static final double min_balance=1000, service_charge=50;
curacc(String customername,String accountname,double initialbalance){
	super(customername,accountname,initialbalance);
	}

void deposit(double amount){
balance+=amount;
}

void displaybalance(){
System.out.println("current balance:"+balance);
}
void withdraw(double amount){
	if (amount<=balance){
		balance=amount;
		if (balance<min_balance)
			balance-=service_charge;
}}}

class bank{
public static void main(String[] args){
 	scanner sx=new Scanner(System.in);
	System.out.println("enter account type (savings/current)");
	String type= sx.nextLine();
 	System.out.println("enter account name");
	String name= sx.nextLine();
	System.out.println("enter account number");
	String number= sx.nextLine();
account account;
if (type.equals("savings")){
    System.out.println("initial balance and interest rate");
	account= new savacc(name,number,sx.nextDouble(),sx.nextDouble());
     }
else{
	System.out.println("initial balance:");
	account= new curacc(name,number,sx.nextDouble());
}
while(true){
System.out.println("1. deposit 2.display balance 3.withdraw 4. interest 5.exit");
int choice=sx.nextInt();
switch(choice){
	case 1: account.deposit(sx.nextDouble());
		break;
	case 2: account.displaybalance();
		break;
	case 3: account.withdraw(sx.nextDouble());
		break;
	case 4: if(account instance of savacc)
		((savacc) account).computeanddepositinterest();
		break;
	case 5: reurn;
}}}}

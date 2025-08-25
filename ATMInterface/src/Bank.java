import java.util.*;
public class Bank {
	String accname;
	double balance;
	double accnumber;
	void deposit(double amt) {
		this.balance+=amt;
		System.out.println("Deposit Successful  "+ amt);
		}
	void withdraw(double amt) {
		if(this.balance>=amt) {
		   this.balance-=amt;
		   System.out.println("Amt withdrawn  "+ amt);
		}
	}
	void balanceEnq() {
		System.out.println(this.balance);
	}
	     Bank(String accname,double balance,double accnumber) {
		this.accname=accname;
		this.balance=balance;
		this.accnumber=accnumber;
	}
	
public static void main(String[] args) {
	Bank b1=new Bank("HJGHD",87654,8765543);
	System.out.println(b1.accname+" "+b1.balance+" "+b1.accnumber);
	b1.balanceEnq();
	b1.deposit(4500);
	b1.withdraw(600);
		// TODO Auto-generated method stub
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author Philip Ngui
 */
public abstract class BankAccount {

    private String accountNo;
    private Customer owner;
    double balance;

    //constructor for making the bank account
    public BankAccount(String accountNo, Customer owner, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.owner = owner;
    }

    //method for depositing money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Deposited amount must be greater than 0");
        }
    }

    //Abstract method (will be written differenlty for each account type)
    public abstract boolean withdraw(double amount);

    //Method for transferrign money between accounts
    public boolean transfer(BankAccount inAccount, double amount) {
        if (this.withdraw(amount)) {
            inAccount.deposit(amount);
            System.out.println("Transferred $" + amount + " to account " + inAccount.accountNo);
            return true;
        } else {
            System.out.println("Tranfer failed");
            return false;
        }
    }
    //getters

    public String getAccountNo() {
        return accountNo;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    //toString method
    public String toString() {
        return "Account Number: " + accountNo + ", Balance: $" + balance + ", Owner: " + owner.toString();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccountpractice;

/**
 *
 * @author Philip Ngui
 */
public abstract class BankAccount {

    private int accountNo;
    private Customer customer;
    private double balance;

    public BankAccount(int accountNo, Customer customer, double balance) {
        this.accountNo = accountNo;
        this.customer = customer;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be a postive value");
        } else {
            System.out.println("Deposited " + amount + "to " + accountNo);
        }
    }

    public abstract boolean withdraw(double amount);
    
    public boolean transfer(BankAccount inAccount, double amount){
        
    }


}

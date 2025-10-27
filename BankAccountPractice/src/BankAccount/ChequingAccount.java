/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author Philip Ngui
 */
public class ChequingAccount extends BankAccount {

    private double overdraftPenalty;
    private double overdraftLimit;

    //Constructor for making the chequing account
    public ChequingAccount(String accountNo, Customer owner, double balance, double overdraftLimit, double par2) {
        super(accountNo, owner, balance);
        this.overdraftPenalty = overdraftPenalty;
        this.overdraftLimit = overdraftLimit;
    }

    //withdraw method 
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0");
            return false;
        }
        double newBalance = balance - amount;
        //when the balance goes below zero, apply a penalty
        if (newBalance < 0) {
            newBalance -= overdraftPenalty;
        }
        //If we go past the overdraft limit, reject the transaction
        if (newBalance < overdraftLimit) {
            System.out.println("Withdrawal failed... Overdraft limit exceeded");
            return false;
        }

        balance = newBalance;
        System.out.println("Withdrawal successful. New balance: $" + balance);
        return true;
    }
}

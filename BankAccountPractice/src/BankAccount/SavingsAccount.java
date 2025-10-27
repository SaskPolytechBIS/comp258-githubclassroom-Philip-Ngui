/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author Philip Ngui
 */
public class SavingsAccount extends BankAccount {

    private double minBalance;          // Minimum required balance
    private int transactionCount;       // How many times below min balance
    private static double ACTIVITY_PENALTY = 10.0; // Constant penalty fee
    private static int ACTIVITY_LIMIT = 3;          // Allowed below-min withdrawals before penalty

    // Constructor to make the savings account
    public SavingsAccount(String accountNo, Customer owner, double balance, double par1) {
        super(accountNo, owner, balance);
        this.minBalance = minBalance;
        this.transactionCount = 0;
    }

    // Override abstract method from BankAccount
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than $0");
            return false;
        }

        // Check: cannot go below zero
        if (balance - amount < 0) {
            System.out.println("Withdrawal failed... Cannot overdraw savings account");
            return false;
        }

        // Check if balance is below minimum
        if (balance < minBalance) {
            transactionCount++;
            System.out.println("Warning: Below minimum balance. Withdrawal #" + transactionCount);
        }

        // Apply penalty if too many below-min withdrawals
        if (transactionCount > ACTIVITY_LIMIT) {
            if (balance - amount - ACTIVITY_PENALTY < 0) {
                System.out.println("Withdrawal failed... penalty would overdraw account.");
                transactionCount--; // undo count
                return false;
            }
            balance -= ACTIVITY_PENALTY;
            System.out.println("Penalty fee of $" + ACTIVITY_PENALTY + " applied.");
        }

        // Normal withdrawal
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: $" + balance);
        return true;
    }
}

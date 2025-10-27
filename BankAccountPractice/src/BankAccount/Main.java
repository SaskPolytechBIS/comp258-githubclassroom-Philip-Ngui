/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BankAccount;

/**
 *
 * @author Philip Ngui
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Customer cust1 = new Customer("C001", "Philip", 'A', "Ngui");

        // Create accounts for the customer
        ChequingAccount cheq = new ChequingAccount("CH001", cust1, 100.0, 25.0, -500.0);
        SavingsAccount sav = new SavingsAccount("SV001", cust1, 500.0, 100.0);

        System.out.println("-Staring Balance-");
        System.out.println(cheq);
        System.out.println(sav);

        System.out.println("-Transaction-");
        cheq.withdraw(150);
        sav.withdraw(450);
        sav.withdraw(20);
        cheq.transfer(sav, 50);

        System.out.println("-Final Balance");
        System.out.println(cheq);
        System.out.println(sav);
    }

}

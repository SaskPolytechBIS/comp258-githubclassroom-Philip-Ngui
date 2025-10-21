/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccountpractice;

/**
 *
 * @author Philip Ngui
 */
public class Customer extends Person {

    private int customerId;

    public Customer(String firstName, char middleInitial, String lastName, int customerId) {
        super(firstName, middleInitial, lastName);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String toString() {
        return super.toString() + " (ID: " + customerId + ")";
    }
}
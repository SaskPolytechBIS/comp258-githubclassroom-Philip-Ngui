/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author Philip Ngui
 */
public class Customer extends Person {

    private String customerId;

    //Constructor that uses super to call person constructor
    public Customer(String customerId, String firstName, char middleInitial, String lastName) {
        super(firstName, middleInitial, lastName);
        this.customerId = customerId;
    }

    //getter for getting customer id
    public String getCustomerId() {
        return customerId;
    }

    //prints customer id and full name
    public String toString() {
        return "Customer Id: " + customerId + ", Name " + super.toString();
    }

}

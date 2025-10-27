/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author Philip Ngui
 */
public class Person {

    private String firstName;
    private String lastName;
    private char middleInitial;

    //Constructor for creating a new person object
    public Person(String firstName, char middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }
    //Getters that allows other class to access private fields

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    //method for returning the person's full name as a text
    public String toString() {
        return firstName + " " + middleInitial + " " + lastName;
    }

}

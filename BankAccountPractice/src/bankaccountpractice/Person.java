/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccountpractice;

/**
 *
 * @author Philip Ngui
 */
public abstract class Person {

    private String firstName;
    private String lastName;
    private char middleInit;

    public Person(String firstName, char middleInit, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = middleInit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getMiddleInit() {
        return middleInit;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleInit(char middleInit) {
        this.middleInit = middleInit;
    }

    public String fullName() {
        return firstName + " " + middleInit + " " + lastName;
    }

}

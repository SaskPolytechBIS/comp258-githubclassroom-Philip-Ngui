/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp258maindriver;

import recursivefunctions.RecursiveFunctions;
import linkedlist.LinkedList;
import linkedlist.Widget;
import java.util.Scanner;

/**
 *
 * @author Philip Ngui
 */
public class COMP258MainDriver {

    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here added comment

        madeInBranch();
        madeInTrunk();
        
        showMainMenu();

    }

    public static void madeInBranch() {
        System.out.println("This code was changed in a branch");
    }

    public static void madeInTrunk() {
        System.out.println("This code was made in the main Branch");
    }
    
    private static void showMainMenu() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n=== COMP258 Main Menu ===");
            System.out.println("1. Manage data with ArrayManager");
            System.out.println("2. Manage data with LinkedList");
            System.out.println("3. Manage data with GenericLinkedList");
            System.out.println("4. Showcase recursive functions");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    // ArrayManager functionality (to be implemented)
                    System.out.println("ArrayManager not yet implemented");
                    break;
                case 2:
                    // LinkedList functionality (to be implemented)
                    System.out.println("LinkedList management not yet implemented");
                    break;
                case 3:
                    // GenericLinkedList functionality (to be implemented)
                    System.out.println("GenericLinkedList not yet implemented");
                    break;
                case 4:
                    showcaseRecursiveFunctions();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void showcaseRecursiveFunctions() {
        RecursiveFunctions rf = new RecursiveFunctions();
        LinkedList ll = createTestLinkedList();
        boolean exitSubMenu = false;
        
        while (!exitSubMenu) {
            System.out.println("\n=== Recursive Functions Menu ===");
            System.out.println("1. Calculate factorial");
            System.out.println("2. Calculate powers");
            System.out.println("3. Check if a word is a palindrome");
            System.out.println("4. Check if a number is in Fibonacci sequence");
            System.out.println("5. Run Indent-o-tron");
            System.out.println("6. Print linked list with recursion");
            System.out.println("7. Print linked list backwards with recursion");
            System.out.println("8. Exit to main menu");
            System.out.print("Select an option: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    calculateFactorial(rf);
                    break;
                    
                case 2:
                    calculatePower(rf);
                    break;
                    
                case 3:
                    checkPalindrome(rf);
                    break;
                    
                case 4:
                    checkFibonacci(rf);
                    break;
                    
                case 5:
                    runIndentoTron(rf);
                    break;
                    
                case 6:
                    ll.printListForwards();
                    break;
                    
                case 7:
                    ll.printListBackwards();
                    break;
                    
                case 8:
                    exitSubMenu = true;
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void calculateFactorial(RecursiveFunctions rf) {
        System.out.print("Enter a number to calculate factorial: ");
        int num = getIntInput();
        try {
            int result = rf.factorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void calculatePower(RecursiveFunctions rf) {
        System.out.print("Enter base: ");
        int base = getIntInput();
        System.out.print("Enter exponent: ");
        int exponent = getIntInput();
        try {
            int result = rf.calculatePower(base, exponent);
            System.out.println(base + "^" + exponent + " = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void checkPalindrome(RecursiveFunctions rf) {
        System.out.print("Enter a word to check for palindrome: ");
        String word = scanner.nextLine();
        boolean isPal = rf.isPalindrome(word);
        System.out.println("'" + word + "' is " + (isPal ? "" : "not ") + "a palindrome");
    }
    
    private static void checkFibonacci(RecursiveFunctions rf) {
        System.out.print("Enter a number to check if it's in Fibonacci sequence: ");
        int num = getIntInput();
        boolean isFib = rf.isFibonacci(num);
        System.out.println(num + " is " + (isFib ? "" : "not ") + "in the Fibonacci sequence");
    }
    
    private static void runIndentoTron(RecursiveFunctions rf) {
        System.out.print("Enter max number for Indent-o-tron: ");
        int maxNum = getIntInput();
        rf.indentoTron(maxNum);
    }
    
    private static LinkedList createTestLinkedList() {
        LinkedList ll = new LinkedList();
        ll.add(new Widget(1001, "Screw", 900));
        ll.add(new Widget(1002, "Bolt", 300));
        ll.add(new Widget(1003, "Cat", 9));
        ll.add(new Widget(1004, "Dog", 15));
        return ll;
    }
    
    private static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
}
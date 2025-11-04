/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp258maindriver;

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
        boolean exitSubMenu = false;

        while (!exitSubMenu) {
            System.out.println("\n=== Recursive Functions Menu ===");
            System.out.println("1. Calculate factorial");
            System.out.println("2. Calculate powers");
            System.out.println("3. Check if a word is a palindrome");
            System.out.println("4. Check if a number is in Fibonacci sequence");
            System.out.println("5. Run Indent-o-tron");
            System.out.println("6. Exit to main menu");
            System.out.print("Select an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    calculateFactorial();
                    break;

                case 2:
                    calculatePower();
                    break;

                case 3:
                    checkPalindrome();
                    break;

                case 4:
                    checkFibonacci();
                    break;

                case 5:
                    runIndentoTron();
                    break;

                case 6:
                    exitSubMenu = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // ========== RECURSIVE METHODS ==========
    
    // 1. Factorial
    private static void calculateFactorial() {
        System.out.print("Enter a number to calculate factorial: ");
        int num = getIntInput();
        try {
            int result = factorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // 2. Calculate Power
    private static void calculatePower() {
        System.out.print("Enter base: ");
        int base = getIntInput();
        System.out.print("Enter exponent: ");
        int exponent = getIntInput();
        try {
            int result = calculatePowerRecursive(base, exponent);
            System.out.println(base + "^" + exponent + " = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static int calculatePowerRecursive(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }
        if (exponent == 0) {
            return 1;
        }
        return base * calculatePowerRecursive(base, exponent - 1);
    }
    
    // 3. Palindrome Check
    private static void checkPalindrome() {
        System.out.print("Enter a word to check for palindrome: ");
        scanner.nextLine(); // Clear buffer
        String word = scanner.nextLine();
        boolean isPal = isPalindrome(word);
        System.out.println("'" + word + "' is " + (isPal ? "" : "not ") + "a palindrome");
    }
    
    private static boolean isPalindrome(String word) {
        // Wrapper function
        if (word == null || word.isEmpty()) {
            return true;
        }
        return isPalindromeRecursive(word, 0, word.length() - 1);
    }
    
    private static boolean isPalindromeRecursive(String word, int start, int end) {
        // Recursive version
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(word, start + 1, end - 1);
    }
    
    // 4. Fibonacci Check
    private static void checkFibonacci() {
        System.out.print("Enter a number to check if it's in Fibonacci sequence: ");
        int num = getIntInput();
        boolean isFib = isFibonacci(num);
        System.out.println(num + " is " + (isFib ? "" : "not ") + "in the Fibonacci sequence");
    }
    
    private static boolean isFibonacci(int numToFind) {
        // Wrapper function
        return isFibonacciHelper(numToFind, 0, 1);
    }
    
    private static boolean isFibonacciHelper(int numToFind, int a, int b) {
        if (a == numToFind) {
            return true;
        }
        if (a > numToFind) {
            return false;
        }
        return isFibonacciHelper(numToFind, b, a + b);
    }
    
    // 5. Indent-o-tron
    private static void runIndentoTron() {
        System.out.print("Enter max number for Indent-o-tron: ");
        int maxNum = getIntInput();
        indentoTronWrapper(maxNum);
    }
    
    private static void indentoTronWrapper(int maxNum) {
        // Wrapper function
        indentoTronRecursive(1, maxNum);
    }
    
    private static void indentoTronRecursive(int currentNum, int maxNum) {
        if (currentNum > maxNum) {
            return;
        }
        
        // Print on the way up
        System.out.println("This was written by call number " + currentNum + ".");
        
        // Recursive call
        indentoTronRecursive(currentNum + 1, maxNum);
        
        // Print on the way down
        System.out.println("This ALSO written by call number " + currentNum + ".");
    }
    
    // ========== HELPER METHODS ==========
    
    private static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
}
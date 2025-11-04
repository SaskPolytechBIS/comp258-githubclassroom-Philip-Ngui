/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author Philip Ngui
 */

public class RecursiveFunctions {
    
    // 1. Factorial method
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // 2. Calculate power method
    public int calculatePower(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }
        if (exponent == 0) {
            return 1;
        }
        return base * calculatePower(base, exponent - 1);
    }
    
    // 3. Palindrome methods
    public boolean isPalindrome(String word) {
        // Wrapper function
        if (word == null || word.isEmpty()) {
            return true;
        }
        return isPalindrome(word, 0, word.length() - 1);
    }
    
    private boolean isPalindrome(String word, int start, int end) {
        // Recursive version
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, start + 1, end - 1);
    }
    
    // 4. Fibonacci methods
    public boolean isFibonacci(int numToFind) {
        // Wrapper function
        return isFibonacciHelper(numToFind, 0, 1);
    }
    
    public boolean isFibonacci(int numToFind, int currentFibNum) {
        // Required signature - uses helper method
        return isFibonacciHelper(numToFind, 0, 1);
    }
    
    private boolean isFibonacciHelper(int numToFind, int a, int b) {
        if (a == numToFind) {
            return true;
        }
        if (a > numToFind) {
            return false;
        }
        return isFibonacciHelper(numToFind, b, a + b);
    }
    
    // 5. Indent-o-tron methods
    public void indentoTron(int maxNum) {
        // Wrapper function
        indentoTron(1, maxNum);
    }
    
    public void indentoTron(int currentNum, int maxNum) {
        if (currentNum > maxNum) {
            return;
        }
        
        // Print on the way up
        System.out.println("This was written by call number " + currentNum + ".");
        
        // Recursive call
        indentoTron(currentNum + 1, maxNum);
        
        // Print on the way down
        System.out.println("This ALSO written by call number " + currentNum + ".");
    }
}
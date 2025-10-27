/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraymanager;

/**
 *
 * @author Philip Ngui
 */
public class ArrayManager {

    private int[] items; // array storing the data
    private int size;    // number of items currently held in the array

    // Default constructor - set the array to size 10 by default
    public ArrayManager() {
        items = new int[10];
        size = 0;
    }

    // Constructor with specified size
    public ArrayManager(int size) {
        if (size <= 0) {
            size = 10; // default if invalid
        }
        items = new int[size];
        this.size = 0;
    }

    // Accepts and manages an existing array
    public ArrayManager(int[] items) {
        this.items = items;
        size = items.length;
    }

    public int getSize() {
        return size;
    }

    // Returns true if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Prints all elements currently stored in the array
    public void printArray() {
        if (isEmpty()) {
            System.out.println("(Array is empty)");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "]: " + items[i]);
        }
    }

    // Returns a new array with only the filled elements
    public int[] toArray() {
        int[] arrayToReturn = new int[size];

        for (int i = 0; i < size; i++) {
            arrayToReturn[i] = items[i];
        }
        return arrayToReturn;
    }

    // Returns the element at the specified index
    public int get(int i) throws NoItemsException {
        if (i < 0 || i >= size) {
            throw new NoItemsException("Could not get data. Index " + i + " is out of bounds for array of size " + size);
        }
        return items[i];
    }

    // Replaces the data array with a larger array that keeps all the same data
    private void resizeArray() {
        int[] newArray = new int[items.length + 10];

        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }

        items = newArray;
    }

    // Adds an item to the end of the array
    public void add(int newItem) {
        // Check if array is full and resize if needed
        if (size == items.length) {
            resizeArray();
        }

        // Add item to array
        items[size] = newItem;
        size++; // increase count
    }

    // Removes the item at the specified index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index: " + index);
            return;
        }

        // Shift all elements left by one
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        size--; // decrease count
    }

    // Adds an item at the specified index
    public void addAt(int newItem, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index: " + index);
            return;
        }

        // Resize if full
        if (size == items.length) {
            resizeArray();
        }

        // Shift items to the right
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = newItem;
        size++; // increase count
    }

    // Main method for quick testing
    public static void main(String[] args) {
        ArrayManager am = new ArrayManager();

        System.out.println("Adding items into the array...");
        am.add(1);
        am.add(2);
        am.add(3);

        am.printArray();

        System.out.println("\nAdding at index 1:");
        am.addAt(99, 1);
        am.printArray();

        System.out.println("\nRemoving index 2:");
        am.remove(2);
        am.printArray();

        try {
            System.out.println("\nTesting get(): Item at index 1 is " + am.get(1));
        } catch (NoItemsException e) {
            e.printStackTrace();
        }
    }
}
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

    //The array that will be storing the actual data
    private int[] items;
    //The number of items currently held in the array
    private int size;

    //Default Constructor - Sets the array to size 10 by default
    public ArrayManager() {
        //Makes the items array with capacity for 10 integers
        items = new int[10];
        //Sets the size to 0 since the array starts empty
        size = 0;
    }

    // Constructor with specified size
    public ArrayManager(int size) {
        //Validates the input size
        if (size <= 0) {
            // default if invalid (0 or negative), then makes it a default of 10
            size = 10;
        }
        //Creates the items  array with the default/specified capacity
        items = new int[size];
        //Initializes the size to 0 (array starts out empty)
        this.size = 0;
    }

    //Accepts and manages an existing array
    public ArrayManager(int[] items) {
        //Assigns the provided array reference to this.items field
        this.items = items;
        //Sets size to the length of the array
        size = items.length;
    }

    //Getter for current size of array
    public int getSize() {
        //Returns the value/size
        return size;
    }

    //Checks if the array is empty
    public boolean isEmpty() {
        //Returns true if the array is empty
        return size == 0;
    }

    //Prints all elements currently stored in the array
    public void printArray() {
        //Firsts check if the array is empty
        if (isEmpty()) {
            //Prints message if array is empty
            System.out.println("(Array is empty)");
            return;
        }
        //Loops though from 0 to size -1
        for (int i = 0; i < size; i++) {
            //Prints it out index of items
            System.out.println("[" + i + "]: " + items[i]);
        }
    }

    //Returns a new array with only the filled elements
    public int[] toArray() {
        //Creates a new array with the exact size of the current number of index's
        int[] arrayToReturn = new int[size];
        //Copies each from the internal array to the new array
        for (int i = 0; i < size; i++) {
            arrayToReturn[i] = items[i];
        }
        //Returns new array contatining only the used elements
        return arrayToReturn;
    }

    //Returns the element at the specified index
    public int get(int index) throws NoItemsException {
        //Validates if the index is within range (0 to size -0)
        if (index < 0 || index >= size) {
            //if the index is invalid, shows a message
            throw new NoItemsException("Could not get data. Index " + index + " is out of bounds for array of size " + size);
        }
        //Returns elements at the valid index position
        return items[index];
    }

    //Replaces the data array with a larger array that keeps all the same data
    private void resizeArray() {
        //Creates a new array with capacity increasing by 10
        int[] newArray = new int[items.length + 10];
        //Copies existing elements from old array to the new array
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        //Replaces old arreay with new larger array
        items = newArray;
    }

    //Adds an item to the end of the array
    public void add(int newItem) {
        // Check if array is full and resize if needed
        if (size == items.length) {
            resizeArray();
        }

        //Add item to array
        items[size] = newItem;
        //increase count
        size++;
    }

    //Removes the item at the specified index
    public void remove(int index) {
        //Validates index
        if (index < 0 || index >= size) {
            //Prints message if invalid
            System.out.println("Invalid index: " + index);
            return;
        }

        // Shift all elements left by one
        for (int i = index; i < size - 1; i++) {
            //Moves each element one positon to the left
            items[i] = items[i + 1];
        }
        //Decrease count
        size--;
    }

    //Adds an item at the specified index
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
        //Insert new itam at specified index
        items[index] = newItem;
        //increase count
        size++;
    }

    ///////////////////////////////
    //Main method for quick testing
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

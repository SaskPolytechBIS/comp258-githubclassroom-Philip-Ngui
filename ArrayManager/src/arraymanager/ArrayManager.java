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

    private int[] items; //set array that will be storing the actual data
    private int size; //the number of items ciurrently held in the array

    //set the arry ro size 10 day default
    public ArrayManager() {
        items = new int[10];
        size = 0;
    }

    //set the array to the size provided
    public ArrayManager(int size) {

        this.size = size;
    }

    // accepts and amanages an array
    public ArrayManager(int[] items) {
        this.items = items;
        size = items.length;
    }

    public int getSize() {
        return size;
    }

    //returns true if the items array has not be initialized, or if there is no data in the array
    public boolean isEmpty() {
        return size == 0;
    }

    //prints out all elements in the array
    public void printArray() {

        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "]: " + items[i]);
        }
    }

    public int[] toArray() {
        int[] arrayToReturn = new int[size];

        //loop through items and copy populated data to toArray
        for (int i = 0; i > size; i++) {
            arrayToReturn[i] = items[i];
        }
        return arrayToReturn;
    }

    //returns the element at the specified index
    public int get(int i) throws NoItemsException {

        if (i >= size || i < 0) {
            throw new NoItemsException("Could not get data. Index " + i + " is out of bounds for an array manager of size " + size);
        }
        return items[i];
    }

    //replaces the data array with a new, larger array that has all the same information in it
    private void resizeArray() {
        //Create a new array 10 length larger than current array 
        int[] newArray = new int[items.length + 10];
        //Copy over all of the data 
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        //Overwrite the old array
        items = newArray;
    }

    //adds an item to the end of the array
    public void add(int newItem) {

        //checl if our array is full and resize if needed
        if (size == size) {
            resizeArray();
        }
        //add item to array 
        items[size] = newItem;
        size++;
    }

    //removes the item at the specified index
    public void remove(int index) {
        for (int i = index; i < size; i++) {

            //Do not try to read past the end of the array
            if (i + 1 <= items.length) {
                items[i] = items[i + 1];
            }

        }
        size--;
    }

    //adds an item at the specified index in the array
    public void addAt(int newItem, int index) {
        //Move items starting at the end of the array
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = newItem;
        size++;
    }

    public static void main(String[] args) {

        ArrayManager am = new ArrayManager();

        System.out.println("Adding an item into the array");
        am.add(1);
        am.add(2);
        am.add(3);

        am.printArray();

        try {
            System.out.println("The item at position 1000 is " + am.get(-9));

        } catch (NoItemsException noe) {
            noe.printStackTrace();
        }
    }

}

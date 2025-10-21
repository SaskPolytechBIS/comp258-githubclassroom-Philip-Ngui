/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package glinkedlist;

import OtherCode.GenericData;

/**
 *
 * @author Philip Ngui
 */
public class GLinkedList<T extends Comparable> {

    private GListNode<T> items; // Contains the first node in the list
    private GListNode<T> current; // The node of the list that is currently selected 
    private int size; // Contains the number of items in the linked list

    public int getSize() {
        return size;
    }

    // Sets current to the first item in the list
    public void start() {
        current = items;
    }

    // Advances current to the next item in the list
    public void advance() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("There is no next item to advance current to");
        }
    }

    // Convert list to array
    public T[] toArray() {
        //make an array large enough to hold all the data in the list
        T[] arrayToReturn = (T[]) new Object[size];

        //populate the array with the data from the list 
        GListNode<T> parser = items;
        int i = 0;

        while (parser != null) {
            //copy the data
            arrayToReturn[i] = parser.getData();
            i++;

            //move parser to the next node
            parser = parser.next;
        }
        //return the array
        return arrayToReturn;

    }

    // Return data that is in the current node
    public T getCurrent() {
        return current.getData();
    }

    // Add a new node at the end of the list
    public void add(T nodeData) {
        GListNode newNode = new GListNode(nodeData);

        if (size == 0) {
            items = newNode;
            current = newNode;
        } else {
            current.next = newNode;
            current = newNode;
        }

        size++;
    }

    public void remove() {

        if (current == items) {
            items = items.next;
            current = items;
        } else {
            //find the previousNode
            GListNode parser = items;
            GListNode previousNode = new GListNode(null);

            while (parser != null) {
                if (parser.next == current) {
                    previousNode = parser;
                }
                parser = parser.next;
            }
            //change its pointer from the current
            previousNode.next = current.next;

            //set current to previousNode;
            current = previousNode;
        }
        size--;
    }

    // Add a new node after the current node
    public void addAfter(Comparable nodeData) {
        GListNode newNode = new GListNode(nodeData);

        if (size == 0) {
            items = newNode;
            current = newNode;
        } else {
            GListNode nextNode = current == null ? null : current.next;
            if (current != null) {
                current.next = newNode;
            }
            newNode.next = nextNode;
            current = newNode;
        }

        size++;
    }

    // Print all items in the list
    public void printList() {
        if (size == 0) {
            System.out.println("The list is empty.");
            return;
        }

        GListNode parser = items;
        System.out.println("Printing all items in the list:");
        while (parser != null) {
            System.out.println(parser.getData());
            parser = parser.next;
        }
    }

    public void addBefore(Comparable nodeData) {
        //create a new node
        GListNode newNode = new GListNode(nodeData);
        //is current the first item in the list
        if (current == items) {
            //point the new node at current
            newNode.next = current;

            //update items to set newNode as the first node in the list
            items = newNode;

        } else {
            //point the new node at current 
            newNode.next = current;

            //parse through the previous node
            GListNode parser = items;
            GListNode previousNode = new GListNode(null);

            while (parser != null) {
                if (parser.next == current) {
                    previousNode = parser;

                }

                //move parser to the next node in the list
                parser = parser.next;
            }

            //point previousNode at the new node
            previousNode.next = newNode;
        }

        size++;
    }

    // Main method for testing
    public static void main(String[] args) {
        GLinkedList<Integer> genIntList = new GLinkedList<Integer>();
        GLinkedList<String> genStringList = new GLinkedList<String>();

        genIntList.add(111);
        genStringList.add("Two");

    }
}

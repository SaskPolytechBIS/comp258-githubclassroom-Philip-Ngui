/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author Philip Ngui
 */
public class LinkedList {

    private ListNode items; //Contains the first node in the list
    private ListNode current; //for the momen this will always be the last node
    private int size; //contains the number of items in the linked list

    public int getSize() {
        return size;
    }

    // add a new node at the end of the list with nodeData as its data
    public void add(Object nodeData) {
        ListNode newNode = new ListNode(nodeData);

        //add newNode ad the first item in the list
        if (size == 0) {

            //add newNode ad the first item in the lisit
            items = newNode;
            current = newNode;

        } else {
            items.next = newNode;
            current = newNode;

        }

        //Increase the size of the list
        size++;
    }

    // print all items in the lis
    public void printlist() {
        if (size > 0) {
            System.out.println(items.getData());
            if (items.next != null) {
                System.out.println(current.getData());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println("The size of the linked list is" + ll.getSize());

        System.out.println("Adding an item to the list");
        ll.add("a");
        ll.add("b");
        System.out.println("The size of the linked list is " + ll.getSize());
        System.out.println("Printing out the content of the list");
        ll.printlist();
    }

}

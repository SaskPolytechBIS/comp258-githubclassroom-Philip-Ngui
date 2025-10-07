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
    private ListNode current; //The node of the list that is currently selected 
    private int size; //contains the number of items in the linked list

    public int getSize() {
        return size;
    }

    //sets current to the first item in the list
    public void start() {
        current = items;
    }

    //advances current to the next item in the list
    public void advance() {
        if (current != null && current.next != null) {
            //advance current
            current = current.next;
        } else {
            System.out.println("There is no next item to advance current to");
        }
    }

    //return data that is in the current node
    public Object getCurrent() {

        return current.getData();
    }

    // add a new node at the end of the list with nodeData as its data
    public void add(Object nodeData) {
        ListNode newNode = new ListNode(nodeData);

        //add newNode as the first item in the list
        if (size == 0) {
            items = newNode;
            current = newNode;
        } else {
            //link the new node to the end of the list
            current.next = newNode;
            current = newNode;

        }

        //Increase the size of the list
        size++;
    }

    //inserts an item into the list after current
    public void addAfter(Object nodeData) {
        ListNode newNode = new ListNode(nodeData);

        if (size == 0) {
            // If list is empty, just make this the first node
            items = newNode;
            current = newNode;
        } else {
            //save nextNode so it doesn’t get lost
            ListNode nextNode = current.next;

            //link the new node after current
            current.next = newNode;
            newNode.next = nextNode;

            //move current to the new node
            current = newNode;
        }

        //Increase the size of the list
        size++;
    }

    // print all items in the list
    public void printList() {

        //check if the list is empty
        if (size == 0) {
            System.out.println("The list is empty.");
            return;
        }

        //loop through all items
        ListNode parser = items;

        System.out.println("Printing all items in the list:");
        while (parser != null) {
            System.out.println(parser.getData());
            parser = parser.next;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        //add data using add()
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");

        System.out.println("Printing initial list:");
        ll.printList();

        ll.start(); // move to 'a'
        ll.advance(); // move to 'b'
        ll.addAfter(1);
        ll.addAfter(2);
        ll.addAfter(3);

        System.out.println("Printing list");
        ll.printList();
    }
}

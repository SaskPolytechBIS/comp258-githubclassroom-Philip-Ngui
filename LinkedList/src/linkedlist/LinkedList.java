package linkedlist;

/**
 *
 * @author Philip Ngui
 */
public class LinkedList {

    private ListNode items; // Contains the first node in the list
    private ListNode current; // The node of the list that is currently selected 
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

    // Return data that is in the current node
    public Comparable getCurrent() {
        return current.getData();
    }

    // Add a new node at the end of the list
    public void add(Comparable nodeData) {
        ListNode newNode = new ListNode(nodeData);

        if (size == 0) {
            items = newNode;
            current = newNode;
        } else {
            current.next = newNode;
            current = newNode;
        }

        size++;
    }

    // Add a new node after the current node
    public void addAfter(Comparable nodeData) {
        ListNode newNode = new ListNode(nodeData);

        if (size == 0) {
            items = newNode;
            current = newNode;
        } else {
            ListNode nextNode = current == null ? null : current.next;
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

        ListNode parser = items;
        System.out.println("Printing all items in the list:");
        while (parser != null) {
            System.out.println(parser.getData());
            parser = parser.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        Widget w1 = new Widget(1001, "Screw", 900);
        Widget w2 = new Widget(1002, "Bolt", 300);
        Widget w3 = new Widget(1003, "Cat", 9);

        ll.addAfter(w1);
        ll.addAfter(w2);
        ll.addAfter(w3);

        ll.printList();
        ll.start();

        if (w2.compareTo(w1) > 0) {
            System.out.println(w2 + " is larger than " + w1);
        } else if (w2.compareTo(w1) == 0) {
            System.out.println(w2 + " is equal to " + w1);
        } else {
            System.out.println(w2 + " is smaller than " + w1);
        }
    }
        // Add these methods to your existing LinkedList class:
    
    // Recursive print forwards method
    public void printListForwards() {
        if (size == 0) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Printing list forwards (recursive):");
        printListForwardsRecursive(items);
    }
    
    private void printListForwardsRecursive(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        printListForwardsRecursive(node.next);
    }
    
    // Recursive print backwards method
    public void printListBackwards() {
        if (size == 0) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Printing list backwards (recursive):");
        printListBackwardsRecursive(items);
        System.out.println(); // New line for better formatting
    }
    
    private void printListBackwardsRecursive(ListNode node) {
        if (node == null) {
            return;
        }
        // First go to the end, then print on the way back
        printListBackwardsRecursive(node.next);
        System.out.println(node.getData());
    }
}

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
public class GLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenericData<Integer> gInt1 = new GenericData<Integer>(11);
        GenericData<Integer> gInt2 = new GenericData<Integer>(22);

        GenericData<String> genString = new GenericData<String>("Test");
        
        int total = gInt1.getData() + gInt2.getData();
        
    }

}

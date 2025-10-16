/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glinkedlist;

/**
 *
 * @author Philip Ngui
 */
public class GListNode<T extends Comparable> {

    private T data;
    public GListNode<T> next;

    public GListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

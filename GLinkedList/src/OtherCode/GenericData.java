package OtherCode;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Philip Ngui
 */
//Can define multiple data types :
//Example: GenericData<A, B, C, D> // GenericData <String, Double>
public class GenericData<T> {

    private T data;

    public GenericData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

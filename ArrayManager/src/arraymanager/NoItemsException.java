/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymanager;

/**
 *
 * @author Philip Ngui
 */
public class NoItemsException extends Exception {

    //Generic message
    public NoItemsException() {
        super("There are no items to perform this operation");
    }

    //Accepts a custom error message
    public NoItemsException(String errorMessage) {
        super(errorMessage);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code1;

/**
 *
 * @author carlo
 */
public class Address {
    
    String state;
    Address(String A)
    {
        state = A;
    }
    
    String getAddress()
    {
        return state;
    }
}

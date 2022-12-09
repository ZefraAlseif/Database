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
public class Manufacturer {
    private Name name;
    private Address state;
    
    public Manufacturer(Name n,Address s)
    {
        name = n;
        state = s ;
    }
    
    public Name getName()
    {
        return name;
    }
    
    public Address getAddress()
    {
        return state;
    }
}

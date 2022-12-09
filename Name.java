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
public class Name {
    String companyName;
    String item;
    Name(String N, String I)
    {
        companyName = N;
        item = I;
    }
    
    String getName()
    {
        return companyName;
    }
    
    String getItemName()
    {
        return item;
    }
    
    
}

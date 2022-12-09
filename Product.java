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
public class Product {
    
    private final Manufacturer manufacturer;
    private final Name item;
    private int quantity;
    private double price;
    
    public Product(Manufacturer M,Name I, int Q, double P)
    {
        manufacturer = M;
        item = I;
        quantity = Q;
        price = P;
    }
    
    public Manufacturer getManufacturer()
    {
        return manufacturer;
    }
    
    public Name getItem()
    {
        return item;
    }
    public void changeQuantity(int X)
    {
        this.quantity = X;
    }
    
    public void changePrice(double X)
    {
        this.price = X;
    }
            
    public int getQuantity()
    {
        return quantity;
    }
    public double getPrice()
    {
        return price;
    }
    
   
    
   
}


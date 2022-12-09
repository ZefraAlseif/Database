/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code1;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Database {
    
    ArrayList<Product> list;
    Product pa;
    int index;
    boolean found;

   Database()
{
        list = new ArrayList<Product>();
}
 
   void add(Product p)
   {
       list.add(p);
   }
   
   Product delete(int i)
   {
       return list.remove(i);
   }
   
   int getSize()
   {
       return list.size();
   }
   
   boolean isEmpty()
   {
       return list.isEmpty();
   }
   
   void search (String findM, String findI)
   {
       found = false;
       int i = 0;
       
       while (!found && i < list.size())
       {
           Product p = list.get(i);
           
           if (p.getManufacturer().getName().getName().equalsIgnoreCase(findM) && p.getManufacturer().getName().getItemName().equalsIgnoreCase(findI))     
           {
               pa = p ;
               found = true;
               index = i;
           }
           else
               i++;
       }
   }
   
   ArrayList getList()
   {
       return list;
   }
   
   boolean inList()
   {
       return found;
   }
   
   Product getProduct()
   {
       return pa;
   }
   
   public int getIndex()
   {
       return index;
   }
   
   }
 
   

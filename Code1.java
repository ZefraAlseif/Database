/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code1;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author carlo
 */
public class Code1 {

    /**
     * @param args the command line arguments
     */
    // Format for Decimal Output
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
    // Display the Info in JScroll
    static void display(String info, String heading, int MESSAGE_TYPE)
    {
        
         JTextArea text = new JTextArea(info,20, 30);
         
         JScrollPane pane = new JScrollPane(text);
         JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
         
      
        }   

    public static void main(String[] args) {
      
         Database db = new Database(); //Creating database for active accounts 
         Database dc = new Database(); //Creating database for inactive accounts
         DateFormat Df = DateFormat.getDateInstance(DateFormat.LONG);
         String dateP = "None"; //Date Purchased
         String dateC = "None"; //Date Closed
         Date now = new Date();
         boolean done = false;
         while (!done)
         {
         String option = JOptionPane.showInputDialog("ABC Enterprise\n"+"\t"+Df.format(now)+"\n"+"\nA: Add Product \nB: Update Product \nC: Delete Product \nD: Reports");
         switch (option){
           
           //Adding a product to the database 
             case "A":
          
           // Company Name and Item Name    
           String nameM =  JOptionPane.showInputDialog("Enter the name of the Manufacturer");
           String nameI = JOptionPane.showInputDialog("Enter the name of the item");
           Name n = new Name(nameM,nameI);
           
           // Location where it was made (State)
           String address = JOptionPane.showInputDialog("Enter the initials of the State where the Manufacturer is located");
           Address a = new Address(address);
           
           // Quantity and Price
           String q = JOptionPane.showInputDialog("Enter the amount available at the start");
           String p = JOptionPane.showInputDialog("Enter the price of the item at the start");
           int quantity = Integer.parseInt(q);
           double price = Double.parseDouble(p);
           
           // Date purchased
            dateP = JOptionPane.showInputDialog("Enter the date of purchase (ex. mm/dd/yyyy");
           
           // Create Manufacturer
           Manufacturer m = new Manufacturer(n,a); 
           
           // Create Product
           Product prod = new Product(m,n,quantity,price);
           
           // Add to database
           db.add(prod);
           
           break;

           
           //Update Product
             case "B":
                 nameM = JOptionPane.showInputDialog("Enter the name of Manufacturer");
                 nameI = JOptionPane.showInputDialog("Enter the name of the Product");
                 db.search(nameM,nameI);
                 if (!db.inList())
                     JOptionPane.showMessageDialog(null, "Product not found");
                 else 
                 {
                     option = JOptionPane.showInputDialog("What would you like to update\n"+"\nA: Update Quantity"+"\nB: Update Price");
                     Product pd = db.getProduct();
                     switch (option)
                     {
                         // Update Quantity 
                         case "A": 
                             String amt =  JOptionPane.showInputDialog("Enter the new a amount");
                             int quantityN = Integer.parseInt(amt);
                             pd.changeQuantity(quantityN);
                             JOptionPane.showMessageDialog(null, "Quantity has been updated");
                             break;
                         
                         // Update Price
                         case "B":
                            amt = JOptionPane.showInputDialog("Enter the new a amount");
                            double priceN = Double.parseDouble(amt);
                            pd.changePrice(priceN);
                            JOptionPane.showMessageDialog(null, "Price has been updated");

                            break;
                            
                        default:
                            JOptionPane.showMessageDialog(null, "Option not found. Return to Main Menu");
                                 break;
                             
                     }
                 }
                 break;
                 
            // Delete a product and add it to the closed database
             case "C":
                 nameM = JOptionPane.showInputDialog("Enter the name of Manufacturer");
                 nameI = JOptionPane.showInputDialog("Enter the name of the Product");
                 db.search(nameM,nameI);
                 if (!db.inList())
                     JOptionPane.showMessageDialog(null, "Product not found");
                 else 
                 {
                     Product pd = db.getProduct();
                     int index = db.getIndex();
                     dc.add(db.delete(index));           
                     JOptionPane.showMessageDialog(null, "Product has been deleted");
                     dateC = JOptionPane.showInputDialog("Enter date the item was deleted (ex. mm/dd/yyyy)");
                 }
                 break;
            
            // Displaying reports
             case "D":
                 option = JOptionPane.showInputDialog("What kind of report are you looking for\n"+"\nA: View a single Product"+"\nB: View Inventory"+"\nC: View discontinued Products");
                 switch (option)
                 {
                     // Report for single product
                     case "A":
                         nameM = JOptionPane.showInputDialog("Enter the name of Manufacturer");
                         nameI = JOptionPane.showInputDialog("Enter the name of the Product");
                         db.search(nameM,nameI);
                         if (!db.inList())
                            JOptionPane.showMessageDialog(null, "Product not found");
                        else 
                            {
                              Product prd = db.getProduct();
                              String s = "Product: \t"+prd.getManufacturer().getName().getName()+"\n"+"Item: \t"+prd.getManufacturer().getName().getItemName()+"\n"+"Quantity: \t"+prd.getQuantity()+"\n"+"Price: \t"+String.format("%.2f",prd.getPrice()) ;
                              JOptionPane.showMessageDialog(null, s);
                            }
                         break;
                     
                    // Report of inventory
                     case "B":
                        ArrayList list = db.getList();
                        if (list.isEmpty())
                            JOptionPane.showMessageDialog(null, "List is empty");
                        else
                        {
                            int i = 0;
                            int length = db.getSize();
                            String s = "Product   "+"Purchase Date    "+"Quantity    "+"Price    "+"Manufacturer    "+"State    ";
                            while (i < length)
                            {
                                Product prd = (Product)list.get(i);
                                s = s + "\n"+ prd.getManufacturer().getName().getItemName()+ "     "+ dateP +"     "+ prd.getQuantity()+ "     "+ String.format("%.2f",prd.getPrice()) +"     "+ prd.getManufacturer().getName().getName()+ "     "+ prd.getManufacturer().getAddress().getAddress() ;
                                i++;
                            }
                            display(s,"Store Inventory", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        break;
                        
                      // Report of discontinued Products
                     case "C":
                       ArrayList closed = dc.getList();
                        if (closed.isEmpty())
                            JOptionPane.showMessageDialog(null, "List is empty");
                        else
                        {
                            int i = 0;
                            int length = dc.getSize();
                            String s = "Product   "+"Discontinued Date    "+"Quantity    "+"Manufacturer    ";
                            while (i < length)
                            {
                                Product prd = (Product)closed.get(i);
                                s = s + "\n"+ prd.getManufacturer().getName().getItemName()+ "     "+ dateC +"     "+ prd.getManufacturer().getName().getName();
                                i++;
                            }
                            display(s,"Discontinued Items", JOptionPane.INFORMATION_MESSAGE);
                            
                        }  
                        
                         
                     default:
                         JOptionPane.showMessageDialog(null, "Option not found. Return to Main Menu");
                 }
                 break;
        
             default :
                 JOptionPane.showMessageDialog(null, "Option not found. Return to Main Menu");
    }
         }
    
      

    }
}
    


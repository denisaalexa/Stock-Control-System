import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer 
{
    // instance variables - replace the example below with your own
    private int customerId;
    private String email;
    private int numberOfItems;
    private String lastProductBought;

    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        this.customerId = 0;
        this.email = "";
        this.numberOfItems = 0;
        this.lastProductBought = "";
    }
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(int customerId, String email, int numberOfItems, String lastProductBought)
    {
        // initialise instance variables
        this.customerId = customerId;
        this.email = email;
        this.numberOfItems = numberOfItems;
        this.lastProductBought = lastProductBought;
    }
    
    /**
     * getter for customer Id
     */
    public int getCustomerId()
    {
        return this.customerId;
    }
    
    /**
     * setter for customer Id 
     */
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }
    
    /**
     * getter for customer email
     */
    public String getEmail()
    {
        return this.email;
    }
    
    /**
     * setter for customer email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
       
    /**
     * getter for customer numberOfItems
     */
    public int getNumberOfItems()
    {
        return this.numberOfItems;
    }
    
    /**
     * setter for customer numberOfItems
     */
    public void setNumberOfItems(int numberOfItems)
    {
        this.numberOfItems = numberOfItems;
    }    

    /**
     * getter for customer lastProductBought
     */
    public String getLastProductBought()
    {
        return  this.lastProductBought;
    }
    
    /**
     * setter for customer lastProductBought
     */
    public void setLastProductBought(String lastProductBought)
    {
         this.lastProductBought = lastProductBought;
    } 
}

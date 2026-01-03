import java.util.Scanner;

/**
 * Write a description of class Medication here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GeneralMeds extends PharmaProducts
{
    // instance variables - replace the example below with your own
    private String medType;
    
    /**
     * Constructor for objects of class Medication
     */
    public GeneralMeds()
    {
        // initialise instance variables
        super();
        this.medType = "";
    }
    
    /**
     * Constructor for objects of class Medication
     */
    public GeneralMeds(int id, String name, String brand, double price, int stock, String expiryDate, String medType)
    {
        // initialise instance variables
        super(id, name, brand, price, stock, expiryDate);
        this.medType = medType;
    }
    
    /**
     * getter for product medType 
     */
    public String getMedType()
    {
        return this.medType;
    }
    
    /**
     * setter for product medType 
     */
    public void setMedType(String medType )
    {
        this.medType = medType;
    }
    
}

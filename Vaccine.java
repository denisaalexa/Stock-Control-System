import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Vaccine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vaccine extends PharmaProducts
{
    // instance variables - replace the example below with your own
    private String vaccineType;
    private ArrayList<String> diseases;
    private String coverageDuration;

    /**
     * Constructor for objects of class Vaccine
     */
    public Vaccine()
    {
        // initialise instance variables
        super();
        this.vaccineType = "";
        this.diseases = new ArrayList();
        this.coverageDuration = "";
    }

    /**
     * Constructor for objects of class Vaccine
     */
    public Vaccine(int id, String name, String brand, double price, int stock, String expiryDate, String vaccineType, ArrayList<String> diseases, String coverageDuration)
    {
        // initialise instance variables
        super(id, name, brand, price, stock, expiryDate);
        this.vaccineType = vaccineType;
        this.diseases = diseases;
        this.coverageDuration = coverageDuration;
    }

    /**
     * getter for product vaccine type  
     */
    public String getVaccineType()
    {
        return this.vaccineType;
    }

    /**
     * setter for product vaccine Type 
     */
    public void setVaccineType(String vaccineType )
    {
        this.vaccineType = vaccineType;
    }

    /**
     * getter for product diseases 
     */
    public ArrayList<String> getDiseases()
    {
        return this.diseases;
    }

    /**
     * setter for product diseases
     */
    public void setDiseases(ArrayList<String> vacDiseases)
    {
        for (String dis : vacDiseases) 
        {
            this.diseases.add(dis);
        }
    }


    /**
     * getter for product coverage duration   
     */
    public String getCoverageDuration()
    {
        return this.coverageDuration;
    }

    /**
     * setter for product coverage duration  
     */
    public void setCoverageDuration(String coverageDuration )
    {
        this.coverageDuration = coverageDuration;
    }
}

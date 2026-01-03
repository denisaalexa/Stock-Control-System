
/**
 * Write a description of class PharmaProducts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PharmaProducts
{
    // instance variables - replace the example below with your own
    private int productId;
    private String productName;
    private String productBrand;
    private double price;
    private int stock;
    private String expiryDate;
    
    /**
     * Constructor for objects of class PharmaProducts
     */
    public PharmaProducts()
    {
        this.productId = 0;
        this.productName = "";
        this.productBrand = "";
        this.price = 0;
        this.stock = 0;
        this.expiryDate = "";
    }
    
    /**
     * Constructor for objects of class PharmaProducts
     */
    public PharmaProducts(int id, String name, String brand, double price, int stock, String expiryDate)
    {
        // initialise instance variables
        this.productId = id;
        this.productName = name;
        this.productBrand = brand;
        this.price = price;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    /**
     * getter for proudct id
     */
    public int getProductId()
    {
        return this.productId;
    }
    
    /**
     * setter for product id
     */
    public void setProductId(int id)
    {
        this.productId = id;
    }
    
    /**
     * getter for product name
     */
    public String getProductName()
    {
        return this.productName;
    }
    
    /**
     * setter for product name
     */
    public void setProductName(String name)
    {
        this.productName = name;
    }
    
    /**
     * getter for product brand
     */
    public String getProductBrand()
    {
        return this.productBrand;
    }
    
    /**
     * setter for product name
     */
    public void setProductBrand(String brand)
    {
        this.productBrand = brand;
    }
    
    /**
     * getter for product price
     */
    public double getPrice()
    {
        return this.price;
    }
    
    /**
     * setter for product price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    /**
     * getter for product stock
     */
    public int getStock()
    {
        return this.stock;
    }
    
    /**
     * setter for product stock
     */
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    
    /**
     * getter for product expiry date 
     */
    public String getExpiryDate()
    {
        return this.expiryDate;
    }
    
    /**
     * setter for product Expiry Date
     */
    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }    
}

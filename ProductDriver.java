import java.util.*;
/**
 * Write a description of class productDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductDriver 
{
    // instance variables

    private boolean keepRunning;
    private final String staffPassword = "1234";
    private ArrayList<PharmaProducts> productsInfo;
    private int idxProductsInfo;
    private ArrayList<Customer> customersInfo;
    private int idxCustomersInfo;
    private String customerEmail;

    /**
     * Constructor for objects of class productDriver
     */
    public ProductDriver()
    {
        // initialise instance variables
        keepRunning = true;
        productsInfo = new ArrayList<PharmaProducts>();
        idxProductsInfo = 0;
        customersInfo = new ArrayList<Customer>();
        idxCustomersInfo = 0;
    }

    /**
     * 
     */
    public void start() 
    {
        System.out.println("\f");
        showCompanyIntro();
        showMainMenu();
        closeProgram();
    }

    public void closeProgram() 
    {
        System.out.println("\nThank you for your custom");
    }

    public void showCompanyIntro() 
    {
        System.out.println("=== Pharma Products - Stock Control System ===");
    }

    // 2.    Display Main Menu
    public void mainMenu() 
    {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Customer Menu");
        System.out.println("2. Staff Menu (password protected)");
        System.out.println("3. Exit System");
    }

    public void showMainMenu() 
    {
        Scanner input = new Scanner(System.in);
        while (keepRunning) 
        {
            mainMenu();
            String userInput = input.nextLine();
            selectMainMenu(userInput);
        }
    }

    public void selectMainMenu(String userInput) 
    {
        switch (userInput) 
        {
            case "1":
                showCustomerMenu();
                break;
            case "2":
                showStaffMenu();
                break;
            case "3":
                keepRunning = false;
                break;
            default:
                System.out.println("Invalid input!! Please select again");
        }
    }

    public void showCustomerMenu() 
    {
        Scanner input = new Scanner(System.in);
        // check customer email
        checkCustomerEmail();

        boolean inCustomerMenu = true;
        while (inCustomerMenu) 
        {
            customerMenu();
            String userInput = input.nextLine();
            inCustomerMenu = selectCustomerMenu(userInput);
        }
    }

    // 3.1.    If the user input option 1, Input customer email
    public void checkCustomerEmail()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your email address: ");
        // variable for customer email
        customerEmail = input.nextLine();

        // if customer doesn't exit added to the Customer array list
        if (!customerAlreadyExist(customerEmail))
        {
            addNewCustomer(customerEmail);
            System.out.println("Welcome to our shop " + customerEmail);
        }
        else 
        {
            System.out.println("Welcome back " + customerEmail);
        }
    }

    public void incrementIdxcustomersInfo()
    {
        idxCustomersInfo++;
    }

    public void addNewCustomer(String customerEmail)
    {
        // initialise new customer variable 
        Customer newCustomer = new Customer(idxCustomersInfo, customerEmail, 0, null);

        // add new customer to the array list
        customersInfo.add(newCustomer);

        // increment index for new customer
        incrementIdxcustomersInfo();
    }

    public boolean customerAlreadyExist(String customerEmail)
    {
        if (customersInfo.size() != 0) 
        {
            for (Customer c: customersInfo)
            {
                if (c.getEmail().equals(customerEmail))
                {
                    return true;
                }
            }
        }
        // return false if no customer found
        return false;
    }

    // 4.    Display Customer Menu
    public void customerMenu() 
    {
        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. Display all General Medicines for sale");
        System.out.println("2. Display all Vaccines for sale");
        System.out.println("3. Buy one or more General Medicine");
        System.out.println("4. Buy one or more Vaccine");
        System.out.println("5. Exit Customer menu");
    }

    // 4.6.     If option 5 is chosen, Exit back to main menu
    public boolean selectCustomerMenu(String userInput) 
    {
        switch (userInput) 
        {
            case "1":
                displayGeneralMedicines();
                break;
            case "2":
                displayVaccines();
                break;
            case "3":
                buyMedProducts();
                break;
            case "4":
                buyVaccineProducts();
                break;
            case "5":
                return false;
            default:
                System.out.println("Invalid input!! Please select again");
        }
        return true;
    }

    // 4.2.    If option 1 is chosen, Display all general Medicines for sale and its details
    public void displayGeneralMedicines()
    {
        if (productsInfo.size() > 0)
        {
            for (PharmaProducts product: productsInfo)
            {
                if (product instanceof GeneralMeds) 
                {
                    // Cast p to Med to access Med-specific methods
                    GeneralMeds med = (GeneralMeds) product;
                    System.out.println("Medicine: " + med.getProductName() + " | Brand: " + med.getProductBrand() + 
                        " | Price: £" + med.getPrice() + " | Stock: " + med.getStock() + " | Stock: " + med.getExpiryDate() +
                        " | Type: " + med.getMedType());                        
                }
            }   
        }
        else 
        {
            System.out.println("There are no items in stock");
        }
    }

    // 4.3.     If option 2 is chosen, Display all Vaccine for sale and its details
    public void displayVaccines()
    {
        if (productsInfo.size() > 0)
        {
            for (PharmaProducts product: productsInfo)
            {
                if (product instanceof Vaccine) 
                {
                    // Cast p to Med to access Med-specific methods
                    Vaccine vac = (Vaccine) product;
                    System.out.println("Vaccine: " + vac.getProductName() + " | Brand: " + vac.getProductBrand() + 
                        " | Price: £" + vac.getPrice() + " | Stock: " + vac.getStock() + " | Stock: " + vac.getExpiryDate() +
                        " | Type: " + vac.getVaccineType() + " | Diseases: " + vac.getDiseases().toString() + " | CoverageDuration: " + vac.getCoverageDuration());
                }
            }   
        }
        else 
        {
            System.out.println("There are no items in stock");
        }
    }

    public boolean verifyMedProductsInfo()
    {
        if (productsInfo.size() > 0)
        {
            for (PharmaProducts product: productsInfo)
            {
                if (product instanceof GeneralMeds) 
                {
                    return true;
                }
            }   
        }
        return false;
    }

    // 4.4.     If option 3 is chosen, Display buy one or more general meds
    public void buyMedProducts() 
    {
        Scanner input = new Scanner(System.in);
        if (verifyMedProductsInfo())
        {
            boolean inBuyMedProducts = true;

            while (inBuyMedProducts) 
            {
                System.out.println("Please enter the name of Medicine you would like to buy");
                String productName = input.nextLine();

                if (checkMedProduct(productName))
                {
                    getMedProduct(productName);

                    inBuyMedProducts = false;
                }
                else
                {
                    inBuyMedProducts = showProductNotFound();
                }
            }
        }
        else
        {
            System.out.println("There are no General Medicines items in stock");
        }
    }

    public int getMedProductStock(String productName) {
        for (PharmaProducts p: productsInfo)
        {
            if (p instanceof GeneralMeds) 
            {
                // Cast p to Med to access Med-specific methods
                GeneralMeds med = (GeneralMeds) p;

                if (med.getProductName().equals(productName))
                {
                    return med.getStock();
                }
            }
        }

        return 0;
    }

    public void getMedProduct(String product) {
        int currentStock = getMedProductStock(product);
        int quantity;

        if (currentStock == 0) 
        {
            System.out.println("Sorry, product " + product + " is currently out of stock.");

        }
        else
        {
            quantity = getQuantity();

            if (checkStock(quantity, currentStock)) {
                int newStock = process(quantity, currentStock);
                updateMedStock(product, newStock);

                updateCustomerInfo(customerEmail, product,quantity); 

                displayCustomerInfo(customerEmail, product,quantity);

                displayMedProductInfo(product);

                System.out.println("\nThank you for your purchase.");
            } else {
                System.out.println("\nOnly " + currentStock + " units available. Please select a lower quantity.");
                System.out.println("Would you still like to buy one or more General Medicine product?");
            }
        }
    }

    // 4.4.7.    Display General Medicine product details after purchase
    public void displayMedProductInfo(String productName)
    {
        for (PharmaProducts p: productsInfo)
        {
            if (p instanceof GeneralMeds) 
            {
                // Cast p to Med to access Med-specific methods
                GeneralMeds med = (GeneralMeds) p;

                if (med.getProductName().equals(productName))
                {
                    System.out.println("\nProduct Details:");
                    System.out.println("----------------");
                    System.out.println("Product id: \t" + med.getProductId());
                    System.out.println("Product Name: \t" + med.getProductName());
                    System.out.println("Product Brand: \t" + med.getProductBrand());
                    System.out.println("Price: \t\t" + med.getPrice());
                    System.out.println("Stock: \t\t" + med.getStock());
                    System.out.println("Expiry Date: \t" + med.getExpiryDate());
                    System.out.println("Medicine Type: \t" + med.getMedType());

                    break;
                }
            }
        }
    }
    
    // 4.5.    If option 4 is chosen, Display buy one or more Vaccine
    public void buyVaccineProducts() 
    {
        Scanner input = new Scanner(System.in);
        if (verifyVaccineProductsInfo())
        {
            boolean inBuyVaccineProducts = true;

            while (inBuyVaccineProducts) 
            {
                System.out.println("Please enter the name of Vaccine you would like to buy");
                String productName = input.nextLine();

                if (checkVaccineProduct(productName))
                {
                    getVaccineProduct(productName);

                    inBuyVaccineProducts = false;
                }
                else
                {
                    inBuyVaccineProducts = showProductNotFound();
                }
            }
        }
        else
        {
            System.out.println("There are no Vaccine items in stock");
        }
    }

    public boolean verifyVaccineProductsInfo()
    {
        if (productsInfo.size() > 0)
        {
            for (PharmaProducts product: productsInfo)
            {
                if (product instanceof Vaccine) 
                {
                    return true;
                }
            }   
        }
        return false;
    }

    public int getVaccineProductStock(String productName) {
        for (PharmaProducts p: productsInfo)
        {
            if (p instanceof Vaccine) 
            {
                // Cast p to vaccine to access vaccine-specific methods
                Vaccine vac = (Vaccine) p;

                if (vac.getProductName().equals(productName))
                {
                    return vac.getStock();
                }
            }
        }

        return 0;
    }

    public void getVaccineProduct(String product) 
    {
        int currentStock = getVaccineProductStock(product);
        int quantity;

        if (currentStock == 0) 
        {
            System.out.println("Sorry, product " + product + " is currently out of stock.");
        }
        else
        {
            quantity = getQuantity();

            if (checkStock(quantity, currentStock)) {
                int newStock = process(quantity, currentStock);
                updateVacStock(product, newStock);

                updateCustomerInfo(customerEmail, product,quantity); 

                displayCustomerInfo(customerEmail, product,quantity);

                displayVacProductInfo(product);

                System.out.println("\nThank you for your purchase.");
            } else {
                System.out.println("\nOnly " + currentStock + " units available. Please select a lower quantity.");
                System.out.println("Would you still like to buy one or more Vaccine product?");
            }
        }
    }

    // 4.5.7.    Display Vaccine product details after purchase
    public void displayVacProductInfo(String productName)
    {
        for (PharmaProducts p: productsInfo)
        {
            if (p instanceof Vaccine) 
            {
                // Cast p to vac to access Vaccine-specific methods
                Vaccine vac = (Vaccine) p;

                if (vac.getProductName().equals(productName))
                {
                    System.out.println("\nProduct Details:");
                    System.out.println("----------------");
                    System.out.println("Product id: \t" + vac.getProductId());
                    System.out.println("Product Name: \t" + vac.getProductName());
                    System.out.println("Product Brand: \t" + vac.getProductBrand());
                    System.out.println("Price: \t\t" + vac.getPrice());
                    System.out.println("Stock: \t\t" + vac.getStock());
                    System.out.println("Expiry Date: \t" + vac.getExpiryDate());
                    System.out.println("Vaccine Type: \t" + vac.getVaccineType());                   
                    System.out.println("Coverage Duration: \t" + vac.getCoverageDuration());

                    break;
                }
            }
        }
    }

    public void updateCustomerInfo(String customerEmail, String product, int quantity)
    {
        for (Customer c: customersInfo)
        {
            if (c.getEmail().equals(customerEmail))
            {
                c.setNumberOfItems(quantity);
                c.setLastProductBought(product);

                break;
            }
        }   
    }

    // 4.4.6.     Display customer details after purchase
    // 4.5.6.     Display customer details after purchase 
    public void displayCustomerInfo(String customerEmail, String product, int quantity)
    {
        System.out.println("\nCustomer details:");
        System.out.println("-----------------");
        System.out.println("Email: \t\t\t" + customerEmail);
        System.out.println("Last product bought: \t" + product);
        System.out.println("Number of items: \t" + quantity);
    } 

    public boolean checkStock(int quantity, int stock) 
    {
        return quantity <= stock;
    }

    public int process(int quantity, int stock) 
    {
        return stock - quantity;
    }

    public void updateMedStock(String product, int newStock)
    {
        for (PharmaProducts p: productsInfo)
        {
            if (p instanceof GeneralMeds) 
            {
                // Cast p to Med to access Med-specific methods
                GeneralMeds med = (GeneralMeds) p;

                if (med.getProductName().equals(product))
                {
                    med.setStock(newStock);

                    break;
                }
            }
        } 
    }

    public void updateVacStock(String product, int newStock)
    {
        for (PharmaProducts p: productsInfo)
        {
            if (p instanceof Vaccine) 
            {
                // Cast p to Med to access Med-specific methods
                Vaccine vac = (Vaccine) p;

                if (vac.getProductName().equals(product))
                {
                    vac.setStock(newStock);

                    break;
                }
            }
        } 
    }

    public int getQuantity() {
        Scanner input = new Scanner(System.in);
        int quantity = 0;
        boolean isValidQuanity = true;
        while (isValidQuanity) 
        {
            System.out.println("\nPlease enter quantity needed (positive number):");
            if (input.hasNextInt()) {
                quantity = input.nextInt();
                if (quantity > 0) {
                    isValidQuanity = false;
                } else {
                    System.out.println("\nQuantity must be greater than 0.\n");
                }

            } else {
                System.out.println("\nInvalid quantity enter. Please try again");
            }
            // clear the buffer
            input.nextLine();
        }
        return quantity;
    }

    public boolean showProductNotFound() {
        boolean inShowProductNotFound = true;
        boolean checkProductNameAgain = false;
        Scanner input = new Scanner(System.in);

        while (inShowProductNotFound) 
        {
            displayProductNotFoundMenu();

            String userInput = input.nextLine();

            switch (userInput) 
            {
                case "1":
                    checkProductNameAgain = true;
                    inShowProductNotFound = false;
                    break;
                case "2":
                    System.out.println("Exiting product purchase...");
                    inShowProductNotFound = false;
                    break;
                default:
                    System.out.println("Invalid input!! Please select again");
            }
        }

        return checkProductNameAgain;
    }

    public void displayProductNotFoundMenu()
    {
        System.out.println("\n=== Product not found ===");
        System.out.println("1. Please check the name and try again.");
        System.out.println("2. Exit Product not found");
    }

    public boolean checkMedProduct(String productName)
    {
        if (productsInfo.size() > 0)
        {
            for (PharmaProducts p: productsInfo)
            {
                if (p instanceof GeneralMeds) 
                {
                    // Cast p to Med to access Med-specific methods
                    GeneralMeds med = (GeneralMeds) p;

                    if (med.getProductName().equals(productName))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean checkVaccineProduct(String productName)
    {
        if (productsInfo.size() > 0)
        {
            for (PharmaProducts p: productsInfo)
            {
                if (p instanceof Vaccine) 
                {
                    // Cast p to Med to access Med-specific methods
                    Vaccine vac = (Vaccine) p;

                    if (vac.getProductName().equals(productName))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean enterStaffPassword(int attempts) {
        Scanner input = new Scanner(System.in);
        for (int idx = 0; idx < attempts; idx++) {
            System.out.print("Enter staff password: ");
            String password = input.nextLine();

            if (password.equals(staffPassword)) {
                return true;
            } else if (idx != attempts - 1) {
                System.out.println("Incorrect password. Try again.");
            }
        }
        return false;
    }

    public void showStaffMenu() {
        final int numberOfAttempts = 3;
        Scanner input = new Scanner(System.in);
        if (enterStaffPassword(numberOfAttempts)) {
            boolean inStaffMenu = true;
            while (inStaffMenu) {
                staffMenu();
                String userInput = input.nextLine();
                inStaffMenu = selectStaffMenu(userInput);
            }
        } else {
            System.out.println("Too many failed attempts. Returning to main menu");
        }
    }

    // 6.    Display Staff Menu
    public void staffMenu() {
        System.out.println("\n=== Staff Menu ===");
        System.out.println("1. Add a new type of table or chair to the stock list ");
        System.out.println("2. Display the list of customers and products they have bought");
        System.out.println("3. Update the stock level for an existing table or chair with a new delivery  ");
        System.out.println("4. View stock report");
        System.out.println("5. Exit staff menu");
    }

    public boolean selectStaffMenu(String userInput) {
        switch (userInput) {
            case "1":
                showAddNewProductMenu();
                break;
            case "2":
                listAllCustomers();
                break;
            case "3":
                updateProductStock();
                break;
            case "4":
                viewStockReport();
                break;
            case "5":
                return false;
            default:
                System.out.println("Invalid input!! Please select again");
        }
        return true; 
    }

    public void showAddNewProductMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean inAddNewProductMenu = true;

        while (inAddNewProductMenu) 
        {
            displayAddNewProductMenu();
            String userInput = input.nextLine();
            inAddNewProductMenu = selectAddNewProductMenu(userInput);
        }
    }

    // 6.2.    If Option 1 is chosen, display add new product menu
    public void displayAddNewProductMenu()
    {
        System.out.println("\n=== What type of product would you like to add? ===");
        System.out.println("1. Add General Medicine Product");
        System.out.println("2. Add Vaccine Product");
        System.out.println("3. Exit Add New Product Menu");    
    }

    public boolean selectAddNewProductMenu(String userInput)
    {
        switch (userInput) 
        {
            case "1":
                addGeneralMedToList();
                break;
            case "2":
                addVaccineToList();
                break;
            case "3":
                return false;
            default:
                System.out.println("Invalid input!! Please select again");
        }
        return true;        
    }

    public void incrementIdxProductsInfo()
    {
        idxProductsInfo++;
    }

    public String askForProductName()
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the product name: ");
        return input.nextLine();
    }

    public String askForBrandName()
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Brand name: ");
        return input.nextLine();
    }

    public double askForPrice()
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        double price = 0.0;
        boolean isValidQuanity = true;
        while (isValidQuanity) {
            System.out.println("\nPlease enter the price (positive number):");
            if (input.hasNextDouble()) 
            {
                price = input.nextDouble();
                if (price > 0.0) 
                {
                    isValidQuanity = false;
                } 
                else 
                {
                    System.out.println("\nPrice must be greater than 0.\n");
                }

            } 
            else 
            {
                System.out.println("\nInvalid price enter. Please try again");
            }
            // clear the buffer
            input.nextLine();
        }
        return price;
    }

    public int askForStock()
    {
        return getQuantity();
    }

    public String askForExpiryDate()
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Expiry Date: ");
        return input.nextLine();        
    }

    public String askForMedType()
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Med type: ");
        return input.nextLine();   
    }

    public ArrayList<String> askForDiseases() 
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Diseases that this vaccine is covering : ");

        String dis = input.nextLine();
        String[] result = dis.split(",");
        ArrayList<String> diseases = new ArrayList<String>();

        for (String res : result) 
        {
            diseases.add(res);
        }

        return diseases;
    }

    public String askForCoverageDuration()
    {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Coverage Duration: ");
        return input.nextLine();   
    }

    // 6.2.2.    if option 1 is chosen, display Add a new type of general medicine to the stock list
    public void addGeneralMedToList()
    {
        String productName = askForProductName();
        String brandName = askForBrandName();
        double price = askForPrice();
        int stock = askForStock();
        String expiryDate = askForExpiryDate();
        String medType = askForMedType();

        productsInfo.add(new GeneralMeds(idxProductsInfo, productName, brandName, price, stock, expiryDate, medType));

        // increment idxProductsInfo variable for next product that needs to be added
        incrementIdxProductsInfo();
        System.out.println("General Medicine Product added successfully!");
    }

    // 6.2.3.    if option 2 is chosen, display Add a new type of Vaccine to the stock list
    public void addVaccineToList()
    {
        String productName = askForProductName();
        String brandName = askForBrandName();
        double price = askForPrice();
        int stock = askForStock();
        String expiryDate = askForExpiryDate();
        String vacType = askForMedType();
        ArrayList<String> diseases = askForDiseases();
        String coverageDuration = askForCoverageDuration();

        productsInfo.add(new Vaccine(idxProductsInfo, productName, brandName, price, stock, expiryDate, vacType, diseases, coverageDuration));

        // increment idxProductsInfo variable for next product that needs to be added
        incrementIdxProductsInfo();
        System.out.println("Vaccine Product added successfully!");
    }

    // 6.3.     if option 2 is chosen, Display the list of customers and products they have bought
    public void listAllCustomers()
    {
        System.out.println("Customer List");
        System.out.println("----------------");

        if (customersInfo.size() > 0) 
        {
            for (Customer c: customersInfo)
            {
                System.out.println("---- Customer Details ----");
                System.out.println("Customer Email:" + c.getEmail());
                System.out.println("Last Product Bought:" + c.getLastProductBought());
                System.out.println("Total Number of Products Bought:" + c.getNumberOfItems());
                System.out.println("---------------------------");
                System.out.println();
            } 
        } 
        else 
        {
            System.out.println("There are currently no customers registered with us"); 
        }
    } 

    public void updateProductStock()
    {
        Scanner input = new Scanner(System.in);
        boolean inUpdateProductStockMenu = true;

        while (inUpdateProductStockMenu) 
        {
            displayUpdateProductStockMenu();
            String userInput = input.nextLine();
            inUpdateProductStockMenu = selectUpdateProductStockMenu(userInput);
        }
    }

    // 6.4.    if option 3 is chosen, display Update the stock level menu
    public void displayUpdateProductStockMenu()
    {
        System.out.println("\n=== What type of product would you like to Update? ===");
        System.out.println("1. Update General Medicine Product");
        System.out.println("2. Update Vaccine Product");
        System.out.println("3. Exit Update Product Menu");    
    }

    public boolean selectUpdateProductStockMenu(String userInput)
    {
        switch (userInput) 
        {
            case "1":
                updateGeneralMedStock();
                break;
            case "2":
                updateVaccineStock();
                break;
            case "3":
                return false;
            default:
                System.out.println("Invalid input!! Please select again");
        }
        return true;        
    }

    public void updateGeneralMedStock()
    {
        Scanner input = new Scanner(System.in);
        if (verifyMedProductsInfo())
        {
            boolean inUpdateGenMedStock = true;

            while (inUpdateGenMedStock) 
            {
                System.out.println("Please enter the name of Medicine you would like to update");
                String productName = input.nextLine();

                if (checkMedProduct(productName))
                {
                    int newStockDelivery = askForStock();

                    int initialStock = getMedProductStock(productName);

                    int newStock = calculateNewStock(initialStock, newStockDelivery);

                    updateMedStock(productName, newStock);

                    inUpdateGenMedStock = false;
                }
                else
                {
                    inUpdateGenMedStock = showProductNotFound();
                }
            }
        }
        else
        {
            System.out.println("There are no General Medicines items in stock");
        }    
    }

    public int calculateNewStock(int initialStock, int newStockDelivery) {
        return initialStock + newStockDelivery;
    }

    public void updateVaccineStock()
    {
        Scanner input = new Scanner(System.in);
        if (verifyVaccineProductsInfo())
        {
            boolean inUpdateVacStock = true;

            while (inUpdateVacStock) 
            {
                System.out.println("Please enter the name of Vaccine you would like to update");
                String productName = input.nextLine();

                if (checkVaccineProduct(productName)) 
                {
                    int newStockDelivery = askForStock();

                    int initialStock = getVaccineProductStock(productName);

                    int newStock = calculateNewStock(initialStock, newStockDelivery);

                    updateVacStock(productName, newStock);

                    inUpdateVacStock = false;
                }
                else
                {
                    inUpdateVacStock = showProductNotFound();
                }
            }
        }
        else
        {
            System.out.println("There are no Vaccine items in stock");
        }        
    }

    // 6.5.     if option 4 is chosen, display stock report
    public void viewStockReport() {
        if (productsInfo.size() > 0)
        {
            System.out.println("\n=== Current Stock Levels ===");
            for (PharmaProducts product: productsInfo)
            {
                System.out.println("Product: " + product.getProductName() + " stock " + product.getStock());
            }   
        }
        else 
        {
            System.out.println("There are no items in stock");
        }
    }

    public static void main(String[] args)
    {
        ProductDriver pd = new ProductDriver();
        pd.start();
    }
}

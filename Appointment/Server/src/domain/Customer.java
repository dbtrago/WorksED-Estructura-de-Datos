package domain;

import java.util.Date;

public class Customer
{
    public String id;
    private String names;
    private String lastNames;
    private Date birthDate;
    private CustomerType customerType;
    //----------------------------------------------------------------
    //Constructor
    public Customer ()
    {
        this.id = "";
        this.names = "";
        this.lastNames = "";
        this.birthDate = new Date();
        this.customerType = null;
    }
    public Customer (String id, String names, String lastNames, Date birthDate, CustomerType customerType)
    {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.customerType = customerType;
    }
    //----------------------------------------------------------------
    //Getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getLastNames() {
        return lastNames;
    }
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public CustomerType getCustomerType() {
        return customerType;
    }
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
    
}

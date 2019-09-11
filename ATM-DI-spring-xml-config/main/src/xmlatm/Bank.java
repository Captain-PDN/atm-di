package xmlatm;

import javaatm.Customer;
import javaatm.DataSource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A bank contains customers with bank accounts.
 */
public class Bank {

   private Map<Integer, javaatm.Customer> customers;
   private javaatm.DataSource dataSource;

   /**
    * Constructs a bank with no customers.
    */
   public Bank(javaatm.DataSource dataSource) {
      this.dataSource = dataSource;
      customers = new HashMap<Integer, javaatm.Customer>();
   }

   public void initializeCustomers() throws IOException {
      customers = dataSource.readCustomers();
   }
   /**
    * Adds a customer to the bank.
    * @param c the customer to add
    */
   public void addCustomer(javaatm.Customer c) {
      customers.put(c.getCustomerNumber(), c);
   }
   
   /** 
    * Finds a customer in the bank.
    * @param number a customer number
    * @return the matching customer, or null if no customer
    * matches
    */
   public Customer findCustomer(int number) {
	  return customers.get(number);
   }

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }
}

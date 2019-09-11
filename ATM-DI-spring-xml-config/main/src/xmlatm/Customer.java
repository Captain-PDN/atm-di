package xmlatm;

import javaatm.Account;

/**
 * A bank customer with a checking and a savings account.
 */
public class Customer {

   private int customerNumber;
   private int pin;
   private javaatm.Account account;

   /**
    * Constructs a customer with a given number and PIN.
    * @param customerNumber the customer number
    * @param pin the personal identification number
    * @param initialBalance initial balance for account
    */
   public Customer(int customerNumber, int pin, double initialBalance) {
      this.customerNumber = customerNumber;
      this.pin = pin;
      this.account = new javaatm.Account(initialBalance);
   }
   
   public int getCustomerNumber() {
	   return customerNumber;
   }
   
   /** 
    * Tests if this customer matches a customer number
    * and PIN.
    * @param inputPin a personal identification number
    * @return true if the customer number and PIN match
    */
   public boolean match(int inputPin) {
      return pin == inputPin;
   }
      
   /** 
    * Gets the account of this customer.
    * @return the account
    */
   public Account getAccount() {
      return account;
   }
}

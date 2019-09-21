package xmlDbATM;

import JDBC.DBConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSource {

    private DBConnection dbConnection;

    public DataSource(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, xmlDbATM.Customer> readCustomers() {
        Map<Integer, xmlDbATM.Customer> customers = new HashMap<Integer, xmlDbATM.Customer>();

        List<Customer> customersArrayList =  dbConnection.getCustomers();
        for (xmlDbATM.Customer cus:customersArrayList) {
            customers.put(cus.getCustomerNumber(), cus);
        }

        return customers;
    }
}

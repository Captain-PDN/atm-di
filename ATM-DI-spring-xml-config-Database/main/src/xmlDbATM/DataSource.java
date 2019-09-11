package xmlDbATM;

import JDBC.DBConnection;
import javaatm.Customer;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataSource {

    private DBConnection dbConnection;

    /**
     */
    public DataSource(String dbName) throws SQLException, ClassNotFoundException {
        dbConnection = new DBConnection();
        dbConnection.createConnection(dbName);
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, xmlDbATM.Customer> readCustomers() throws SQLException {
        Map<Integer, xmlDbATM.Customer> customers = new HashMap<Integer, xmlDbATM.Customer>();

        ArrayList<xmlDbATM.Customer> customersArrayList =  dbConnection.getCustomers();
        for (xmlDbATM.Customer cus:customersArrayList) {
            customers.put(cus.getCustomerNumber(), cus);
        }
        dbConnection.closeConnection();

        return customers;
    }
}

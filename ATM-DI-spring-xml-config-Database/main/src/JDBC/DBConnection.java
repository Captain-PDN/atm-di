package JDBC;

import xmlDbATM.Customer;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private Connection conn;

    public void createConnection(String dbName) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:"+dbName;
        conn = DriverManager.getConnection(dbURL);
    }

    public ArrayList<Customer> getCustomers() throws SQLException {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        String query = "Select * from Customers";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int number = resultSet.getInt(1);
            int pin = resultSet.getInt(2);
            int iniBalance = resultSet.getInt(3);

            Customer customer = new Customer(number, pin, iniBalance);
            customerList.add(customer);
        }
        return customerList;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}

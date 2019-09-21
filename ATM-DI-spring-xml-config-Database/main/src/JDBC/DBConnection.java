package JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import xmlDbATM.Customer;
import java.sql.*;
import java.util.List;

public class DBConnection {

    private JdbcTemplate jdbcTemplate;

    public DBConnection(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getCustomers(){
        String query = "Select * from Customers";
        return jdbcTemplate.query(query, new CustomerRowMapper());
    }

    class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            return new Customer(rs.getInt("CustomerNumber"),
                    rs.getInt("Pin"),
                    rs.getDouble("InitialBalance"));
        }
    }
}

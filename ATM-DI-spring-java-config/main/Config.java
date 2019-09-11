package java

import java.atm.ATM;
import java.atm.ATMSimulator;
import java.atm.Bank;
import java.atm.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config{
    @Bean
    public ATMSimulator atmSimulator(){
        return new ATMSimulator(atm());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

    @Bean
    public Bank bank(){
        return new Bank(dataSource());
    }

    @Bean
    public DataSource dataSource(){
        return new DataSource(filename)
    }

}
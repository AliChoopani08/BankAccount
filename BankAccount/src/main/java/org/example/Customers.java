package org.example;
import java.util.ArrayList;
import java.util.List;
public class Customers {

    String owner_name;
    int account_number;
    int balance;
    public List<String> transactions;
    Customers(String owner_name, int account_number, int balance){
        this.owner_name=owner_name;
        this.account_number=account_number;
        this.balance=balance;
        this.transactions=new ArrayList<>();
    }

    static Customers customer3=new Customers("فاطمه صادقی", 1387, 7000000);
    static Customers customer1=new Customers("علی چوپانی" , 2531, 3000000);
    static Customers customer2=new Customers("امیر زارعی", 3258, 5000000);


    Integer getPassword(){
        return account_number;
    }
    Bank bank=new Bank();
    String[] getServices(){
        return bank.serveces;
    }

}

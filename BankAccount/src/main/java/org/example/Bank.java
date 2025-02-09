package org.example;

import java.util.ArrayList;
import java.util.List;

class Bank{


    String owner_name;
    int account_number;
    int balance;
    public List<String> transactions;
    Bank(String owner_name, int account_number, int balance){
        this.owner_name=owner_name;
        this.account_number=account_number;
        this.balance=balance;
        this.transactions=new ArrayList<>();
    }

    static Bank customer3=new Bank("فاطمه صادقی", 1387, 7000000);
    static Bank customer1=new Bank("علی چوپانی" , 2531, 3000000);
    static Bank customer2=new Bank("امیر زارعی", 3258, 5000000);


    Integer getPassword(){
        return account_number;
    }


}
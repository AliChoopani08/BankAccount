package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;




import static java.lang.System.in;
import static java.lang.System.out;
import static org.example.Bank.*;

public class Customers {

    public String[] serveces={" 1 برداشت وجه,", " 2 واریز, "," 3 موجودی, "," 4 انتقال, "," 5 نمایش تاریخچه, ","6 تغییر رمز عبور"};
    Bank account = null;
    Bank account2=null;
    String servece=null;

        Random random=new Random();
        Scanner scanner=new Scanner(in);

        void enteringToAccount(){
            enterPassword();
            out.println("لطفا رمز پیامک شده را وارد کنید");
            Integer passwordMssaged = random.nextInt(10000);
            out.println( passwordMssaged+ "رمز پیامک شده: ");
            int passwordEnteredForMessage = scanner.nextInt();
            if (passwordMssaged.equals(passwordEnteredForMessage)) {
                assert account != null;
                out.println(account.owner_name + " وارد حساب خود شدید!");
            }
            out.println("لصفا خدمات مورد نظر خود را انتخاب کنید"+ Arrays.toString(serveces));
            int objServices=scanner.nextInt();
            for (int i=0; i<1; i++) {
                switch (objServices) {
                    case 1:
                        servece = serveces[0];   withdraw();
                        break;
                    case 2 :
                        servece = serveces[1];   deposit();
                        break;
                    case 3:
                        servece = serveces[2];    showStock();
                        break;
                    case 4:
                        servece = serveces[3];     transfer();
                        break;
                    case 5:
                        servece = serveces[4];     displaytInfo();
                        break;
                    case 6:
                        servece = serveces[5];    changePassword();
                        break;
                    default:
                        out.println("خدمات یافت نشد!");
                        break;

                }

            }}
        void enterPassword(){         //وارد کردن رمز
            out.println("لطفا رمز کارت خود را وارد کنید!");
            int passwordEntered = scanner.nextInt();
            if (customer1.getPassword().equals(passwordEntered)) {
                account = customer1;
            } else if (customer2.getPassword().equals(passwordEntered)) {
                account = customer2;
            } else if (customer3.getPassword().equals(passwordEntered)) {
                account = customer3;
            }
        }
        void withdraw () {    //برداشت وجه
            out.println("مبلق برداشت را وارد کنید");
            int amount =scanner.nextInt() ;
            if (amount < account.balance) {
                account.balance -= amount;
                out.println("مقدار برداشت:" + amount + "مانده:" + account.balance);
            } else
                out.println("موجودی کافی نیست!");
            account.transactions.add("برداشت از حساب:" + amount + "مانده:" + account.balance);
            returnOrCountinue();
        }


        void transfer() {    // انتقال
            out.println("شماره ی کارت مبدا را وارد کنید");
            int passwordEntered1 = scanner.nextInt();
            if (customer1.getPassword().equals(passwordEntered1)) {
                account = customer1;
            } else if (customer2.getPassword().equals(passwordEntered1)) {
                account = customer2;
            } else if (customer3.getPassword().equals(passwordEntered1)) {
                account = customer3;
            }
            out.println("شماره ی کارت مقصد را وارد کنید");
            int passwordEntered2 = scanner.nextInt();

            if (customer1.getPassword().equals(passwordEntered2)) {
                account2 = customer1;
            } else if (customer2.getPassword().equals(passwordEntered2)) {
                account2 = customer2;
            } else if (customer3.getPassword().equals(passwordEntered2)) {
                account2 = customer3;
            }
            out.println("مبلق مورد نظر را وارد کنید!");
            int amount = scanner.nextInt();
            if (amount < 1000000) {
                account.balance -= amount;
                account2.balance += amount;
                out.println("مبلق:" + amount + "به کارت به نام:" + account2.owner_name + " واریز شد.");
                customer1.transactions.add("مبلق" + amount + "به کارت" + account2.owner_name + "واریز شد.");
                customer2.transactions.add("مبلق" + amount + "از کارت" + account.owner_name + "دریافت شد.");
                out.println("مانده:" + account.balance);
            } else
                out.println("مبلق از محدوده برداشت روزانه گذشته است!");
            returnOrCountinue();
        }


        void changePassword () {     //تغییر رمز
            enterPassword();
            out.println("رمز جدید خود را وارد کنید");
            int newPassword = scanner.nextInt();
            account.account_number = newPassword;
            out.println("رمز جدید:" + newPassword);
            account.transactions.add("تغییر رمز عبور " + "رمز عبور جدید: " + newPassword);
            returnOrCountinue();
        }
        void deposit(){
            out.println("مبلق مورد نظر را وارد کنید");
            int amount=scanner.nextInt();
            if (amount < 3000000){
                account.balance+=amount;
            }else {
                out.println("مبلق از محدوده واریز روزانه گذشته است!");
        }returnOrCountinue();
}
        void showStock(){   //نمایش موجودی کارت
            out.println("موجودی کارت: "+account.balance+" تومان");
            returnOrCountinue();
        }

        void displaytInfo () {//نمایش تاریخچه و اطلاعات حساب
            enterPassword();
            out.println("نام صاحب حساب:" + account.owner_name + " " + "موجودی حساب: " + account.balance + " " + "تاریخچه تراکش: " + account.transactions);
            returnOrCountinue();
        }
        void returnOrCountinue() { //خارج شدن یا ادامه دادن
            out.println("بازگشت:0 " + " " + "ادامه:1");
            int chooseUser = scanner.nextInt();
            switch (chooseUser) {
                case 1:
                    enteringToAccount();
                    break;
                case 0:
                    out.println("کارت خود را دریافت کنید");  scanner.close();

            }
        }
    }














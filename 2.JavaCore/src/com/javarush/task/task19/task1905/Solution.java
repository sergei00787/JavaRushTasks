package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        MyContact contact = new MyContact();
        MyCustomer customer = new MyCustomer();
        
        DataAdapter myAdapter = new DataAdapter(customer, contact);
        System.out.println(myAdapter.getCountryCode());
        System.out.println(myAdapter.getDialString());
    }
    
    public static class MyContact implements Contact{
        public String getName(){
            return "Ivanov, Ivan";   
        }            

        public String getPhoneNumber(){
            return "+38(050)123-45-67";
        };  
    }
    
    public static class MyCustomer implements Customer{
        public String getCompanyName(){
            return "JavaRush Ltd.";  
        }

        public String getCountryName(){
            return "Ukraine";
        }
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        
        @Override
        public String getCountryCode() {
            for(Map.Entry<String, String> countryEntry: countries.entrySet()){
                if ( countryEntry.getValue().equals(customer.getCountryName())) {
                    return countryEntry.getKey();
                } 
            }
            return "";
        } 
        
        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }
        
        @Override
        public String getContactFirstName() {
            String[] nameStrings = contact.getName().split(", ");
            return nameStrings[1];
        } //For example: Ivan

        @Override
        public String getContactLastName() {
            String[] nameStrings = contact.getName().split(", ");
            return nameStrings[0];
        } //For example: Ivanov
        
        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
        } //For example: callto://+380501234567
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
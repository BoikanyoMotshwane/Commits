/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1lr;

import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Boikanyo
 */
   //inserting the class instances 
 class Login {
   //global variable on how to declare the variables needed for the login class
   //interger is used for the declaring the variables 
    int count;
    int Size = 10;
    String storedUser_Name;
    String storedPassword;
    String stored_phone; 
    String firstname;
    String surname;
    String user_name;
    String password;
    String phone;
   
    //data type methods are used in the code
    public boolean checkusername(String user_name)
    //Creating a return method to check username vaildation
     //if containing five characters long and a username 
       //if contains _ and if 
            
    {
        boolean isValid = user_name.length() == 5 && user_name.contains("_");
        if(isValid)
        {
            System.out.println("Username is successfully captured ");
            this.user_name = user_name;
            return true;
        }
        else
        {
          System.out.println("Username is incorrectly formatted; please ensure that your username contains an underscore(_) and is no more than five characters in length.");
            return false;  
        }
        
    }
    
    public boolean checkpasswordcomplexity(String password)
     // Validates password: min 8 chars, at least one digit, one uppercase, one special character
    {
        boolean lengthValid = password.length() >=8;
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasSpecialChar = Pattern.compile("[^a_zA-Z0-9]").matcher(password).find();

        boolean isValid = lengthValid && hasDigit && hasUpperCase && hasSpecialChar;
        if(isValid)
        {   
            System.out.println("Password successfully captured.");
            this.password = password;
            return true;
        }
        else
        {
            System.out.println("Password is not correctly formatted; please ensure it contains: a capital letter, number and a special characters($,%,&,*,@) and has eight or more characters.");
            return false;
        }
    }
    // Validates password: min 8 chars, at least one digit, one uppercase, one special character
    public boolean checkcellphone(String phone)
    {
     boolean isValid = phone.matches("^\\+\\d{2}\\d{9}$");
     if(isValid)
    {
        
        System.out.println("Cellphone Number successfully captured.");
        this.phone = phone;
        return true;   
    }  
    
    else
    {
        System.out.println("Cellphone number incorrectly formatted; ensure it is 10 digits longa or does not contain international code");
        return false;
    }
    }
     // Prompts user to register and stores credentials if all validations pass
    public void register_user()
   {
        try (Scanner register = new Scanner(System.in)) {
            System.out.println("\n====== REGISTER ======");
            System.out.println("Enter user_name");
            String user_name = register.nextLine();
            
            System.out.println("Enter password");
            String password = register.nextLine();
            System.out.println("Enter Cellphone number");
            String phone = register.nextLine();
            
            if(checkusername(user_name) && checkpasswordcomplexity(password) && checkcellphone(phone))
            {
                System.out.println("Registration Complete.");
                
            }
            else{
                System.out.println("Registration invalid. Please ensure all details entered are correctly formatted.");
            } 
            register.close();  
        }           
        
   }
    
   public void user_login()
   // Prompts user to log in and validates against stored credentials (max 3 attempts)
   {
        try (Scanner login = new Scanner(System.in)) {
            int attempts = 3;
            boolean success = false;
            if(storedUser_Name == null)
            {
                System.out.println("No user registered yet.");
                
            }
            System.out.println("\n====== LOGIN ======");
            
            while (attempts > 0 && !success) {
                System.out.println("Enter user_name");
                String user_name = login.nextLine();
                System.out.println("Enter password");
                String password = login.nextLine();
                System.out.println("Enter Cellphone number");
                String phone = login.nextLine();
                //Equals() it compares the string values 
                if(user_name.matches(storedUser_Name) && password.matches(storedPassword) && phone.equals(stored_phone)){
                    System.out.println("Login Successful. Welcome back!");
                    success =true;
                    
                }
                else{
                    attempts --;
                    if(attempts > 0){
                        System.out.println("Invalid details. Attempts left: " + attempts);
                        success = false;
                    }
                }
                if(!success){
                    System.out.println("Too many failed attempts. Account is now blocked.");
                }
                login.close();
                
    
                
                
            }  
        }
   }
}    
    
    
    
   
public class Poepart1LR {

    public static void main(String[] args) {
        //Linking the instant class
       try (Scanner menu = new Scanner(System.in)) {
           //Linking the instant class
            Login account =new Login();
            //Store the user information
            int choice;
            //A while loop is included to run the loop at least once before checking the condition
            //A Menu system is created for including the choice to the user for registering or even logging in
            do{
                System.out.println("\n======MENU======");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Enter Menu option");
                choice = menu.nextInt();
                switch(choice){
                    case 1 -> account.register_user();
                    case 2 -> account.user_login();
                    case 3 -> System.out.println("Goodbye.");
                    default -> System.out.println("Invalid choice");
                }
                
            }
            while(choice!=3);{
            account.register_user();
            account.user_login();
        }
        }
                
                
        
    }
 }

  
package Weekly_Assignment_Online_Voating_System;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User_Manager
{
   // Admin_Manager adminManager = new Admin_Manager();
    List<User> loginUsers ;
    Scanner sc = new Scanner(System.in);
    public User_Manager() {
        loginUsers= new ArrayList<>();
    }
    public void Register() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv", true));
            System.out.println("Enter user ID:");
            String userId = sc.nextLine();
            System.out.println("Enter user name:");
            String userName = sc.nextLine();
            System.out.println("Enter user age:");
            String userAge = sc.nextLine();
            System.out.println("Enter user phone number:");
            String userPhoneNumber = sc.nextLine();
            System.out.println("Enter user date of birth (DD-MM-YYYY):");
            String userDOB = sc.nextLine();

            // Write user details to the CSV file
            writer.write(userId + "," + userName + "," + userAge + "," + userPhoneNumber + "," + userDOB + System.lineSeparator());
            writer.close();

            System.out.println("User registered successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while registering user: " + e.getMessage());
        }
    }

    // Method for user login
    public String Login() throws LoginException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        String userID = scanner.nextLine();
        System.out.println("Enter password (Date of Birth - DD-MM-YYYY):");
        String password = scanner.nextLine();

        boolean userFound = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5 && userData[0].equals(userID) && userData[4].equals(password)) {
                    userFound = true;
                    break;
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("User database file not found.");
        }

        if (!userFound) {
            throw new LoginException("Invalid user ID or password.");
        }

        return userID;
    }
    public void LogOut() {
        System.out.println("log out successfully !! ");

    }
    public void View_Profile(String userId) throws FileNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5 && userData[0].equals(userId)) {
                    System.out.println("User ID: " + userData[0]);
                    System.out.println("User Name: " + userData[1]);
                    System.out.println("User Age: " + userData[2]);
                    System.out.println("User Phone Number: " + userData[3]);
                    // Don't print the password
                    System.out.println("--------------------------");
                    return;
                }
            }
            System.out.println("User not found.");
        } catch (IOException e) {
            System.out.println("Error reading user data.");
            e.printStackTrace();
        }
    }
    public void changePassword(String userId) throws IOException {
        System.out.println("Enter new password:");
        String newPassword = sc.nextLine();

        File inputFile = new File("users.csv");
        File tempFile = new File("temp.csv");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 5 && userData[0].equals(userId)) {
                    // Replace the old password with the new one
                    bufferedWriter.write(userData[0] + "," + userData[1] + "," + userData[2] + "," + userData[3] + "," + newPassword + System.lineSeparator());
                } else {
                    bufferedWriter.write(line + System.lineSeparator());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file
        inputFile.delete();

        // Rename the temporary file to the original file name
        tempFile.renameTo(inputFile);

        System.out.println("Password changed successfully.");
    }

    // for register user
//    public void Register(Admin_Manager adminManager) {
//    //this.adminManager = adminManager;
//    }
//    public void Login() throws LoginException, FileNotFoundException {
//        System.out.println("enter user id :");
//        String userid = sc.nextLine();
//        System.out.println("enter user password :");
//        String userPassword = sc.nextLine();
//        boolean userFound = false;
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("users.csv"))){
//            String line;
//            while((line = bufferedReader.readLine())!= null){
//                String[] userData = line.split(",");
//                if(userData.length == 5){
//                    String csvUserId = userData[0];
//                    String csvUserName = userData[1];
//                    String csvUserAge = userData[2];
//                    String csvUserPhoneNumber = userData[3];
//                    String csvUserPassword = userData[4];
//                    if(userid.equals(csvUserId) && userPassword.equals(csvUserPassword)){
//                        //match found
//                        userFound = true;
//                        System.out.println("login successfully");
//                        break;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            // handle file reading error
//           e.printStackTrace();
//        }
//        if(!userFound)
//        {
//            throw new LoginException("User not found or invalid information provides");
//
//        }
//    }


}





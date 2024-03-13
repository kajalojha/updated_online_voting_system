package Weekly_Assignment_Online_Voating_System;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.Scanner;

public class Candidate_Manage
{
    Scanner sc = new Scanner(System.in);
    public void LoginCandidate() throws LoginException, FileNotFoundException {
        System.out.println("enter candidate id :");
        String candidate_id = sc.nextLine();
        System.out.println("enter password :");
        String candidate_password= sc.nextLine();
        System.out.println("enter partysymbol");
        String candidate_partySymbol = sc.nextLine();
        boolean candidateFound = false;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("candidate.csv"))){
            String line;
            while((line = bufferedReader.readLine())!= null){
                String[] candidateData = line.split(",");
                if(candidateData.length == 5){
                    String csvCandidate_Id = candidateData[0];
                    String csvCandidate_Name = candidateData[1];
                    String csvCandidate_partySymbol = candidateData[2];
                    String csvCandidate_age = candidateData[3];
                    String csvCandidate_Password = candidateData[4];
                    if(csvCandidate_Id.equals(candidate_id) && candidate_password.equals(csvCandidate_Password) && candidate_partySymbol.equals(csvCandidate_partySymbol))
                    {
                        //match found
                        candidateFound= true;
                        System.out.println("login successfully");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            // handle file reading error
            e.printStackTrace();
        }
        if(!candidateFound)
        {
            throw new LoginException("User not found or invalid information provides");

        }
    }
    public void deleteCandidate(String candidateId)
    {
        File inputFile = new File("candidate.csv");
        File tempFile = new File("result.csv");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] candidateData = line.split(",");
                if (candidateData.length == 5 && candidateData[0].equals(candidateId)) {
                    continue; // Skip the candidate to be deleted
                }
                bufferedWriter.write(line + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file
        inputFile.delete();

        // Rename the temporary file to the original file name
        tempFile.renameTo(inputFile);

        System.out.println("Candidate deleted successfully.");
    }
    public void viewCandidate()
    {
        System.out.println("Candidate List:");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("candidate.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] candidateData = line.split(",");
                if (candidateData.length == 5) {
                    String csvCandidate_Id = candidateData[0];
                    String csvCandidate_Name = candidateData[1];
                    String csvCandidate_partySymbol = candidateData[2];
                    String csvCandidate_age = candidateData[3];
                    String csvCandidate_Password = candidateData[4];

                    System.out.println("Candidate ID: " + csvCandidate_Id);
                    System.out.println("Candidate Name: " + csvCandidate_Name);
                    System.out.println("Party Symbol: " + csvCandidate_partySymbol);
                    System.out.println("Age: " + csvCandidate_age);
                    // Password is sensitive information, so we don't print it out
                    System.out.println("--------------------------");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Candidate data file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading candidate data.");
            e.printStackTrace();
        }
    }
    public void editCandidate(String candidateId)
    {
        File inputFile = new File("candidate.csv");
        File tempFile = new File("result.csv");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean candidateFound = false;

            while ((line = bufferedReader.readLine()) != null) {
                String[] candidateData = line.split(",");
                if (candidateData.length == 5 && candidateData[0].equals(candidateId)) {
                    // Candidate found, ask for new information
                    candidateFound = true;
                    System.out.println("Enter new candidate name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter new party symbol:");
                    String newPartySymbol = sc.nextLine();
                    System.out.println("Enter new age:");
                    String newAge = sc.nextLine();
                    // Write the updated information to the temporary file
                    bufferedWriter.write(candidateId + "," + newName + "," + newPartySymbol + "," + newAge + "," + candidateData[4] + System.lineSeparator());
                    break;
                } else {
                    // Write unchanged line to the temporary file
                    bufferedWriter.write(line + System.lineSeparator());
                }
            }

            if (!candidateFound) {
                System.out.println("Candidate with ID " + candidateId + " not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file
        inputFile.delete();

        // Rename the temporary file to the original file name
        tempFile.renameTo(inputFile);

        System.out.println("Candidate information updated successfully.");
    }
    }


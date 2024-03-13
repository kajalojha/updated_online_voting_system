package Weekly_Assignment_Online_Voating_System;
import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.*;

public class Admin_Manager {
    List<Admin> adminList;
    public List<User> userList;
    List<Candidate> candidateList;
    List<User> voatingcandidateList;

    public Admin_Manager() {
        adminList = new ArrayList<>();
        userList = new ArrayList<>();
        candidateList = new ArrayList<>();
        voatingcandidateList = new ArrayList<>();
    }

    Scanner sc = new Scanner(System.in);

    public void LogIn(String filepath) {
        System.out.println("enter id ");
        int admin_id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter name ");
        String admin_name = sc.nextLine();
        System.out.println("enter Password");
        int admin_password = sc.nextInt();
        Admin newadmin = new Admin(admin_id, admin_name, admin_password);
        adminList.add(newadmin);
        writeToCSVadmin(filepath);
        System.out.println("admin added successfully !");
    }

    public void writeToCSVadmin(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // Append mode
            //write admin data
            if (adminList.isEmpty()) {
                System.out.println("No admin data to write to CSV.");
                return;
            }
            for (Admin admin : adminList) {
                writer.append(String.valueOf(admin.getAdmin_id())).append(",");
                writer.append(admin.getAdmin_name()).append(",");
                writer.append(String.valueOf(admin.getAdmin_password())).append("\n");
            }
            System.out.println("Data entered successfully !");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    public void displayAdmin() {
        for (Admin admin : adminList) {
            System.out.println(admin);
            //adminList.add(admin);
        }
    }

    public void addUsers(String filepath) {
        System.out.println("enter user id");
        String userId = sc.nextLine();
        sc.nextLine();
        System.out.println("enter user name");
        String username = sc.nextLine();
        System.out.println("enter user age");
        int userage = sc.nextInt();
        sc.nextLine();
        System.out.println("enter user phonenumber");
        String userphonenumber = sc.nextLine();
        System.out.println("enter user password");
        String userPassword = sc.nextLine();
        User newusers = new User(userId, username, userage, userphonenumber, userPassword);
        userList.add(newusers);
        writeToCSVuser(filepath);
        System.out.println("user added successfully ! ");

    }

    public void writeToCSVuser(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // Append mode
            //write admin data
            if (userList.isEmpty()) {
                System.out.println("No admin data to write to CSV.");
                return;
            }
            for (User user : userList) {
                writer.append(String.valueOf(user.getUser_id())).append(",");
                writer.append(user.getUser_name()).append(",");
                writer.append(String.valueOf(user.getUser_age())).append(",");
                writer.append(user.getUser_phoneNumber()).append(",");
                writer.append(user.getUser_password()).append("\n");
            }
            System.out.println("Data entered successfully !");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    public void displayUser() {
        for (User users : userList) {
            System.out.println(users);
        }
    }

    public void LogOut() {
        System.out.println("log out successfully !! ");
    }

    public void changePassword(String filePath, String adminId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] adminData = line.split(",");
                if (adminData.length == 3 && adminData[0].equals(adminId)) {
                    System.out.println("Enter new password:");
                    String newPassword = sc.nextLine();
                    writer.write(adminData[0] + "," + adminData[1] + "," + newPassword + "\n");
                    System.out.println("Password changed successfully.");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File oldFile = new File(filePath);
        File newFile = new File("result.csv");
        oldFile.delete();
        newFile.renameTo(oldFile);
    }

    public void addCandidate(String filepath) {
        System.out.println("enter candidate id :");
        String candidate_id = sc.nextLine();
        System.out.println("enter candidate name :");
        String candidate_name = sc.nextLine();
        System.out.println("enter candidate partySymbol :");
        String candidate_symbol = sc.nextLine();
        System.out.println("enter candidate age :");
        int candidate_age = sc.nextInt();
        sc.nextLine();
        System.out.println("enter candidate password :");
        String candidate_password = sc.nextLine();
        Candidate newcandidate = new Candidate(candidate_id, candidate_name, candidate_symbol, candidate_age, candidate_password);
        candidateList.add(newcandidate);
        writeToCSVcandidate(filepath);
        System.out.println("candidate added successfully : ");

    }

    public void writeToCSVcandidate(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // Append mode
            //write admin data
            if (candidateList.isEmpty()) {
                System.out.println("No candidate data to write to CSV.");
                return;
            }
            for (Candidate candidate : candidateList) {
                writer.append(candidate.getCandidate_id()).append(",");
                writer.append(candidate.getCandidate_name()).append(",");
                writer.append(candidate.getCandidate_PartySymbol()).append(",");
                writer.append(String.valueOf(candidate.getCandidate_age())).append(",");
                writer.append(candidate.getCandidate_password()).append("\n");
            }
            System.out.println("Data entered successfully !");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    public void deleteCandidate() {
        System.out.println("enter candidate id :");
        String candidate_id = sc.nextLine();
        System.out.println("enter candidate name :");
        String candidate_name = sc.nextLine();
        System.out.println("enter candidate password :");
        String candidate_pass = sc.nextLine();
        Candidate candidateToDelete = null;
        for (Candidate candidate : candidateList) {
            if (candidate_id.equals(candidate.getCandidate_id()) && candidate_pass.equals(candidate.getCandidate_password())) {
                candidateToDelete = candidate;
                break;
            }
        }
        if (candidateToDelete != null) {
            candidateList.remove(candidateToDelete);
            System.out.println("candidate deleted successfully");
        } else {
            System.out.println("candidate not found . please try again with correct id and password.");
        }
    }

    public void display_Candidate_Info() {
        for (Candidate candidate : candidateList) {
            System.out.println(candidate);
        }
    }


    public void add_voting_Candidate(String filePath) {
        System.out.println("Enter user id:");
        String userId = sc.nextLine();
        System.out.println("Enter user password:");
        String userPassword = sc.nextLine();
        System.out.println("Enter user age:");
        int userAge = sc.nextInt();
        sc.nextLine();

        try {
            if (userAge < 18) {
                throw new Exception("You are not eligible to vote. Please try again with another ID.");
            }

            boolean foundUser = false;
            boolean hasVoted = false;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.csv"))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData.length == 5) {
                        String csvUserId = userData[0];
                        String csvUserAge = userData[2];
                        String csvUserPassword = userData[4];
                        if (userId.equals(csvUserId) && userPassword.equals(csvUserPassword)) {
                            foundUser = true;
                            // Check if the user has already voted
                            for (User votingUser : voatingcandidateList) {
                                if (votingUser.getUser_id().equals(userId)) {
                                    hasVoted = true;
                                    break;
                                }
                            }
                            if (!hasVoted) {
                                voatingcandidateList.add(new User(userId, "", userAge, "", userPassword));
                                // Write user information to the voting candidate csv file
                                try (FileWriter writer = new FileWriter("voting_candidates.csv", true)) {
                                    writer.write(line);
                                    writer.write("\n");
                                }
                                System.out.println("You can vote...");
                            } else {
                                throw new Exception("You have already voted.");
                            }
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                // Handle file reading error
                e.printStackTrace();
            }
            if (!foundUser) {
                throw new Exception("Invalid user ID or password.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete_voting_Candidate() {
        System.out.println("enter user id :");
        String user_id = sc.nextLine();
        System.out.println("enter user age :");
        String user_age = sc.nextLine();
        System.out.println("enter user password :");
        String user_pass = sc.nextLine();
        User VotingcandidateToDelete = null;
        for (User candidate : voatingcandidateList) {
            if (user_id.equals(candidate.getUser_id()) && user_pass.equals(candidate.getUser_password())) {
                VotingcandidateToDelete = candidate;
                break;
            }
        }
        if (VotingcandidateToDelete != null) {
            voatingcandidateList.remove(VotingcandidateToDelete);
            System.out.println(" Voting candidate deleted successfully");
        } else {
            System.out.println(" Voting candidate not found . please try again with correct id and password.");
        }
    }

    public void edit_voting_Candidate() {
        System.out.println("Enter user ID to edit:");
        String userID = sc.nextLine();

        // Search for the user
        User userToEdit = null;
        int userIndex = -1;
        for (int i = 0; i < voatingcandidateList.size(); i++) {
            if (voatingcandidateList.get(i).getUser_id().equals(userID)) {
                userToEdit = voatingcandidateList.get(i);
                userIndex = i;
                break;
            }
        }

        if (userToEdit != null) {
            // Display current user information
            System.out.println("Current user information:");
            System.out.println(userToEdit);

            // Prompt admin for changes
            System.out.println("Enter new user name (or press Enter to skip):");
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                userToEdit.setUser_name(newName);
            }

            // Update the user in the CSV file
            updateVotingCandidateCSV();

            System.out.println("User information updated successfully.");
        } else {
            System.out.println("User with ID " + userID + " not found.");
        }
    }

    private void updateVotingCandidateCSV() {
        // Rewrite the entire CSV file with the updated information
        try (FileWriter writer = new FileWriter("voting_candidates.csv")) {
            for (User candidate : voatingcandidateList) {
                writer.write(candidate.toCSV());
                writer.write("\n");
            }
            System.out.println("Voting candidate CSV updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the voting candidate CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void voteForCandidate() {
        Scanner scanner = new Scanner(System.in);
        int incorrectAttempts = 0;

        while (incorrectAttempts < 3) {
            System.out.println("Enter your user ID:");
            String userID = scanner.nextLine();

            // Check if the user is eligible to vote
            boolean isEligibleToVote = checkEligibility(userID);

            if (isEligibleToVote) {
                // Display the list of candidates for voting
                displayCandidateList();
                System.out.println("Enter the party symbol of the candidate you want to vote for:");
                String partySymbol = scanner.nextLine();

                // Validate the party symbol and get the corresponding candidate
                Candidate selectedCandidate = getCandidateByPartySymbol(partySymbol);

                if (selectedCandidate != null) {
                    // Add the user to the list of voting candidates
                    voatingcandidateList.add(new User(userID, "", 0, "", ""));

                    System.out.println("Thank you for voting for " + selectedCandidate.getCandidate_name() + "!");
                    updateVotingCandidateCSV(); // Update the CSV file with the new vote
                    return; // Exit the method after successful vote
                } else {
                    System.out.println("Invalid party symbol.");
                }
            } else {
                System.out.println("You are not eligible to vote. Please try again with another ID.");
                incorrectAttempts++;
            }
        }

        // Block the user's account for 24 hours after 3 incorrect attempts
        System.out.println("You have exceeded the maximum number of incorrect attempts.");
        System.out.println("Your account is blocked for 24 hours.");
        // Code to block the user's account for 24 hours
        calculate_winner();// Call calculate_winner method after all users have voted
    }


    // Method to check if the user is eligible to vote
    private boolean checkEligibility(String userID) {
        // Your eligibility criteria logic here
        // For example, check if the user is in the userList
        for (User user : userList) {
            if (user.getUser_id().equals(userID)) {
                return true;
            }
        }
        return false;
    }

    // Method to display the list of candidates
    private void displayCandidateList() {
        System.out.println("List of candidates:");
        for (Candidate candidate : candidateList) {
            System.out.println(candidate.getCandidate_name() + " - Party Symbol: " + candidate.getCandidate_PartySymbol());
        }
    }

    // Method to get a candidate by their party symbol
    private Candidate getCandidateByPartySymbol(String partySymbol) {
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidate_PartySymbol().equalsIgnoreCase(partySymbol)) {
                return candidate;
            }
        }
        return null;
    }

    // Method to update the voting candidate CSV file
    // Method to update the voting candidate CSV file
    private void updateVotingCandidateCSV(String userId, String partySymbol) {
        try (FileWriter writer = new FileWriter("voting_candidates.csv", true)) {
            // Append the new vote to the CSV file
            writer.write(userId + "," + partySymbol + "\n");
            System.out.println("Voting record updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the voting candidate CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void calculate_winner() {
        Map<String, Integer> votesCount = new HashMap<>();

        // Count the votes for each candidate
        for (User candidate : voatingcandidateList) {
            String candidateId = candidate.getUser_id();
            votesCount.put(candidateId, votesCount.getOrDefault(candidateId, 0) + 1);
        }

        // Find the candidate with the highest number of votes
        int maxVotes = 0;
        String winningCandidateId = null;
        for (Map.Entry<String, Integer> entry : votesCount.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winningCandidateId = entry.getKey();
            }
        }

        // Get the winning candidate object
        Candidate winner = getCandidateByID(winningCandidateId);

        if (winner != null) {
            System.out.println("The winner is: " + winner.getCandidate_name() + " with " + maxVotes + " votes.");
        } else {
            System.out.println("No winner found.");
        }
    }

//     Candidate getCandidateByID(String candidateId) {
//         for (Candidate candidate : candidateList) {
//             if (candidate.getCandidate_id().equals(candidateId)) {
//                 return candidate;
//             }
//         }
//         return null;
//     }

    public void calculateWinner() {
        Map<String, Integer> votesCount = new HashMap<>();

        // Count the votes for each candidate
        for (User votingUser : voatingcandidateList) {
            String candidateId = votingUser.getUser_id();
            votesCount.put(candidateId, votesCount.getOrDefault(candidateId, 0) + 1);
        }

        // Find the candidate(s) with the highest number of votes
        int maxVotes = 0;
        List<String> winningCandidates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : votesCount.entrySet()) {
            int votes = entry.getValue();
            if (votes > maxVotes) {
                maxVotes = votes;
                winningCandidates.clear();
                winningCandidates.add(entry.getKey());
            } else if (votes == maxVotes) {
                // In case of a tie, add the candidate to the list of winners
                winningCandidates.add(entry.getKey());
            }
        }

        // Check if there's at least one winner
        if (!winningCandidates.isEmpty()) {
            // Display the winner(s)
            System.out.print("Winner(s): ");
            for (String candidateId : winningCandidates) {
                Candidate winner = getCandidateByID(candidateId);
                if (winner != null) {
                    System.out.print(winner.getCandidate_name() + ", ");
                }
            }
            System.out.println("with " + maxVotes + " votes.");
        } else {
            System.out.println("No winner found. No votes were cast.");
        }
    }
        private Candidate getCandidateByID(String candidateId) {
            for (Candidate candidate : candidateList) {
                if (candidate.getCandidate_id().equals(candidateId)) {
                    return candidate;
                }
            }
            return null;
        }
            public void updateResult(String resultFilePath, String newResult) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFilePath, true))) {
                    writer.write(newResult);
                    writer.newLine();
                    System.out.println("Result updated successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//
           public void viewResult(String resultFilePath) {
                try (BufferedReader reader = new BufferedReader(new FileReader(resultFilePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



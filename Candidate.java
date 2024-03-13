package Weekly_Assignment_Online_Voating_System;


import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Candidate{

  Scanner sc = new Scanner(System.in);
  private String candidate_id;
    private String candidate_name;
    private String candidate_PartySymbol;
    private int candidate_age;
  private String candidate_password;

    public Candidate(String candidate_id ,String candidate_name,String candidate_PartySymbol,int candidate_age,String candidate_password){
      this.candidate_id = candidate_id;
      this.candidate_name = candidate_name;
      this.candidate_PartySymbol = candidate_PartySymbol;
      this.candidate_age = candidate_age;
      this.candidate_password = candidate_password;
    }

  public String getCandidate_id() {
    return candidate_id;
  }

  public void setCandidate_id(String candidate_id) {
    this.candidate_id = candidate_id;
  }

  public String getCandidate_name() {
    return candidate_name;
  }

  public void setCandidate_name(String candidate_name) {
    this.candidate_name = candidate_name;
  }

  public String getCandidate_PartySymbol() {
    return candidate_PartySymbol;
  }

  public void setCandidate_PartySymbol(String candidate_PartySymbol) {
    this.candidate_PartySymbol = candidate_PartySymbol;
  }

  public int getCandidate_age() {
    return candidate_age;
  }

  public String getCandidate_password() {
    return candidate_password;
  }

  public void setCandidate_password(String candidate_password) {
    this.candidate_password = candidate_password;
  }

  public void setCandidate_age(int candidate_age) {
    this.candidate_age = candidate_age;
  }

  public String toString(){
      return ("candidate id :" + candidate_id +"\n" + "candidate name :" + candidate_name +"\n" +"candidate partySymbol :"
              + candidate_PartySymbol +"\n"+"candidate age :" + candidate_age +"\n" +"candidate password :" + candidate_password + "\n" );
  }






}

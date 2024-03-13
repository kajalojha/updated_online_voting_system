package Weekly_Assignment_Online_Voating_System;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String user_id ;
    private String user_name ;
    private int user_age ;
    private String user_phoneNumber ;
    private String user_password;

    public User(String user_id,String user_name,int user_age,String user_phoneNumber,String user_password ){
        this.user_id = user_id;
        this.user_age = user_age;
        this.user_name = user_name;
        this.user_phoneNumber = user_phoneNumber;
        this.user_password = user_password;

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phoneNumber() {
        return user_phoneNumber;
    }


    public void setUser_phoneNumber(String user_phoneNumber) {
        this.user_phoneNumber = user_phoneNumber;
    }
    public String toString(){
        return ("user id :" + user_id +"\n"+"user name: "+user_name +"\n" + "user age :" + user_age  +"\n"+
                "user phonenumber :" + user_phoneNumber +"\n" + "user password:" + user_password+ "\n");
    }
    public String toCSV() {
        return String.format("user id :" + user_id +"\n"+"user name: "+user_name +"\n" + "user age :" + user_age  +"\n"+
                "user phonenumber :" + user_phoneNumber +"\n" + "user password:" + user_password+ "\n");
    }

}

package Weekly_Assignment_Online_Voating_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin
{
    private int admin_id;
    private String admin_name;
    private int admin_password;

    public Admin(int admin_id , String admin_name, int admin_password)
    {
        this.admin_id =admin_id;
        this.admin_name = admin_name;
        this.admin_password =admin_password;

    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public int getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(int admin_password) {
        this.admin_password = admin_password;
    }
    public String toString() {
    return ("admin id :" + admin_id + "\n" + "admin name :" + admin_name +"\n"+ "admin password :" + admin_password);
    }



}

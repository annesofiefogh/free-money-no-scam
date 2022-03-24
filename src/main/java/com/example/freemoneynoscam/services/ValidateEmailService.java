package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.Repository;

public class ValidateEmailService {

    private Repository r = new Repository();

    public boolean isEmailValid(String email){
        if (email.contains("@") && email.contains(".")){
            //method that connects and submits data to table 'email_table'
            r.insertEmailToDB(email);
            return true;
        } else {
            return false;
        }
    }
}

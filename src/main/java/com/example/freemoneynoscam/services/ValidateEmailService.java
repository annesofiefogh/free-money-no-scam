package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.EmailRepository;

public class ValidateEmailService {

    EmailRepository er = new EmailRepository();

    public boolean isEmailValid(String email){
        if (email.contains("@") && email.contains(".")){
            //method that connects and submits data to table 'email_table'
            er.insertEmailToDB(email);
            return true;
        } else {
            return false;
        }
    }
}

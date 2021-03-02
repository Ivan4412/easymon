package com.meerkat.easymon.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAutherticator extends Authenticator {
    String username = "welkinrook@163.com";

    String password = "76712144";

    public EmailAutherticator() {
        super();
    }

    public EmailAutherticator(String user, String pwd) {
        super();
        username = user;
        password = pwd;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

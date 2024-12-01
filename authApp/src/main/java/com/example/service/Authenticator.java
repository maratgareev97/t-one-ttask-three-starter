package com.example.service;

public class Authenticator {
    private final AuthenticatorConfig config;

    public Authenticator(AuthenticatorConfig config) {
        this.config = config;
    }
    public boolean checkCredentials(String username, String password){
        if (config.getCorrectCredentials().containsKey(username)){
            return password.equals(config.getCorrectCredentials().get(username));
        } else return false;
    }
}

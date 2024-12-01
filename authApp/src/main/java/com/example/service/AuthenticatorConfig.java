package com.example.service;

import java.util.Map;

public class AuthenticatorConfig {
    private final Map<String,String> correctCredentials;

    public AuthenticatorConfig(Map<String, String> correctCredentials) {
        this.correctCredentials = correctCredentials;
    }

    public Map<String, String> getCorrectCredentials() {
        return correctCredentials;
    }
}

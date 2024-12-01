package org.example.service;

import com.example.service.Authenticator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class MainService implements CommandLineRunner {
    private final Authenticator authenticator;

    public MainService(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void run(String... args) throws Exception {
        if (authenticator.checkCredentials("root","0000")){
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }

        if (authenticator.checkCredentials("root","9999")){
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}

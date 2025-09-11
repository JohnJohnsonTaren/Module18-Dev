package com.example.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encoderPassword = encoder.encode("default");
        System.out.println("login username task 2.0: user");
        System.out.println("Encoded Password default: " + encoderPassword);

        String encodedPassword = encoder.encode("jdbcDefault");
        System.out.println("login username task 2.1*: user");
        System.out.println("Encoded Password jdbcDefault: " + encodedPassword);
    }
}

package com.itwillbs.utill;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawAdmin = "admin123";
        String rawUser  = "user123";
        String hashAdmin = encoder.encode(rawAdmin);
        String hashUser  = encoder.encode(rawUser);

        System.out.println("Raw admin pw: " + rawAdmin);
        System.out.println("Encoded admin pw: " + hashAdmin);
        System.out.println();
        System.out.println("Raw user pw: " + rawUser);
        System.out.println("Encoded user pw: " + hashUser);
    }
}

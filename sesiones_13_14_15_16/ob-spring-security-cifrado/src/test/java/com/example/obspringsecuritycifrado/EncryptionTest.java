package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt que genera su propio salt de 16 bytes
     *
     * El resultado de cifrar con bcrypt será un string 60 caracteres:
     *
     * $a versión
     * $10 fuerza (valor que va de 4 a 31, por defecto vale 10)
     * Los 22 siguientes caracteres son el salt generado
     */
    @Test
    void bcryptTest(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        boolean matches = passwordEncoder.matches("adminn", hashedPassword);
        System.out.println(matches);

    }

    @Test
    void bcryptCheckMultiplePasswords(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));

    }


    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));
    }

    @Test
    void argon() {
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));
    }

    @Test
    void scrypt() {
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));
    }


    @Test
    void springPasswordEncoders(){

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        // no seguro:
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

    }
}

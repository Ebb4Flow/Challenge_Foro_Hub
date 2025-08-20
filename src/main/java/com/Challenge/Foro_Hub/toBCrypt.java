package com.Challenge.Foro_Hub;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class toBCrypt {

    public static void main(String[] args) {

        /*Scanner texto = new Scanner(System.in);
        System.out.print("Escribe la contraseña que quieras convertir en hash de Bcrypt: ");
        String hash = texto.nextLine();
        System.out.println(new BCryptPasswordEncoder().encode(hash));
        texto.close();
        */

        System.out.println(new BCryptPasswordEncoder().encode("12345segura"));
        System.out.println(new BCryptPasswordEncoder().encode("claveSecreta"));
        System.out.println(new BCryptPasswordEncoder().encode("clave1"));
        System.out.println(new BCryptPasswordEncoder().encode("pass2025"));
    }
}

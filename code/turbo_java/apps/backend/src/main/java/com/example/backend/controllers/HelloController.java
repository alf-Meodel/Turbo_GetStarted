package com.example.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indique que cette classe est un contrôleur REST
public class HelloController {

    @GetMapping("/") // Définit un point d'entrée pour la route racine "/"
    public String sayHello() {
        return "Hello, World!";
    }
}

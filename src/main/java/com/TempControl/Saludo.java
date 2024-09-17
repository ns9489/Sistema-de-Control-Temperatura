package com.TempControl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class Saludo {

    @GetMapping("/hola")
    public String hola() {
        return "Hola, soy un saludo de Spring Boot!";
    }

    @GetMapping("/adios")
    public String adios() {
        return "Adiós, gracias por visitarnos!";
    }
}

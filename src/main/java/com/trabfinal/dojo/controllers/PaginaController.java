package com.trabfinal.dojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {
    @GetMapping("/preguntas")
    public String preguntas(){
        return "frames/preguntas";
    }

    @GetMapping("/contactos")
    public String contactos(){
        return "frames/contactos";
    }

}







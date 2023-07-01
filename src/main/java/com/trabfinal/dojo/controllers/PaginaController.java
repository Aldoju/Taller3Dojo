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

    @GetMapping("/principal")
    public String principal(){
        return "frames/principal";
    }
    @GetMapping("/eventos")
    public String evento(){
        return "frames/eventos";
    }
}







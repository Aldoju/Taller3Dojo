package com.trabfinal.dojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "Login/login"; // Devuelve la vista del formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Verifica si el usuario y la contraseña son válidos
        if (username.equals("admin") && password.equals("password")) {
            return "frames/preguntas"; // Redirige al dashboard en caso de éxito
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Vuelve a mostrar el formulario de login con un mensaje de error
        }
    }
}

package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMvcController {


    // 1ER PASO: OBTENER EL FORMULARIO EN EL FRONTEND (HTML)
    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "user-form";
    }

    // 2º PASO: RECIBIR EL FORMULARIO CON LOS DATOS RELLENOS
    @PostMapping("/users")
    public String save(@ModelAttribute("user") UserDTO user){
        System.out.println(user);
        return "congratulations";
    }
}

package com.Moreno.post1_u10.controller;

import com.Moreno.post1_u10.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TareaViewController {

    private final TareaService service;

    public TareaViewController(TareaService service) {
        this.service = service;
    }

    @GetMapping("/tareas")
    public String vistaTareas(Model model) {
        model.addAttribute("tareas", service.listarTodas());
        return "tareas";
    }
}
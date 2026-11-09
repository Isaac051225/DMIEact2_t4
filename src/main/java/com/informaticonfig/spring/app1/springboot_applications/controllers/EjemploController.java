package com.informaticonfig.spring.app1.springboot_applications.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.informaticonfig.spring.app1.springboot_applications.models.Empleados;
import org.springframework.ui.Model;


@Controller 
public class EjemploController {


    @Value("${config.nombre}")
    private String nombreConfig;

    @Value("${config.proyecto}")
    private String proyectoConfig;


    @GetMapping("/Actividad2")
    public String info(Model model){
        Empleados empleado1 = new Empleados("Isaac","Diaz","Calle Benito Juarez S/N","estudiante",
                                              20, 123456789, 001);
        model.addAttribute("Empleado", empleado1);

        // Simplemente agregas estas dos líneas a tu método actual:
        model.addAttribute("UsuarioConfig", nombreConfig);
        model.addAttribute("ProyectoConfig", proyectoConfig);


        return "detalles_info";
    }



    @ModelAttribute("Empleados")
    public List<Empleados> ListaEmpleados(){
        return Arrays.asList(
          new Empleados("Araceli", "Gomez", "Calle Independencia", "Secretaria", 48, 12345678, 02),
          new Empleados("María", "Perez", "Calle segunda no.2", "Secretaria", 20, 123654987, 02),
          new Empleados("Juan", "Rodriguez", "Calle primera no.1", "Gerente", 35, 123456789, 01),
          new Empleados("Luis", "Martínez", "Calle tercera no.3", "Contador", 28, 987654321, 03),
          new Empleados("Ana", "González", "Avenida central no.4", "Diseñadora", 30, 456789123, 04),
          new Empleados("Pedro", "Sánchez", "Boulevard no.5", "Analista", 25, 789123456, 05)
        );
    }


    @PostMapping("/nuevo-empleado")
    public String guardarEmpleado(@ModelAttribute("Empleado") Empleados empleado, Model model) {
    model.addAttribute("Empleado", empleado);
    return "detalles_info";
}

}

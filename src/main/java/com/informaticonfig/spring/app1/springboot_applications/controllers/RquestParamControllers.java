
package com.informaticonfig.spring.app1.springboot_applications.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/parametros")
public class RquestParamControllers {

    @GetMapping("/detalle")
    public ParametroDTO detalle(@RequestParam (required = false, defaultValue = "hola a todos") String informacion){
        ParametroDTO parametro1 = new ParametroDTO();
        parametro1.setInformacion(informacion);
        return parametro1;
    }

    // Nuevo endpoint para recibir y devolver una lista de elementos
    @GetMapping("/lista")
    public ParametroDTO listaParametros(
            @RequestParam(required = false) List<String> valores) {
        
        ParametroDTO parametro = new ParametroDTO();
        
        if (valores == null || valores.isEmpty()) {
            parametro.setListaInformacion(Arrays.asList("Empleado 1", "Empleado 2", "Empleado 3"));
        } else {
            parametro.setListaInformacion(valores);
        }
        
        return parametro;
    }   
}

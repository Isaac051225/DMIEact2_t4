package com.informaticonfig.spring.app1.springboot_applications.controllers;

import java.util.List;

/**
 * ParametroDTO
 */
public class ParametroDTO {
    private String informacion;
    private List<String> listaInformacion;

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public List<String> getListaInformacion() {
        return listaInformacion;
    }

    public void setListaInformacion(List<String> listaInformacion) {
        this.listaInformacion = listaInformacion;
    }
    

}

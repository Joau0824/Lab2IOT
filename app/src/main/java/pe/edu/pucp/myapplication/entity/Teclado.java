package pe.edu.pucp.myapplication.entity;

import java.io.Serializable;

public class Teclado implements Serializable {

    public Teclado(String activo, String activoPC, String marca, String anio, String idioma, String modelo) {
        this.activo = activo;
        this.activoPC = activoPC;
        this.marca = marca;
        this.anio = anio;
        this.idioma = idioma;
        this.modelo = modelo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getActivoPC() {
        return activoPC;
    }

    public void setActivoPC(String activoPC) {
        this.activoPC = activoPC;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String activo;
    public String activoPC;
    public String marca;
    public String anio;
    public String idioma;
    public String modelo;


}

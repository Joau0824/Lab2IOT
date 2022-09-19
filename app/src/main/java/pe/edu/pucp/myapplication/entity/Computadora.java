package pe.edu.pucp.myapplication.entity;

import java.io.Serializable;

public class Computadora implements Serializable {

    private String activo;
    private int marca;
    private int anho;
    private String CPU;

    public Computadora(String activo, int marca, int anho, String CPU) {
        this.activo = activo;
        this.marca =marca;
        this.anho = anho;
        this.CPU = CPU;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

}

package pe.edu.pucp.myapplication.entity;

import java.io.Serializable;

public class Monitor implements Serializable {

    public Monitor(String activo, String activoPC, String marca, Integer ano, Integer pulgadas, String modelo) {
        this.activo = activo;
        this.pcActivo = pcActivo;
        this.marca = marca;
        this.ano = ano;
        this.pulgadas = pulgadas;
        this.modelo = modelo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public int getPcActivo() {
        return pcActivo;
    }

    public void setPcActivo(int pcActivo) {
        this.pcActivo = pcActivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    private String activo;
    private int  pcActivo;
    private String marca;
    private int pulgadas;
    private int ano;
    private String modelo;

}

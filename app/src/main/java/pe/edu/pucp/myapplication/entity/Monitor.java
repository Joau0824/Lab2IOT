package pe.edu.pucp.myapplication.entity;

import java.io.Serializable;

public class Monitor implements Serializable {

    public String activo;
    public String pc;
    public String marca;
    public String pulgada;
    public Integer ano;
    public String modelo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPulgada() {
        return pulgada;
    }

    public void setPulgada(String pulgada) {
        this.pulgada = pulgada;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

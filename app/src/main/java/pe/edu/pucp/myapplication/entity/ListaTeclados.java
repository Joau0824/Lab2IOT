package pe.edu.pucp.myapplication.entity;

import java.util.ArrayList;

public class ListaTeclados {

    public static ArrayList<Teclado> listaTeclados= new ArrayList<>();

    public static ArrayList<Teclado> getListTeclados() {
        return listaTeclados;
    }

    public static void agregarTeclado(Teclado teclado){
        listaTeclados.add(teclado);
    }

    public static void eliminarTeclado(Teclado teclado){
        listaTeclados.remove(teclado);
    }

    public static Integer obtenerActivo(String activo){
        for(Teclado tec: listaTeclados){
            if(tec.getActivo().equalsIgnoreCase(activo)){return listaTeclados.indexOf(tec);}
        }
        return null;
    }

}

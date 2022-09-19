package pe.edu.pucp.myapplication.entity;

import java.util.ArrayList;

import pe.edu.pucp.myapplication.entity.Computadora;

public class listaComputadoras {

    public static ArrayList<Computadora> listaComputadoras= new ArrayList<>();

    public static ArrayList<Computadora> getListaComputadoras(){return listaComputadoras;}

    public static void agregarComputadora(Computadora computadora){listaComputadoras.add(computadora);}

    public static void borrarComputadora(Computadora computadora){listaComputadoras.remove(computadora);}


    public static ArrayList<String> buscarComputadora(String equipo){
        ArrayList<String> equipos = new ArrayList<>();
        String listar ="";
        for(Computadora computadora : listaComputadoras){
            if(computadora.getActivo().equalsIgnoreCase(equipo)){
                listar ="";
                listar +="Activo: " +computadora.getActivo()+"\n";
                listar +="Marca: " +computadora.getMarca()+"\n";
                listar +="Año: " +computadora.getAnho()+"\n";
                listar +="CPU: " +computadora.getCPU()+"\n";
                equipos.add(listar);
                return equipos;
            }
        }
        return equipos;
    }

    public static ArrayList<String> componentesComputadora(){
        ArrayList<String> listaequipos = new ArrayList<>();
        String listar ="";
        for(Computadora computadora : listaComputadoras){
            listar ="";
            listar +="Activo: " +computadora.getActivo()+"\n";
            listar +="Marca: " +computadora.getMarca()+"\n";
            listar +="Año: " +computadora.getAnho()+"\n";
            listar +="CPU: " +computadora.getCPU()+"\n";
            listaequipos.add(listar);
            return listaequipos;
        }
        return listaequipos;
    }

    //para buscar una computadora
    public static Integer obtenerComputadora(String equipo){
        for(Computadora computadora: listaComputadoras){
            if(computadora.getActivo().equalsIgnoreCase(equipo)){
                return listaComputadoras.indexOf(computadora);
            }
        }
        return null;
    }

}

package pe.edu.pucp.myapplication.entity;

import java.util.ArrayList;

import pe.edu.pucp.myapplication.entity.Computadora;

public class listaComputadoras {

    public static ArrayList<Computadora> listaComputadoras= new ArrayList<>();

    public static ArrayList<Computadora> getListaComputadoras(){return listaComputadoras;}

    private static String marcas(int iterar){
        String marcas[] = new String[]{
                "MAC","LG", "SAMSUNG", "ASUS", "DELL","REDMI","ZETA", "HP", "Otro"
        };
        return marcas[iterar];
    }

    public static void anadirComputadora(Computadora computadora){
        listaComputadoras.add(computadora);
    }

    public static int posicionActivo(String activo){
        for(int i = 0; i<listaComputadoras.size(); i++){
            if(listaComputadoras.get(i).getActivo().equals(activo)){
                return i;
            }
        }
        return -1;
    }



    public static ArrayList<String> buscarComputadora(String pc){
        ArrayList<String> listpc = new ArrayList<>();
        String listarpc ="";
        for(Computadora computadora : listaComputadoras){
            if(computadora.getActivo().equalsIgnoreCase(pc)){
                listarpc ="";
                listarpc +="Activo: " +computadora.getActivo()+"\n";
                listarpc +="Marca: " +computadora.getMarca()+"\n";
                listarpc +="Año: " +computadora.getAnho()+"\n";
                listarpc +="CPU: " +computadora.getCPU()+"\n";
                listpc.add(listarpc);
                return listpc;
            }
        }
        return listpc;
    }

    public static void ActualizarComputadora(int posicion,Computadora computadoraIngresada){

        Computadora computadoraActualizada= pe.edu.pucp.myapplication.entity.listaComputadoras.getListaComputadoras().get(posicion);
        computadoraActualizada.setActivo(computadoraIngresada.getActivo());
        computadoraActualizada.setMarca(computadoraIngresada.getMarca());
        computadoraActualizada.setAnho(computadoraIngresada.getAnho());
        computadoraActualizada.setCPU(computadoraIngresada.getCPU());

    }

    public static void borrarComputadora(Computadora computadora){
        listaComputadoras.remove(computadora);
    }

    public static ArrayList<String> ComputadoraVistaPrincipal(){
        ArrayList<String> listacomponentes=new ArrayList<>();
        String componentes = "";
        for(Computadora computadora: listaComputadoras){
            componentes="";
            componentes+="Activo: "+computadora.getActivo()+"\n";
            componentes+="Marca: "+marcas(computadora.getMarca()+0)+"\n";
            componentes+="Año: "+computadora.getAnho()+"\n";
            componentes+="CPU: "+computadora.getCPU()+"\n";
            listacomponentes.add(componentes);
        }
        return listacomponentes;
    }

}

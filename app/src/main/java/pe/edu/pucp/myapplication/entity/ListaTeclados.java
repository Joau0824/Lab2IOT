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

    public static ArrayList<String> searchTeclado(String activo){
        ArrayList<String> ret = new ArrayList<>();
        String desc = "";
        for(Teclado tecl : listaTeclados){
            if(tecl.getActivo().equalsIgnoreCase(activo)){
                desc="";
                desc+="Activo: "+tecl.getActivo()+"\n";
                desc+="PC: "+tecl.getActivoPC()+"\n";
                desc+="Marca: "+tecl.getMarca()+"\n";
                desc+="Año: "+tecl.getAnio()+"\n";
                desc+="Idioma"+tecl.getIdioma()+"\n";
                desc+="Modelo: "+tecl.getModelo()+"\n";
                ret.add(desc);
                return ret;
            }
        }
        return ret;
    }


    public static ArrayList<String> descripTeclados(){
        ArrayList<String> listaTecl = new ArrayList<>();
        String desc = "";
        for(Teclado tecl : listaTeclados){
            desc="";
            desc+="Activo: "+tecl.getActivo()+"\n";
            desc+="PC: "+tecl.getActivoPC()+"\n";
            desc+="Marca: "+tecl.getMarca()+"\n";
            desc+="Año: "+tecl.getAnio()+"\n";
            desc+="Idioma"+tecl.getIdioma()+"\n";
            desc+="Modelo: "+tecl.getModelo()+"\n";
            listaTecl.add(desc);
        }
        return listaTecl;
    }

}
